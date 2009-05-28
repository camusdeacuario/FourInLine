
public class Partida {
	
	int modo;
	String estado;
	Jugador jugador1;
	Jugador jugador2;
	Tablero tablero;
	
	Partida(int modo)
	{
		jugador1 = new Jugador('X',"Jugador1");
		this.modo = modo;	
		tablero = new Tablero(6,7);		
		configurarJuego();	
	}

	public void configurarJuego()
	{
		if(modo == 1)
			jugador2 = new Jugador('@',"Jugador2");
		else
			jugador2 = new JugadorInteligente('@',"Maquina");
		iniciarJuego();					
	}

	public void iniciarJuego() {
		
		jugador1.setTurno(true);	
		while(!terminaElJuego())
		{
			Interfaz.imprimeTablero(tablero.getFormaDeImpresion());
			if(jugador1.tieneElTurno())
			    lanzaJugador1();
			else
				lanzaJugador2();
			Interfaz.imprimeTablero(tablero.getFormaDeImpresion());			
		}
		
		
	}
	
	private void lanzaJugador2() {
		int columna = jugador2.pensarJugada(tablero);
		if(tablero.setFicha(columna, jugador2.getFicha()))
		{
			jugador2.setTurno(false);
			jugador1.setTurno(true);
		}
		
	}

	private void lanzaJugador1() {
		int columna = jugador1.pensarJugada(tablero);
		if(tablero.setFicha(columna, jugador1.getFicha()))
		{
			jugador1.setTurno(false);
			jugador2.setTurno(true);
		}
		
	}

	private boolean terminaElJuego()
	{	
			
		if(tablero.isFull())
		{
			Interfaz.printResultados("Ninguno");
			return true;
		}			
		if(tablero.existenFichasContiguas(4, jugador1.getFicha()))
		{
			Interfaz.printResultados(jugador1.getNombre());  
			return true;
		}
		if(tablero.existenFichasContiguas(4, jugador2.getFicha()))
		{
			Interfaz.printResultados(jugador2.getNombre());
			return true;
		}
		return false;
				
	}
	
	
	

}

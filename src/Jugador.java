
public class Jugador {

	private char ficha;
	private boolean turno;
	private String nombre;
	Jugador(char ficha, String nombre)
	{
		this.ficha = ficha;
		this.nombre = nombre;
	}
	public void setTurno(boolean turno)
	{
		this.turno = turno;
	}
	public boolean tieneElTurno()
	{
		return turno;
	}
	public int pensarJugada(Tablero tablero)
	{
		Interfaz.printTurno(nombre,ficha);
		return Interfaz.leerTeclado(1,7);
	}
	public char getFicha() {
		
		return ficha;
	}
	public String getNombre(){
		return nombre;
	}
	
}

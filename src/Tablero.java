


public class Tablero {
	private char tablero[][];
	private int  posicionUltimaFicha[];
	//private int  jugada;
	
	
	public Tablero(int alto, int ancho) {
		tablero = new char[alto][ancho];
		//posicionUltimaFicha contiene la ultima posicion vacia en cada una de las filas empezando del final
		posicionUltimaFicha = new int []{5,5,5,5,5,5,5}; //son 6 filas en el tablero pero las posiciones van del 0 al 5
		inicializarTablero();
		
	}

	private void inicializarTablero()
	{
		for(int i=0; i<tablero.length; i++)
		{
			//asignar posiciones vacias a todas la filas en el tablero
			tablero[i]= "OOOOOOO".toCharArray();			 
		}
	}
	//obtiene el total de fichas en el tablero sin importar de que jugador sea
	public int numeroDeFichas()
	{		
		int totalFichas = 0;
		for(int i=0; i<posicionUltimaFicha.length; i++)
			totalFichas += 5 - posicionUltimaFicha[i]; //si no hay fichas entonces devuelve cero
		return totalFichas;
	}

	public int getAlto() {
	
		return tablero.length;
	}
	public int getAncho()
	{
		return tablero[0].length;
	}
	
	public String getFormaDeImpresion() {
		
		String formaDeTablero = "1 2 3 4 5 6 7" + "\n";
		for(int i=0; i<tablero.length; i++)
		{
			formaDeTablero += obtenerFilaDeTablero(i);
		}		
		return formaDeTablero;
	}
	public String obtenerFilaDeTablero(int fila)
	{
		int i;
		String filaTablero="";
		for(i=0; i<tablero[fila].length-1; i++)
		{
			filaTablero += tablero[fila][i] + " "; //concatena un espacio a cada elemento
		}
		filaTablero += tablero[fila][i] + "\n"; //concatena un salto de linea para la impresion
		return filaTablero;
	}

	private boolean validarColumna(int columna)
	{
		if(columna > 7 || columna < 1 ) 
			return false;		
		return existePosicionVacia(columna);
	}
	public boolean setFicha(int columna, char ficha) {
		
		if(!validarColumna(columna))
			return false;		
		tablero[posicionUltimaFicha[columna-1]--][columna-1]= ficha;	
		return true;
		
		
	}
	public boolean isEmpty() {
		
		return numeroDeFichas()== 0;
	}
	public boolean isFull()
	{
		return numeroDeFichas()== 42;
	}
	public boolean existenFichasContiguas(int cantidad, char ficha)
	{						
		String fichasABuscar = juntarFichas(cantidad, ficha);
		
		if(existenFichasContiguasHorizontal(fichasABuscar))
			return true;
		if(existenFichasContiguasVertical(fichasABuscar))
			return true;
		if(existenFichasContiguasDiagonal(fichasABuscar,3) || existenFichasContiguasDiagonal(fichasABuscar,-3))
			return true;	
		return false;
	}
	
	
	private String juntarFichas(int cantidad, char ficha) {
		String fichas= "";		
		for(int i=0; i<cantidad; i++)
			fichas+= ficha;
		return fichas;
	}
	public boolean existenFichasContiguasHorizontal(String fichasABuscar) {
		
		for(int i=tablero.length-1; i>=0; i--)
		{
			String cadenaCompara = String.copyValueOf(tablero[i]);			
			if(cadenaCompara.indexOf(fichasABuscar)!= -1)
			{
				return true;
			}
		}
		return false;		
	}
	private boolean existenFichasContiguasVertical(String fichasABuscar) {
		
		for(int i=0; i<tablero[0].length; i++) //recorrer columnas
			if(fichasEnColumna(i).contains(fichasABuscar))
				return true;	
		return false;
	}
	
	private String fichasEnColumna(int columna) {
		String fichasDeColumna="";
		for(int j=0; j<tablero.length; j++) //recorrer filas
			fichasDeColumna+= tablero[j][columna];
		return fichasDeColumna;
	}
	private boolean existenFichasContiguasDiagonal(String fichasABuscar, int desde) {
								
		for(int i=desde; i<desde+6; i++)		
			if(fichasEnDiagonal(i).contains(fichasABuscar))
				return true;		
		return false;
	}
	
	private String fichasEnDiagonal(int i) {
		String fichasDiagonal="";
		for(int j=0; j<tablero.length; j++)
		{
			for(int x=0; x<tablero[0].length;x++)
				if(j+x == i || j-x == i)
					fichasDiagonal += tablero[j][x];										
		}
		return fichasDiagonal;
	}
	
	public void setTablero(char[][] tableroLleno) {
		
		for(int i=0; i<tablero.length; i++)
				tablero[i] = tableroLleno[i];				
		
	}
	
	public boolean existePosicionVacia(int columna) {
		
		return posicionUltimaFicha[columna-1]!= -1;
	
	}

	public void quitarFicha(int i) {
		posicionUltimaFicha[i-1]++;
		setFicha(i, 'O');
		posicionUltimaFicha[i-1]++;		
		
	}
	public char[][] getTablero()
	{
		char clone[][] = new char[6][7];
		for(int i=0; i<tablero.length; i++)
		{
			for(int j=0; j<tablero[0].length; j++)
				clone[i][j]= tablero[i][j];
		}
		return clone;
	}
	
	

}

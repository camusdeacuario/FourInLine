import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestTablero {
	Tablero tablero;
	@Before
	public void miSetup()
	{
		tablero = new Tablero(6,7);
	}
	@After
	public void imprimir()
	{
		System.out.println(tablero.getFormaDeImpresion());
	}
	
	@Test
	public void alCrearUnTableroEsteDebeEstarVacio()
	{
		assertTrue(tablero.isEmpty());
	}
	@Test
	public void laDimensionDelTableroDebeSerDeSeisPorSiete()
	{
		assertEquals(6,tablero.getAlto());
		assertEquals(7,tablero.getAncho());
	}
	/*@Test
	public void losMetodosParaObtenerAlturaYAnchoDevuelvenLaDimensionVerdaderaDelTablero()
	{
		Tablero tableroDePrueba = new Tablero(4,3);
		assertEquals(4, tableroDePrueba.getAlto());
		assertEquals(3, tableroDePrueba.getAncho());		
	}*/
	@Test
	public void elTableroSeImprimeEnPantallaComoSeEspera()
	{
		String tableroAdecuado = "1 2 3 4 5 6 7" + "\n" + 
								 "O O O O O O O" + "\n" +
								 "O O O O O O O" + "\n" +
								 "O O O O O O O" + "\n" +
								 "O O O O O O O" + "\n" +
								 "O O O O O O O" + "\n" +
								 "O O O O O O O" + "\n" ;		
		assertEquals(tableroAdecuado, tablero.getFormaDeImpresion());	
		
	}
	@Test 
	public void seDebePoderInsertarUnaFichaEnLaColumnaSeleccionada()
	{
		assertTrue(tablero.setFicha(3,'*')); // inserta ficha en la columna 3		
	}
	@Test 
	public void alInsertarUnaFichaElTableroSeImprimeComoSeEsperaConLaFichaEnLaPosicionCorrecta()
	{
		String tableroEsperado = "1 2 3 4 5 6 7" + "\n" + 
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O * O O O O" + "\n" ;	
		tablero.setFicha(3,'*');
		assertEquals(tableroEsperado, tablero.getFormaDeImpresion());
		
	}
	@Test
	public void alInsertarDosElementosElTableroSeImprimeComoSeEspera()
	{
		String tableroEsperado = "1 2 3 4 5 6 7" + "\n" + 
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O * O @ O O" + "\n" ;	
		tablero.setFicha(3,'*');
		tablero.setFicha(5,'@');
		assertEquals(tableroEsperado, tablero.getFormaDeImpresion());
			
	}
	@Test
	public void alInsertarUnaNuevaFichaEstaNoDebeReemplazarANingunOtraFicha()
	{
		String tableroEsperado = "1 2 3 4 5 6 7" + "\n" + 
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O O O O O O" + "\n" +
		 						 "O O @ O O O O" + "\n" +
		 						 "O O * O O O O" + "\n" ;
		
		tablero.setFicha(3,'*');
		tablero.setFicha(3,'@');
		assertEquals(2,tablero.numeroDeFichas());
		assertEquals(tableroEsperado, tablero.getFormaDeImpresion());
		
	}
	@Test
	public void elRangoDeColumnasDondeSePuedeInsertarEstaEntreUnoYSiete(){
		assertFalse(tablero.setFicha(0, '*'));
		assertFalse(tablero.setFicha(8, '@'));		
	}
	@Test
	public void seDebePermitirInsertar6FichasEnUnaColumnaPeroLaSeptimaInsercionDebeSerNegada()
	{
		int columna = 2;
		assertTrue(tablero.setFicha(columna, '*'));
		assertTrue(tablero.setFicha(columna, '*'));
		assertTrue(tablero.setFicha(columna, '*'));
		assertTrue(tablero.setFicha(columna, '*'));
		assertTrue(tablero.setFicha(columna, '*'));
		assertTrue(tablero.setFicha(columna, '*'));
		assertEquals(6, tablero.numeroDeFichas());
		assertFalse(tablero.setFicha(columna, '*'));
	}
	@Test
	public void seDebePoderInsertar42FichasYElTableroDeberiaEstarLleno()
	{
	    
		for(int i=1; i<=7; i++) //columnas
			for(int j=1; j<=6; j++)	 //filas
				assertTrue(tablero.setFicha(i, '*'));
		assertTrue(tablero.isFull());				
		
	}
	@Test
	public void elTableroEncuentraSiExisten4FichasContiguasHorizontalmente()
	{
		tablero.setFicha(2, '*');
		tablero.setFicha(3, '*');
		tablero.setFicha(4, '*');
		tablero.setFicha(5, '*');
		assertTrue(tablero.existenFichasContiguas(4,'*'));			
	}
	@Test
	public void elTableroEncuentraSiExisten4FichasContiguasVerticalmente()
	{
		tablero.setFicha(2, '*');
		tablero.setFicha(2, '*');
		tablero.setFicha(2, '*');
		tablero.setFicha(2, '*');
		assertTrue(tablero.existenFichasContiguas(4,'*'));			
	}
	@Test
	public void elTableroEncuentraSiExisten4FichasContiguasEnDiagonalPrimaria()
	{
		char matriz[][] = {{'O','O','O','O','O','O','O'},
						   {'O','O','O','O','O','O','O'},
						   {'O','O','O','O','O','O','*'},
						   {'O','O','O','O','O','*','@'},
						   {'O','O','O','O','*','@','@'},
						   {'O','O','O','*','@','@','@'}};	
		tablero.setTablero(matriz);	
		assertTrue(tablero.existenFichasContiguas(4,'*'));			
	}
	@Test
	public void elTableroEncuentraSiExisten4FichasContiguasEnDiagonalSecundaria()
	{
		char matriz[][] = {{'O','O','O','O','O','O','O'},
						   {'O','O','O','O','O','O','O'},
						   {'*','O','O','O','O','O','O'},
						   {'@','*','O','O','O','O','O'},
						   {'@','@','*','O','O','O','O'},
						   {'@','@','@','*','O','O','O'}};	
		tablero.setTablero(matriz);	
		assertTrue(tablero.existenFichasContiguas(4,'*'));			
	}
	@Test
	public void elTableroEsCapazDeDeterminarLaCantidadDeFichasContiguas()
	{
		tablero.setFicha(7, '@');
		tablero.setFicha(7, '@');
		assertTrue(tablero.existenFichasContiguas(2,'@'));
		assertFalse(tablero.existenFichasContiguas(4,'@'));		
	}
	
	
	
	
	

}
hello world

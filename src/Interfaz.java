import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Interfaz {

	public static int leerTeclado(int minimo, int maximo) {
		
		int valorLeido=-1;
		do{
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			try 
			{
				valorLeido = Integer.parseInt(teclado.readLine());
			} 
			catch (IOException e)
			{				
				e.printStackTrace();
			}
		}while(valorLeido < minimo || valorLeido > maximo);
		return valorLeido;
	}
	

	public static void printTurno(String jugador, char ficha) {		
		
		System.out.println("Turno de " + jugador + "[" + ficha + "]");	
	}


	public static void imprimeTablero(String estructura) {
		
		for(int i=0; i<20; i++)
			System.out.println();
		System.out.println(estructura);
	}


	public static void printResultados(String ganador) {
		
		System.out.println(ganador + " Gana");
		
	}


	public static void printMenuPrincipal() {
		System.out.println("-----------------------Menu----------------\n" +
						   "1.Humano Vs Humano\n" +
						   "2.Humano Vs Maquina\n"+
						   "opcion:");
		
	}
	

}

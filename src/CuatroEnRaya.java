
public class CuatroEnRaya {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interfaz.printMenuPrincipal();
		int tipoPartida = Interfaz.leerTeclado(1, 2);
		Partida partida = new Partida(tipoPartida);
		partida.iniciarJuego();
	}

}

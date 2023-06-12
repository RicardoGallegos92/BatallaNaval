package battleShip;

import java.util.Scanner;
/*
 * Cheat Codes
 * Z9 -> SALIR
 * M8 -> MOSTRAR BARCOS
*/

public class Juego {
	public static void jugar() {
		Scanner scan = new Scanner(System.in);
		Tablero campoJuego = new Tablero();
		String entradaCoordenadas;
		int x, y;
		System.out.println("Barcos debiesen estar creados");

		campoJuego.mostrarTableroConBarcos();
		campoJuego.mostrarTablero();
/*
		for ( Barco barco : campoJuego.getListaBarcos() ) {
			barco.mostrarCordenadas();
		}
*/

		do {
			// Loop de juego
			do {
				System.out.println("Ingrese coordenadas de disparo");
				System.out.println("XY = [A-H][1-8]");
				System.out.println("Ejemplo : B3");
				entradaCoordenadas = scan.nextLine().trim();
			} while ( entradaCoordenadas.length() > 2 );
			// Se piden coordenadas en pares

			x = (int) entradaCoordenadas.charAt(0) - 65;
			y = (int) entradaCoordenadas.charAt(1) - 49;

			// ¿ Coordenadas válidas ?
			if ( x >= 0 && x < 8
					&& y >= 0 && y < 8) {
				campoJuego.revisarImpacto( x, y);
			}
			System.out.println( "Queda(n) "
				+ campoJuego.getListaBarcos().size() + " barco(s) aún" );
		} while ( campoJuego.getListaBarcos().size() > 0
						&& x != 25 && y != 8);
		// Jugamos hasta que no queden barcos o ingresen Z9
		if ( campoJuego.getListaBarcos().size() == 0 ) {
			System.out.println("Felicitaciones, ha hundido al enemigo");
		}
	}
}

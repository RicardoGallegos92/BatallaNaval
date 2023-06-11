package battleShip;

import java.util.Scanner;

public class Juego {
	public static void jugar() {
		Scanner scan = new Scanner(System.in);
		Tablero campoJuego = new Tablero();
		String entradaCoordenadas;
		int x, y;
		System.out.println("Barcos debiesen estar creados");
/*
		for (int i = 0; i < 6; ++i) {
			listaBarcos[i].mostrarCordenadas();
		}
*/
		campoJuego.mostrarTableroConBarcos(listaBarcos);
		campoJuego.mostrarTablero();
		do {
			do {
				System.out.println("Ingrese coordenadas de disparo");
				System.out.println("XY = [A-H][1-8]");
				System.out.println("Z9 para Salir");
				entradaCoordenadas = scan.nextLine();
			} while ( entradaCoordenadas.length() > 2 );
			
			x = (int) entradaCoordenadas.charAt(0) - 65;
			y = (int) entradaCoordenadas.charAt(1) - 49;
//			System.out.println("x: "+x+" y: "+y);
			if ( x >= 0 && x < 8
					&& y >= 0 && y < 8) {
				campoJuego.revisarImpacto( x, y, listaBarcos);
				}
			System.out.println("Queda(n) "+listaBarcos.length+ " barco(s) aún");
		} while ( listaBarcos.length > 0 && x != 25 && y != 8); // Loop de juego
	}
}

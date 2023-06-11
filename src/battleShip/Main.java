package battleShip;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		do {
			int opcion = Menu.menu();
			switch ( opcion ) {
			case 1:
				//System.out.println("Aquí va el juego");
				Juego.jugar();
				break;
			case 2:
				Menu.mostrarTop();
				break;
			case 3:
				System.out.printf("Finalizado");
				scan.close();
				return;
			default:
				System.out.printf("Inválido");
			}
			scan.nextLine();
		} while( true );
	}

}

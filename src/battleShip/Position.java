package battleShip;

import java.util.Random;
import java.util.ArrayList;

public class Position {

	public static void asignarPosicionInicial(ArrayList<Barco> listaBarcos, int i) {
		int ejeX, ejeY; 
		ejeX = new Random().nextInt( 8 ) ;
		ejeY = new Random().nextInt( 8 ) ;
/*
		System.out.println("Ejes iniciales");
		System.out.println("X: "+ejeX + " Y: " + ejeY);
		System.out.println("_____________");
*/
		if ( new Random().nextInt(100) % 2 == 1 ) {
//			System.out.println("Vertical");
			if ( ( ejeY - listaBarcos.get(i).getLongitud() ) > 0 ) {
//				System.out.println("to Arriba");
				asignarCoordenadas(listaBarcos.get(i), ejeX, ejeY, 0, -1);
			}else {
//				System.out.println("to Abajo");
				asignarCoordenadas(listaBarcos.get(i), ejeX, ejeY, 0, 1);
			}
		}else {
//			System.out.println("Horizontal");
			if ( ( ejeX - listaBarcos.get(i).getLongitud() ) < 0 ) {
//				System.out.println("to Derecha");
				asignarCoordenadas(listaBarcos.get(i), ejeX, ejeY, 1, 0);
			}else {
//				System.out.println("to Izquierda");
				asignarCoordenadas(listaBarcos.get(i), ejeX, ejeY, -1, 0);
			}	
		}
//				Reasignamos si hace falta
		if (colisiona(listaBarcos, i) ) {
			asignarPosicionInicial(listaBarcos, i);
		}
		
		
	}

	public static void asignarCoordenadas(Barco barquito, int inicioX,
											int inicioY, int pasoX, int pasoY) {
		for (int i = 0; i < barquito.getLongitud(); ++i) {
			barquito.setCoordenadas(
					inicioX + ( i * pasoX),
					inicioY + ( i * pasoY),
					i);
		}
	}
	
	public static boolean colisiona( ArrayList<Barco> listaBarcos, int ultimoBarco ) {
		int[][] nuevas = listaBarcos.get(ultimoBarco).getCoordenadas();
		int[][] anterior;
		for (int i = 0; i < ultimoBarco; ++i ) {
			anterior = listaBarcos.get(i).getCoordenadas();
			if ( compararCoordenadas(nuevas, anterior) ) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean compararCoordenadas(int[][] nueva, int[][] anterior) {
//		System.out.println(nueva[0].length +" OwO "+ anterior[0].length);
		for (int i = 0; i < nueva[0].length ; ++i) {
			for (int j = 0; j < anterior[0].length ; ++j) {
//				System.out.println( nueva[0][i] +" "+ nueva[1][i] +" vs "+ anterior[0][j] +" "+ anterior[1][j] );
				if ( nueva[0][i] == anterior[0][j]
					&& nueva[1][i] == anterior[1][j] ) {
//					System.out.println("Colision");
					return true;
				}
//				System.out.println("---------------");
			}
//			System.out.println("________________________");
		}
		return false;
	}

	public static ArrayList<Barco> crearBarcos() {
		ArrayList<Barco> listaBarcos = new ArrayList<Barco>();
		listaBarcos.add(new Fragata("SS Shigeshi"));
		listaBarcos.add(new Fragata("SS Koichi"));
		listaBarcos.add(new Destructor("SS The World"));
		listaBarcos.add(new Destructor("SS Dethklok"));
		listaBarcos.add(new Acorazado("SS Killer Queen "));
		listaBarcos.add(new Acorazado("SS Made in Heaven"));
/*
> 		listaBarcos[0] = new Fragata("SS Shigeshi");
> 		listaBarcos[1] = new Fragata("SS Koichi");
> 		listaBarcos[2] = new Destructor("SS The World");
> 		listaBarcos[3] = new Destructor("SS Dethklok");
> 		listaBarcos[4] = new Acorazado("SS Killer Queen ");
> 		listaBarcos[5] = new Acorazado("SS Made in Heaven");
*/
		for (int i = 0; i < listaBarcos.size(); ++i) {
			asignarPosicionInicial(listaBarcos, i);
//			System.out.println(listaBarcos[i].getNombre());
		}
		return listaBarcos;
	}
}

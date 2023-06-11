package battleShip;

import java.util.Random;

public class Position {

	public static void asignarPosicionInicial(Barco[] listaBarcos, int i) {
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
			if ( ( ejeY - listaBarcos[i].getLongitud() ) > 0 ) {
//				System.out.println("to Arriba");
				asignarCoordenadas(listaBarcos[i], ejeX, ejeY, 0, -1);
			}else {
//				System.out.println("to Abajo");
				asignarCoordenadas(listaBarcos[i], ejeX, ejeY, 0, 1);
			}
		}else {
//			System.out.println("Horizontal");
			if ( ( ejeX - listaBarcos[i].getLongitud() ) < 0 ) {
//				System.out.println("to Derecha");
				asignarCoordenadas(listaBarcos[i], ejeX, ejeY, 1, 0);
			}else {
//				System.out.println("to Izquierda");
				asignarCoordenadas(listaBarcos[i], ejeX, ejeY, -1, 0);
			}	
		}
//				Reasignamos si hace falta
		if (colisiona(listaBarcos, i)) {
			asignarPosicionInicial(listaBarcos, i);
		}
		
		
	}

	public static void asignarCoordenadas(Barco barquito, int inicioX, int inicioY,
																		int pasoX, int pasoY) {
		for (int i = 0; i < barquito.getLongitud(); ++i) {
			barquito.setCoordenadas(Integer.toString( inicioX + ( i * pasoX) ),
														Integer.toString( inicioY + ( i * pasoY) ),
														i);
		}
	}
	
	public static boolean colisiona( Barco[] listaBarcos, int ultimoBarco ) {
		String[][] nuevas = listaBarcos[ultimoBarco].getCoordenadas();
		String[][] anterior;
		for (int i = 0; i < ultimoBarco; ++i ) {
			anterior = listaBarcos[i].getCoordenadas();
			if ( compararCoordenadas(nuevas, anterior) ) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean compararCoordenadas(String[][] nueva, String[][] anterior) {
//		System.out.println(nueva[0].length +" OwO "+ anterior[0].length);
		for (int i = 0; i < nueva[0].length ; ++i) {
			for (int j = 0; j < anterior[0].length ; ++j) {
//				System.out.println( nueva[0][i] +" "+ nueva[1][i] +" vs "+ anterior[0][j] +" "+ anterior[1][j] );
				if ( nueva[0][i].compareTo(anterior[0][j]) == 0
							&& nueva[1][i].compareTo(anterior[1][j]) == 0  ) {
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
		listaBarcos[0] = new Fragata("SS Shigeshi");
		listaBarcos[1] = new Fragata("SS Koichi");
		listaBarcos[2] = new Destructor("SS The World");
		listaBarcos[3] = new Destructor("SS Dethklok");
		listaBarcos[4] = new Acorazado("SS Killer Queen ");
		listaBarcos[5] = new Acorazado("SS Made in Heaven");
		
		for (int i = 0; i < listaBarcos.length; ++i) {
			asignarPosicionInicial(listaBarcos, i);
//			System.out.println(listaBarcos[i].getNombre());
		}
		return listaBarcos;
	}
}

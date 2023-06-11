package battleShip;
/*   1  2  3 4  5  6 7  8
*    A B C D E F G H
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 */

public class Tablero extends Position{
	private String[][] tablero = new String[8][8];
	private ArrayList<Barco> listaBarcos;

	public Tablero() {
		for (int y = 0 ; y <8; ++y) {
			for (int x = 0; x<8; ++x) {
				this.tablero[y][x]= "_";
			}
		}
		listaBarcos = super.crearBarcos();
	}

	public void mostrarTablero(){
		System.out.println("\t  A B C D E F G H");
		for ( int y = 0 ; y <8; ++y ) {
			System.out.printf("\t"+(y+1)+" ");
			for ( int x = 0; x<8; ++x ) {
				System.out.printf(this.tablero[y][x]+" ");
			}
			System.out.printf("\n");
		}
	}

	public void revisarImpacto(int ejeX, int ejeY, Barco...barcos) {
		if ( hayBarco(ejeX, ejeY, barcos) ) {
			this.tablero[ejeY][ejeX] = String.valueOf((char) 4960);
			cualBarco(ejeX, ejeY, barcos);
		}else {
			this.tablero[ejeY][ejeX] = String.valueOf((char) 1161);
		}
		mostrarTablero();
	}
	
	public void mostrarTableroConBarcos(Barco...barcos  ) {
//		System.out.println(barcos[0].getCoordenadas().toString());
		System.out.println("\t  A B C D E F G H");
		for ( int y = 0 ; y < 8; ++y ) {
			System.out.printf("\t"+(y+1)+" ");
			for ( int x = 0; x < 8; ++x ) {
				if ( !hayBarco(x, y, barcos) ) {
					System.out.printf(this.tablero[y][x]+" ");
				}
				else {
//					System.out.printf( (char) 5861 +" "); // decente
//					System.out.printf( (char) 1161 +" "); // tiro al agua
//					System.out.printf( (char) 926 +" ");  // burguer | poco clara
//					System.out.printf( (char) 3486 +" "); // Amogus
					System.out.printf( (char) 4156 +" "); // Rectanguloide
//					System.out.printf( (char) 4960 +" "); // impacto
				}
			}
			System.out.printf("\n");
		}
	}
	
	public static boolean hayBarco(int x, int y, Barco...barcos) {
		for ( Barco barquito : barcos ) {
			for (int i = 0; barquito != null && i < barquito.getLongitud() ; ++i ) {
				if ( x == Integer.parseInt( barquito.getCoordenadas()[0][i] )
						&& y == Integer.parseInt( barquito.getCoordenadas()[1][i] )) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void cualBarco(int x, int y, Barco...barcos) {
		for (int barquito = 0; barquito <  barcos.length; ++barquito) {
//			System.out.println(barcos[barquito].getNombre()+ " - indice: "+barquito);
			for (int i = 0; i < barcos[barquito].getLongitud() ; ++i ) {
				if ( x == Integer.parseInt( barcos[barquito].getCoordenadas()[0][i] )
						&& y == Integer.parseInt( barcos[barquito].getCoordenadas()[1][i] )) {
					barcos[barquito].setImpactosRecibidos(barcos[barquito].getImpactosRecibidos()+1);
					if ( barcos[barquito].seMurio() ) {
						removerBarco(barquito, barcos);
					}
					return;
				}
			}
		}
	}
	
	public static void removerBarco(int index, Barco...barcos) {
		Barco[] nuevaLista = new Barco[barcos.length-1]; 
		String kitar = barcos[index].getNombre();

		for (int i = 0; i < index; ++i) {
			barcos[i] = barcos[i+1];
		}

		for (int i = index+1; i < barcos.length-1; ++i) {
			barcos[i] = barcos[i+1];
		}
		barcos = nuevaLista;
		System.out.println(kitar + " removido");
	}
	
}

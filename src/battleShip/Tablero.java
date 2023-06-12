package battleShip;
/*   1 2 3 4 5 6 7 8
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

import java.util.ArrayList;

public class Tablero extends Position{
	private String[][] tablero = new String[8][8];
	private ArrayList<Barco> listaBarcos;

	public Tablero() {
		for ( int fila = 0 ; fila < 8; ++fila ) {
			for ( int col = 0; col < 8; ++col ) {
				this.tablero[fila][col]= "_";
			}
		}
		listaBarcos = super.crearBarcos();
	}

	public String[][] getTablero() {
		return tablero;
	}
	public void setTablero(String[][] tablero) {
		this.tablero = tablero;
	}
	public ArrayList<Barco> getListaBarcos() {
		return listaBarcos;
	}
	public void setListaBarcos(ArrayList<Barco> listaBarcos) {
		this.listaBarcos = listaBarcos;
	}

	public void mostrarTablero(){
		System.out.println("\t  A B C D E F G H");
		for ( int fila = 0 ; fila < 8; ++fila ) {
			System.out.printf("\t"+(fila+1)+" ");
			for ( int col = 0; col < 8; ++col ) {
				System.out.printf(this.tablero[fila][col]+" ");
			}
			System.out.printf("\n");
		}
	}
	
	public void mostrarTableroConBarcos() {
//		System.out.println(barcos[0].getCoordenadas().toString());
		System.out.println("\t  A B C D E F G H");
		for ( int fila = 0 ; fila < 8; ++fila ) {
			System.out.printf("\t" + (fila + 1) + " ");
			for ( int col = 0; col < 8; ++col ) {
				if ( hayBarco(fila, col) == null ) {
					System.out.printf(this.tablero[fila][col]+" ");
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
// Se dibuja en coordenadas ingresadas según sea el caso
	public void revisarImpacto(int col, int fila) {
		String impacto = String.valueOf((char) 4960);
		String agua = String.valueOf((char) 1161);
		
		if ( this.tablero[fila][col].toString().equals(impacto)
					|| this.tablero[fila][col].toString().equals(agua)	) {
			System.out.println("Ya Golpeado");
			return;			
		}
		Barco golpear = hayBarco(fila, col);
		
		if ( golpear != null ) {
			this.tablero[fila][col] = impacto;
			golpearBarco(golpear);
			System.out.println("Impactado");
		}else {
			this.tablero[fila][col] = agua;
			System.out.println("No Impactado");
		}
		mostrarTablero();
	}
// Se revisa qué hay en las coordenadas ingresadas
	public Barco hayBarco(int fila, int col) {
		for ( Barco barquito : this.listaBarcos ) {
			for (int i = 0; barquito != null && i < barquito.getLongitud() ; ++i ) {
				if ( col == barquito.getCoordenadas()[0][i]
						&& fila == barquito.getCoordenadas()[1][i] ) {
					return barquito;
				}
			}
		}
		return null;
	}
	
	public void golpearBarco( Barco barquito ) {
		barquito.setImpactosRecibidos(barquito.getImpactosRecibidos() + 1);
		if ( barquito.seMurio() ) {
//			removerBarco(barquito);
			this.listaBarcos.remove(barquito);
			System.out.println("Quedan "
					+ this.listaBarcos.size() + " barcos" );
		}
		return;
	}
/*
	public static void removerBarco(Barco barquito) {
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
*/
}

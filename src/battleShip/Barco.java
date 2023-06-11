package battleShip;

public class Barco {
	private int longitud, impactosRecibidos;
	private String nombre;
	private String[][] coordenadas;
	
	//constructor
	public Barco(int longitud, String nombre) {
		this.longitud = longitud;
		this.nombre = nombre;
		this.coordenadas = new String[2][longitud];
		this.impactosRecibidos = 0;
	}

	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String[][] getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String cordX, String cordY, int i) {
		this.coordenadas[0][i] = cordX; // ejeX
		this.coordenadas[1][i] = cordY; // ejeY
	}	
	public int getImpactosRecibidos() {
		return impactosRecibidos;
	}
	public void setImpactosRecibidos(int impactosRecibidos) {
		this.impactosRecibidos = impactosRecibidos;
	}

	public void mostrarCordenadas() {
		for (int i = 0; i < this.getLongitud(); ++i) {
			System.out.println(this.coordenadas[0][i]
					+ " " + this.coordenadas[1][i]);
		}
	}
	
	public boolean seMurio() {
		System.out.println("Impactos: "+this.impactosRecibidos +" Largo: "+ this.longitud);
		if ( this.impactosRecibidos == this.longitud ) {
			return true;
		}
		return false;
	}
	
}

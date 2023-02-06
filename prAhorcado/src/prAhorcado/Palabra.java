package prAhorcado;

public class Palabra {
	
	private int longitud;
	private static final int maxLongitud = 23;
	private static final int minLongitud = 2;
	private String palabra;
	//private int idioma; Si va haber diferentes idiomas este identificador es necesario.
	
	//Este constructor crea una instancia de Palabra buscándola en la base de datos
	public Palabra(int longitud) throws Exception {
		if(longitud < minLongitud || longitud > maxLongitud) {
			throw new Exception("La longitud de la palabra no es adecuada\n");
		}
		//this.palabra = buscar en la base de datos una palabra random que cumpla las condiciones (longitud, dificultad);
		//Hay que calcular la dificultad de la palabra en base a una serie de parámetros
		this.longitud = palabra.length();
	}
	
	public Palabra(int longitud, String palabra) throws Exception {
		if(longitud < minLongitud || longitud > maxLongitud) {
			throw new Exception("La longitud de la palabra no es adecuada\n");
		}
		this.palabra = palabra;
		this.longitud = palabra.length();
	}
	
	public int getLongitud() {
		return this.longitud;
	}
	
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	public String getPalabra() {
		return this.palabra;
	}
	
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	@Override
	public boolean equals(Object x) {
		boolean ok = false;
		if (x instanceof Palabra) {
			Palabra other = (Palabra) x;
			ok = this.getPalabra().equalsIgnoreCase(other.getPalabra());
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return this.getPalabra().toLowerCase().hashCode();
	}

}

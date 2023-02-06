package prCuentaPalabrasSimpleCorrespondencias;

public class PalabraEnTexto implements Comparable<PalabraEnTexto> {
	private String palabra;
	private int veces;
	
	public PalabraEnTexto(String pal) {
		palabra = pal.toUpperCase();
		veces = 1;
	}
	
	public PalabraEnTexto(String pal, int vecs) {
		palabra = pal.toUpperCase();
		veces = vecs;
	}
	
	public void incrementa() {
		veces++;
	}
	
	@Override
	public String toString() {
		return this.palabra + ": " + Integer.toString(this.veces);
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof PalabraEnTexto) {
			PalabraEnTexto other = (PalabraEnTexto) o;
			ok = (this.palabra.equals(other.palabra));
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return this.palabra.hashCode();
	}
	
	@Override
		public int compareTo(PalabraEnTexto other) {
			return this.palabra.compareToIgnoreCase(other.palabra);
	}
}

package prCuentaPalabrasSimpleFicheros;

public class PalabraEnTexto {
	private String palabra;
	private int veces;
	
	public PalabraEnTexto (String pal) {
		pal = pal.toUpperCase();
		palabra = pal;
		veces = 1;
	}
	
	public void incrementa() {
		veces++;
	}
	
	@Override
	public boolean equals(Object x) {
		boolean ok = false;
		if (x instanceof PalabraEnTexto) {
			PalabraEnTexto other = (PalabraEnTexto) x;
			ok = (this.palabra.equals(other.palabra));
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return this.palabra.hashCode();
	}
	
	@Override
	public String toString() {
		return this.palabra + ": " + this.veces;
	}

}

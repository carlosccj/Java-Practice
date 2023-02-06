package prAlturas2;

public class Pais implements Comparable<Pais> {
	
	private String nombre;
	private String continente;
	private double altura;
	
	public Pais(String n, String c, double al) {
		nombre = n;
		continente = c;
		altura = al;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getContinente() {
		return continente;
	}
	
	public double getAltura() {
		return altura;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof Pais) {
			Pais other = (Pais) o;
			ok = this.getNombre().equals(other.getNombre());
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return this.getNombre().hashCode();
	}

	@Override
	public int compareTo(Pais o) {
		return this.getNombre().compareTo(o.getNombre());
	}
	
	@Override
	public String toString() {
		return "Pais(" + this.getNombre() + "," + this.getContinente() + "," + this.getAltura() + ")";
	}

}

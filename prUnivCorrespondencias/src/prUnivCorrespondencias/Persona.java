package prUnivCorrespondencias;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private String dni;

	public Persona(String n, String d) {
		if ((n == null || n.length() == 0) || (d == null || d.length() == 0)) {
			throw new RuntimeException("Agumentos erróneos");
		}
		nombre = n;
		dni = d;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "(" + getNombre() + ", " + getDni() + ")";
	}

	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof Persona) {
			Persona x = (Persona) o;
			ok = this.nombre.equalsIgnoreCase(x.nombre) && this.dni.equalsIgnoreCase(x.dni);
		}
		return ok;
	}

	@Override
	public int hashCode() {
		return nombre.toLowerCase().hashCode() + dni.toLowerCase().hashCode();
	}

	@Override
	public int compareTo(Persona o) {
		int res = this.getNombre().compareToIgnoreCase(o.getNombre());
		if (res == 0) {
			res = this.getDni().compareToIgnoreCase(o.getDni());
		}
		return res;
	}
	

}

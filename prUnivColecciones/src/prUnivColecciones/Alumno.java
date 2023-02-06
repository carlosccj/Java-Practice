package prUnivColecciones;

public class Alumno implements Comparable<Alumno> {
	private String nombre;
	private String dni;
	private double nota;

	public Alumno(String n, String d, double nt) {
		if ((n == null || n.length() == 0) || (d == null || d.length() == 0) || (nt < 0)) {
			throw new RuntimeException("Agumentos erróneos");
		}
		nombre = n;
		dni = d;
		nota = nt;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public double getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return "(" + getNombre() + ", " + getDni() + ", " + getNota() + ")";
	}

	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof Alumno) {
			Alumno other = (Alumno) o;
			ok = this.nombre.equalsIgnoreCase(other.nombre) && this.dni.equalsIgnoreCase(other.dni);
		}
		return ok;
	}

	@Override
	public int hashCode() {
		return nombre.toLowerCase().hashCode() + dni.toLowerCase().hashCode();
	}
	
	@Override
	public int compareTo(Alumno other) {
		int res = this.getNombre().compareToIgnoreCase(other.getNombre());
		if (res == 0) {
			res = this.getDni().compareToIgnoreCase(other.getDni());
		}
		return res;
	}
}

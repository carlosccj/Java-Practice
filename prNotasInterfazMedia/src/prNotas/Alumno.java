package prNotas;


public class Alumno {
	private String nombre;
	private String dni;
	private double nota;

	public Alumno(String d, String n) throws AlumnoException {
		this(d, n, 0);
	}

	public Alumno(String d, String n, double not) throws AlumnoException {
		if (not < 0) {
			throw new AlumnoException("Calificación negativa");
		}
		nombre = n;
		dni = d;
		nota = not;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDni() {
		return this.dni;
	}

	public double getCalificacion() {
		return this.nota;
	}

	@Override
	public String toString() {
		String str = "";
		str = this.getNombre() + " " + this.getDni();
		return str;
	}

	@Override
	public boolean equals(Object x) {
		boolean ok = false;
		if (x instanceof Alumno) {
			Alumno other = (Alumno) x;
			ok = (this.getNombre().equals(other.getNombre())
					&& this.getDni().equalsIgnoreCase(other.getDni()));
		}
		return ok;
	}

	@Override
	public int hashCode() {
		return this.getNombre().hashCode() + this.getDni().toLowerCase().hashCode();
	}
}

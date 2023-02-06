package prNotas2;

public class Alumno {
	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String nom, String dn) throws AlumnoException {
		this(nom, dn, 0);
	}
	
	public Alumno(String dn, String nom, double not) throws AlumnoException {
		if (not < 0) {
			throw new AlumnoException("Calificación negativa");
		}
		nombre = nom;
		dni = dn;
		nota = not;
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
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof Alumno) {
			Alumno other = (Alumno) o;
			ok = (this.getNombre().equals(other.getNombre()) && this.getDni().equalsIgnoreCase(other.getDni()));
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return this.getNombre().hashCode() + this.getDni().toLowerCase().hashCode();
	}
	
	@Override
	public String toString() {
		return this.getNombre() + " " + this.getDni();
	}

}

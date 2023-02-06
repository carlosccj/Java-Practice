package prNotas3;

public class Alumno {
	
	private String dni;
	private String nombre;
	private double calificacion;
	
	public Alumno(String d, String nom) throws AlumnoException {
		this(d, nom, 0.0);
	}
	
	public Alumno(String d, String nom, double cal) throws AlumnoException {
		if (cal < 0) {
			throw new AlumnoException("Calificacion negativa");
		}
		
		dni = d;
		nombre = nom;
		calificacion = cal;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getCalificacion() {
		return this.calificacion;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof Alumno) {
			Alumno other = (Alumno) o;
			ok = this.getNombre().equals(other.getNombre()) && this.getDni().equalsIgnoreCase(other.getDni());
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

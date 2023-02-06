package prUniv;
import java.util.*;

public class Alumno {
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
	public boolean equals(Object x) {
		boolean ok = false;
		if (x instanceof Alumno) {
			Alumno other = (Alumno) x;
			ok = (this.getNombre().equalsIgnoreCase(other.getNombre()) && 
					this.getDni().equalsIgnoreCase(other.getDni()) && 
					this.getNota() == other.getNota());
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return this.getNombre().toLowerCase().hashCode() + this.getDni().toLowerCase().hashCode() + 
				Double.hashCode(this.getNota());
	}

	@Override
	public String toString() {
		return "(" + getNombre() + ", " + getDni() + ", " + String.format(Locale.US, "%.2f", getNota()) + ")";
	}
}

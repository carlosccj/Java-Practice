import prUniv.*;

public class PruebaAlumno {
	public static void main(String[] args) {
		Alumno nal = new Alumno("Jean-Claude Van Damme", "44595081J", 6.784786);
		Alumno nals = new Alumno("Jean-Claude van Damme", "44595081j", 6.784786);
		if (nal.equals(nals)) {
			System.out.println("Los alumnos son iguales");
		} else {
			System.out.println("Los alumnos son distintos");
		}
		System.out.println(nal);
	}
}

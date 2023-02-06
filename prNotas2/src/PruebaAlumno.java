import prNotas2.*;

public class PruebaAlumno {
	public static void main(String[] args) {
		try {
			Alumno a = new Alumno("Gonzalez Perez, Juan", "22456784F", 5.5);
			Alumno b = new Alumno("Gonzalez Perez, Juan", "33456777S", -3.4);
			System.out.println(a + " " + b);
			if (a.equals(b)) {
				System.out.println("Los alumnos son iguales");
			}
		} catch (AlumnoException e) {
			System.out.println(e.getMessage());
		}
	}
}

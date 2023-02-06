import prNotas.*;

public class PruebaAlumno {
	public static void main(String[] args) {
		try {
			Alumno a = new Alumno("Gonzalez Perez", "22456784F", 5.5);
			Alumno b = new Alumno("Gonzalez Perez", "33456777S", 3.4);
			System.out.println(a + "\n" + b);
			b = new Alumno("Gonzalez Perez", "33456777S", -3.4);
		} catch (AlumnoException e) {
			System.err.println(e.getMessage());
		}
	}
}

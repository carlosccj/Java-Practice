import prNotas3.*;
public class PruebaAlumno {
	public static void main(String[] args) {
		try {
		Alumno a = new Alumno("22456784F", "Gonzalez Perez, Juan", 5.5); 
		System.out.println(a);
		Alumno b = new Alumno("33456777S", "Gonzalez Perez, Juan", -3.4);
		System.out.println(b);
		if (a.equals(b)) {
			System.out.println("Los dos alumnos son iguales");
		}
		} catch(AlumnoException e) {
			System.out.println(e.getMessage());
		}
	}

}

import prNotas2.*;

public class PruebaAsignatura {
	public static void main (String[] args) {
		String[] datos = {"12455666F;Lopez Perez, Pedro;6.7",
				"33678999D;Merlo Gomez, Isabel;5.8",
				"23555875G;Martinez Herrera, Lucia;9.1"};
		Asignatura poo = new Asignatura("POO", datos);
		System.out.println(poo);
		try {
		System.out.println("La media de las notas es: " + poo.getMedia());
		} catch (AlumnoException e) {
			System.out.println("No hay alumnos en la asignatura");
		}
	}
}

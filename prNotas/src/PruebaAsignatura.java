import prNotas.*;

public class PruebaAsignatura {
	public static void main(String[] args) {
		String[] alumnos = new String[] { "12455666F;Lopez Perez, Pedro;6.7", "33678999D;Merlo Gomez, Isabel;5.8",
				"23555875G;Martinez Herrera, Lucia;9.1" };
		Asignatura poo = new Asignatura("POO", alumnos);
		try {
			System.out.println("Media: " + poo.getMedia());
		} catch (AlumnoException e1) {
			System.out.println(e1.getMessage());
		}
		System.out.println(poo.toString());
		for (int i = 0; i < alumnos.length; i++ ) {
			System.out.println(poo.getAlumnos()[i].getDni());
		}
		System.out.println(poo.getAlumnos()[0].getCalificacion());
	}
}

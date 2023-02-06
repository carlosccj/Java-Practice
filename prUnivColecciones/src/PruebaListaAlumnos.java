import prUnivColecciones.Alumno;
import prUnivColecciones.ListaAlumnos;
import prUnivColecciones.CompararAlumnos;
import java.util.Set;
import java.util.Optional;

public class PruebaListaAlumnos {
	public static void main(String[] args) {
		try {
			ListaAlumnos lista1 = new ListaAlumnos();
			prueba(lista1);
			ListaAlumnos lista2 = new ListaAlumnos(new CompararAlumnos());
			prueba(lista2);
			System.out.println("#------------------------------------");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public static void prueba(ListaAlumnos lista) {
		try {
			System.out.println("#------------------------------------");
			lista.anyadirAlumno(new Alumno("juan", "77h", 3.0));
			lista.anyadirAlumno(new Alumno("eva", "44h", 6.9));
			lista.anyadirAlumno(new Alumno("Eva", "44H", 7.8));
			lista.anyadirAlumno(new Alumno("pepe luis", "11a", 5.6));
			lista.anyadirAlumno(new Alumno("Ana Rosa", "22B", 7.8));
			lista.anyadirAlumno(new Alumno("Pepe Luis", "11A", 7.1));
			lista.anyadirAlumno(new Alumno("Lola", "44D", 8.2));
			lista.anyadirAlumno(new Alumno("Juan", "77H", 4.5));
			System.out.println(lista.toString());
			Optional<Alumno> a1 = lista.buscarAlumno("pepe luis", "11a");
			if (a1.isPresent()) {
				System.out.println("Alumno: " + a1.get().toString());
			} else {
				System.out.println("Alumno: [pepe luis, 11a] no encontrado");
			}
			Optional<Alumno> a2 = lista.buscarAlumno("xxx", "xxx");
			if (a2.isPresent()) {
				System.out.println("Alumno: " + a2.get().toString());
			} else {
				System.out.println("Alumno: [xxx, xxx] no encontrado");
			}
//------------------------
			Set<Alumno> aprobados = lista.listaAprobados();
			System.out.println("Aprobados: " + aprobados);
//------------------------
			lista.eliminarAlumno("pepe luis", "11a");
			System.out.println(lista.toString());
			Optional<Alumno> a3 = lista.buscarAlumno("pepe luis", "11a");
			if (a3.isPresent()) {
				System.out.println("Alumno: " + a3.get().toString());
			} else {
				System.out.println("Alumno: [pepe luis, 11a] no encontrado");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}

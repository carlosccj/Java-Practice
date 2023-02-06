import prUniv.Alumno;
import prUniv.ListaAlumnos;
import prUniv.SelectorAlumnoNota;
import java.util.Arrays;

public class PruebaListaAlumnosSelector {
	public static void main(String[] args) {
		try {
			ListaAlumnos lista = new ListaAlumnos();
			lista.anyadirAlumno(new Alumno("eva", "44h", 6.9));
			lista.anyadirAlumno(new Alumno("Eva", "44H", 7.7));
			lista.anyadirAlumnos("pepe luis, 11a, 5.6; Ana Rosa, 22B , 7.8 ; Pepe Luis , 11A , 7.5 ;"
					+ " Ramos Lucas, Luis, 33C ; Lola , 44D, 8.2");
			System.out.println(lista.toString());
			lista.anyadirNotasAlumno("Pepe Luis, 11A, 7.5, 6.2, 8.9, 5.8");
			System.out.println(lista.toString());
			lista.guardarEnFichero("lista_alumnos.txt");
			ListaAlumnos lista2 = new ListaAlumnos();
			lista2.cargarDeFichero("lista_alumnos.txt");
			System.out.println(lista2.toString());
//------------------------
			Alumno[] seleccion = lista.seleccionar(new SelectorAlumnoNota(7.5, 8.0));
			System.out.println("Seleccion(7.5, 8.0): " + Arrays.toString(seleccion));
//------------------------
			ListaAlumnos lista3 = new ListaAlumnos();
			lista3.cargarDeFichero("lista_alumnos.txt");
			System.out.println(lista3.toString());
			if (lista2.equals(lista3)) {
				System.out.println("lista2.equals(lista3): iguales");
			} else {
				System.out.println("lista2.equals(lista3): distintos");
			}
			System.out.println("l2.hashCode: " + lista2.hashCode());
			System.out.println("l3.hashCode: " + lista3.hashCode());
			lista3.anyadirAlumno(new Alumno("juan", "77h", 3.2));
			System.out.println(lista3.toString());
			if (lista2.equals(lista3)) {
				System.out.println("lista2.equals(lista3): iguales");
			} else {
				System.out.println("lista2.equals(lista3): distintos");
			}
			System.out.println("l2.hashCode: " + lista2.hashCode());
			System.out.println("l3.hashCode: " + lista3.hashCode());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
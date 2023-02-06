import prUnivCorrespondencias.Persona;
import prUnivCorrespondencias.ListaNotas;
import java.util.Set;

public class PruebaListaNotas {
	public static void main(String[] args) {
		try {
			ListaNotas lista = new ListaNotas();
			lista.anyadirNota(new Persona("juan", "77h"), 3.0);
			lista.anyadirNota(new Persona("eva", "44h"), 6.9);
			lista.anyadirNota(new Persona("Eva", "44H"), 7.8);
			lista.anyadirNota(new Persona("pepe luis", "11a"), 5.6);
			lista.anyadirNota(new Persona("Ana Rosa", "22B"), 7.8);
			lista.anyadirNota(new Persona("Pepe Luis", "11A"), 7.1);
			lista.anyadirNota(new Persona("Lola", "44D"), 8.12340);
			lista.anyadirNota(new Persona("Juan", "77H"), 4.5);
			lista.anyadirNota(new Persona("juan", "77h"), 8.12345);
			lista.anyadirNota(new Persona("Ana Rosa", "22B"), 8.12330);
			System.out.println(lista.toString());
			double n1 = lista.buscarNota("pepe luis", "11a");
			System.out.println("Persona: [pepe luis, 11a]: " + n1);
			double n2 = lista.buscarNota("eva", "44h");
			System.out.println("Persona: [eva, 44h]: " + n2);
			double n3 = lista.buscarNota("juan", "77h");
			System.out.println("Persona: [juan, 77h]: " + n3);
			double n4 = lista.buscarNota("ana rosa", "22b");
			System.out.println("Persona: [ana rosa, 22b]: " + n4);
			double n5 = lista.buscarNota("xxx", "xxx");
			System.out.println("Persona: [xxx, xxx]: " + n5);
//------------------------
			Set<Persona> aprobados = lista.listaAprobados();
			System.out.println("Aprobados: " + aprobados);
//------------------------
			lista.eliminarNotas("pepe luis", "11a");
			System.out.println(lista.toString());
			double n6 = lista.buscarNota("pepe luis", "11a");
			System.out.println("Persona: [pepe luis, 11a]: " + n6);
//------------------------
			lista.eliminarNota("Eva", "44H", 6.9);
			System.out.println(lista.toString());
			double n7 = lista.buscarNota("eva", "44H");
			System.out.println("Persona: [eva, 44h]: " + n7);
//------------------------
			lista.eliminarNota("Eva", "44H", 8.8);
			System.out.println(lista.toString());
			double n8 = lista.buscarNota("eva", "44H");
			System.out.println("Persona: [eva, 44h]: " + n8);
//------------------------
			lista.eliminarNota("Eva", "44H", 7.8);
			System.out.println(lista.toString());
			double n9 = lista.buscarNota("eva", "44H");
			System.out.println("Persona: [eva, 44h]: " + n9);
//------------------------
			double mayorNota = lista.buscarMayorNota();
			System.out.println("Mayor nota: " + mayorNota);
//------------------------
			
			//Set<Persona> mejoresNotas = lista.buscarAlumnosConMayorNota();
			//System.out.println("Alumnos con mejores notas: " + mejoresNotas);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}

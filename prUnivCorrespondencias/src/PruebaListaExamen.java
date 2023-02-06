import prUnivCorrespondencias.Persona;
import prUnivCorrespondencias.ListaExamen;
import java.util.Set;

public class PruebaListaExamen {
	public static void main(String[] args) {
		try {
			ListaExamen lista = new ListaExamen();
			lista.anyadirNota(new Persona("juan", "77h"), 3.0);
			lista.anyadirNota(new Persona("eva", "44h"), 6.9);
			lista.anyadirNota(new Persona("Eva", "44H"), 7.8);
			lista.anyadirNota(new Persona("pepe luis", "11a"), 5.6);
			lista.anyadirNota(new Persona("Ana Rosa", "22B"), 7.8);
			lista.anyadirNota(new Persona("Pepe Luis", "11A"), 7.1);
			lista.anyadirNota(new Persona("Lola", "44D"), 8.2);
			lista.anyadirNota(new Persona("Juan", "77H"), 4.5);
			System.out.println(lista.toString());
			double n1 = lista.buscarNota("pepe luis", "11a");
			System.out.println("Persona: [pepe luis, 11a]: " + n1);
			double n2 = lista.buscarNota("xxx", "xxx");
			System.out.println("Persona: [xxx, xxx]: " + n2);
//------------------------
			Set<Persona> aprobados = lista.listaAprobados();
			System.out.println("Aprobados: " + aprobados);
//------------------------
			lista.eliminarNota("pepe luis", "11a");
			System.out.println(lista.toString());
			double n3 = lista.buscarNota("pepe luis", "11a");
			System.out.println("Persona: [pepe luis, 11a]: " + n3);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}

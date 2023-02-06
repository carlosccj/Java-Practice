import prUniv.*;

public class PruebaListaAlumnos {
	public static void main(String[] args) {
		ListaAlumnos a = new ListaAlumnos();
		ListaAlumnos b = new ListaAlumnos();

		String pr = "pepe luis, 11a, 5.6; Ana Rosa, 22B, 7.8; Pepe Luis, 11A, 7.1; Ramos Lucas, Luis, 33C; Lola, 44D, 8.2;";
		try {
			a.cargarDeFichero("univ.txt");
			b.anyadirAlumnos(pr);
			b.mostrarEnConsola();
			b.guardarEnFichero("univ.txt");
		} finally {
			System.out.println(a);
			System.out.println(b);
		}
	}

}

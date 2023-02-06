import prConcesionario.*;

public class PruebaConcesionario {
	public static void main(String[] args) {
		Concesionario concesionario = new Concesionario();
		anyadirCoches(concesionario);
		System.out.println("Concesionario: " + concesionario.toString());
		System.out.println("Mas barato: " + concesionario.cocheMasBarato().toString());
		concesionario.eliminarCoche("seat");
		System.out.println("Concesionario: " + concesionario.toString());
		System.out.println("Mas barato: " + concesionario.cocheMasBarato().toString());
	}

	private static void anyadirCoches(Concesionario concesionario) {
		concesionario.anyadirCoche(new Coche("seat", 10000));
		concesionario.anyadirCoche(new Coche("renault", 12000));
		concesionario.anyadirCoche(new CocheColor("peugeot", 17000, "azul"));
		concesionario.anyadirCoche(new Coche("peugeot", 13000));
	}

}

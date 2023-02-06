import prConcesionario.*;

//Falla porque en el ejemplo se usa el tipo Enum

public class PruebaConcesionarioSelector {
		public static void main(String[] args) {
			Concesionario concesionario = new Concesionario();
			System.out.println("Colores: " + (CocheColor.coloresDisponibles()));
			anyadirCoches(concesionario);
			System.out.println("Concesionario: " + concesionario.toString());
			System.out.println("Mas barato: " + concesionario.cocheMasBarato().toString());
			seleccionarCoches(concesionario);
			concesionario.eliminarCoche("seat Rojo");
			System.out.println("Concesionario: " + concesionario.toString());
			System.out.println("Mas barato: " + concesionario.cocheMasBarato().toString());
		}

		public static void anyadirCoches(Concesionario concesionario) {
			concesionario.anyadirCoche(new CocheColor("seat", 10000, "Rojo"));
			concesionario.anyadirCoche(new Coche("renault", 12000));
			concesionario.anyadirCoche(new Coche("peugeot", 17000));
			concesionario.anyadirCoche(new CocheColor("peugeot", 13000, "Azul"));
			concesionario.anyadirCoche(new CocheColor("renault", 14000, "Rojo"));
		}

		public static void seleccionarCoches(Concesionario concesionario) {
			Coche[] lista1 = concesionario.seleccionar(new SelectorPrecio(13000, 15000));
			System.out.println("Seleccion precio: " + (lista1));
			Coche[] lista2 = concesionario.seleccionar(new SelectorColor("Rojo"));
			System.out.println("Seleccion color: " + (lista2));
		}
	}


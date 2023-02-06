import prCuentaPalabrasSimpleFicheros.*;

public class PruebaPalabraEnTexto {
	public static void main(String[] args) {
		PalabraEnTexto a = new PalabraEnTexto("gorra");
		PalabraEnTexto b = new PalabraEnTexto("GORRA");
		a.incrementa();
		if (a.equals(b)) {
			System.out.println("Palabra 1 = " + a);
			System.out.println("Palabra 2 = " + b);
			if (a.equals(b)) {
				System.out.println("Las palabras son iguales");
			}
		}
	}
}
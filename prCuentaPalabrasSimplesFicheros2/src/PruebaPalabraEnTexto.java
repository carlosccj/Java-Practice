import prCuentaPalabrasSimplesFichero2.*;

public class PruebaPalabraEnTexto {
	public static void main (String[] args) {
		PalabraEnTexto a = new PalabraEnTexto("gorra");
		PalabraEnTexto b = new PalabraEnTexto("GORRA");
		System.out.println(a + " " + b);
		if (a.equals(b)) {
			System.out.println("Las palabras son iguales");
		} else {
			System.out.println("Las palabras son distintas");
		}
	}

}

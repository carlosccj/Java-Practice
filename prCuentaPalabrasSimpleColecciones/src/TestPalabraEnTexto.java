import prCuentaPalabrasSimpleColecciones.*;
public class TestPalabraEnTexto {
	public static void main(String[] args) {
		PalabraEnTexto a = new PalabraEnTexto("Hola");
		PalabraEnTexto b = new PalabraEnTexto("Adios");
		a.incrementa();
		a.incrementa();
		a.incrementa();
		b.incrementa();
		b.incrementa();
		System.out.println(a.compareTo(b));
		System.out.println(b.compareTo(a));
		PalabraEnTexto c = new PalabraEnTexto("CLASE");
		PalabraEnTexto d = new PalabraEnTexto("clase");
		System.out.println(c.compareTo(d));
		System.out.println(d.compareTo(c));
	}

}

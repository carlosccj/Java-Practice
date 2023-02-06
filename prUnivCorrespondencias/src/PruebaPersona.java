import prUnivCorrespondencias.Persona;

public class PruebaPersona {
	public static void main(String[] args) {
		Persona pr1 = new Persona("pepe luis", "11a");
		Persona pr2 = new Persona("Pepe Luis", "11A");
		Persona pr3 = new Persona("Ana Rosa", "22B");
		Persona pr4 = new Persona("Eva", "44H");
		System.out.println("Persona: " + pr1.toString() + " HC: " + pr1.hashCode());
		System.out.println("Persona: " + pr2.toString() + " HC: " + pr2.hashCode());
		System.out.println("Persona: " + pr3.toString() + " HC: " + pr3.hashCode());
		System.out.println("Persona: " + pr4.toString() + " HC: " + pr4.hashCode());
		if (pr1.equals(pr2)) {
			System.out.println(pr1.toString() + " == " + pr2.toString());
		} else {
			System.out.println(pr1.toString() + " != " + pr2.toString());
		}
		if (pr1.equals(pr3)) {
			System.out.println(pr1.toString() + " == " + pr3.toString());
		} else {
			System.out.println(pr1.toString() + " != " + pr3.toString());
		}
		if (pr2.equals(pr3)) {
			System.out.println(pr2.toString() + " == " + pr3.toString());
		} else {
			System.out.println(pr2.toString() + " != " + pr3.toString());
		}
//----------------------------
		System.out.println(pr1.toString() + " CMP " + pr2.toString() + ": " + pr1.compareTo(pr2));
		System.out.println(pr2.toString() + " CMP " + pr3.toString() + ": " + pr2.compareTo(pr3));
		System.out.println(pr3.toString() + " CMP " + pr4.toString() + ": " + pr3.compareTo(pr4));
//----------------------------
	}
}

import prUnivColecciones.Alumno;

public class PruebaAlumno {
	public static void main(String[] args) {
		Alumno al1 = new Alumno("pepe luis", "11a", 5.6);
		Alumno al2 = new Alumno("Pepe Luis", "11A", 7.1);
		Alumno al3 = new Alumno("Ana Rosa", "22B", 7.8);
		Alumno al4 = new Alumno("Eva", "44H", 7.8);
		System.out.println("Alumno: " + al1.toString() + " HC: " + al1.hashCode());
		System.out.println("Alumno: " + al2.toString() + " HC: " + al2.hashCode());
		System.out.println("Alumno: " + al3.toString() + " HC: " + al3.hashCode());
		System.out.println("Alumno: " + al4.toString() + " HC: " + al4.hashCode());
		if (al1.equals(al2)) {
			System.out.println(al1.toString() + " == " + al2.toString());
		} else {
			System.out.println(al1.toString() + " != " + al2.toString());
		}
		if (al1.equals(al3)) {
			System.out.println(al1.toString() + " == " + al3.toString());
		} else {
			System.out.println(al1.toString() + " != " + al3.toString());
		}
		if (al2.equals(al3)) {
			System.out.println(al2.toString() + " == " + al3.toString());
		} else {
			System.out.println(al2.toString() + " != " + al3.toString());
		}
//----------------------------
		System.out.println(al1.toString() + " CMP " + al2.toString() + ": " + al1.compareTo(al2));
		System.out.println(al2.toString() + " CMP " + al3.toString() + ": " + al2.compareTo(al3));
		System.out.println(al3.toString() + " CMP " + al4.toString() + ": " + al3.compareTo(al4));
	}
}
//----------------------------

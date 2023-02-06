import prPlano.*;
public class PruebaPunto {
	public static void main (String[] args) {
		Punto pto1 = new Punto();
		Punto pto2 = new Punto(2, 3);
		Punto pto3 = new Punto(5, 8);
		System.out.println(pto1 + ", " + pto2 + ", " + pto3);
		pto3.desplazar(5, 1);
		System.out.println(pto3);
		System.out.println(pto3.distancia(pto2));
		
	}
}

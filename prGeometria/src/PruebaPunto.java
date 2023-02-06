import geometria.Punto;
public class PruebaPunto {
public static void main(String[] args) {
	Punto pto1 = new Punto(1, 2);
	Punto pto2 = new Punto(2, 1);
	Punto pto3 = new Punto(3, 3);
	Punto pto4 = new Punto(3, 1);
	Punto pto5 = new Punto();
	System.out.println(pto5.getAbcisa()); 
	System.out.println(pto5.getOrdenada());
	pto4.desplazar(1, 1);
	System.out.println(pto4.getAbcisa()); 
	System.out.println(pto4.getOrdenada());
	double d = pto1.distancia(pto3);
	System.out.println(pto4);
	}

}

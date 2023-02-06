import prPlano.*;
public class PruebaSegmento {
	public static void main (String[] args) {
		Punto p1 = new Punto();
		Punto p2 = new Punto(3, 4);
		Segmento s1 = new Segmento(1, 2, 5, 6);
		System.out.println("Punto-1: "+p1);
		System.out.println("Punto-2: "+p2);
		System.out.println("Distancia-p1-p2: "+p1.distancia(p2));
		System.out.println("Segmento-1: "+ s1 +" Long: "+ s1.longitud());
		p1.desplazar(2, 3);
		System.out.println("Punto-1: "+p1);
		s1.desplazar(7, -3);
		System.out.println("Segmento-1: "+s1+" Long: "+s1.longitud());
	}

}

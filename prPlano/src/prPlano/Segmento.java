package prPlano;

public class Segmento {
	private Punto extremo1;
	private Punto extremo2;

	public Segmento() {
		this(0, 0, 0, 0);
	}

	public Segmento(double x1, double y1, double x2, double y2) {
		this(new Punto(x1, y1),  new Punto(x2, y2));
	}
	
	public Segmento(Punto a, Punto b) {
		extremo1 = a;
		extremo2 = b;
	}
	
	public double longitud() {
		double longi = extremo1.distancia(extremo2);
		return longi;
	}
	
	public void desplazar(double a, double b) {
		extremo1.desplazar(a, b);
		extremo2.desplazar(a, b);
	}
	
	@Override
	public String toString() {
		String str = "";
		str = "(" + extremo1.toString() + ", " + extremo2.toString() + ")";
		return str;
	}
	
}

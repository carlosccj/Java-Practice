package geometria;

public class Segmento {
	private Punto extremo1, extremo2;
	public Segmento (Punto a, Punto b) {
		extremo1 = a;
		extremo2 = b;
	}
	public Segmento (double x1, double y1, double x2, double y2) {
		extremo1 = new Punto (x1, y1);
		extremo2 = new Punto (x2, y2);
	}
	public void desplazar (double x, double y) {
		extremo1.desplazar(x, y);
		extremo2.desplazar(x, y);
	}
	public double longitud () {
		return extremo1.distancia(extremo2);
	}
	@Override
	public String toString() {
		return "(" + extremo1.getAbcisa() + ", " + extremo1.getOrdenada() +
				"), (" + extremo2.getAbcisa() + ", " + extremo2.getOrdenada() + ")";
	}

}

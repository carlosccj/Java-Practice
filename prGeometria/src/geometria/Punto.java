package geometria;

public class Punto {
	private double x, y;
	public Punto () {
		this(0,0);
	}
	public Punto (double a, double b) {
		x = a;
		y = b;
	}
	public double getAbcisa() {
		return x;
	}
	public double getOrdenada() {
		return y;
	}
	public void setAbcisa(double a) {
		x = a;
	}
	public void setOrdenada(double b) {
		y = b;
	}
	public void desplazar (double a, double b) {
		x += a;
		y += b;
	}
	public double distancia(Punto pto) {
		return Math.sqrt(Math.pow(this.x - pto.x, 2) + Math.pow(this.y- pto.y, 2));
	}
	@Override
	public String toString() {
		return "(" + this.getAbcisa() + ", " + this.getOrdenada() + ")";
	}
}


package prPlano;

public class Punto {
	private double abcisa;
	private double ordenada;
	
	public Punto () {
		this(0, 0);
	}
	
	public Punto (double abs, double ord) {
		abcisa = abs;
		ordenada = ord;
	}
	
	public double getAbcisa() {
		return abcisa;
	}
	
	public double getOrdenada() {
		return ordenada;
	}
	
	public void setAbcisa(double abs) {
		abcisa = abs;
	}
	
	public void setOrdenada (double ord) {
		ordenada = ord;
	}
	
	public void desplazar (double abs, double ord) {
		abcisa = getAbcisa() + abs;
		ordenada = getOrdenada() + ord;
	}
	
	public double distancia (Punto x) {
		double dist = Math.sqrt(Math.pow(this.getAbcisa() - x.getAbcisa(), 2) +
				Math.pow(this.getOrdenada() - x.getOrdenada(), 2));
		return dist;
	}
	
	@Override
	public String toString() {
		String str = "";
		str = "(" + getAbcisa() + ", " + getOrdenada() + ")";
		return str;
	}

}

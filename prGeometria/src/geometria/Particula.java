package geometria;

public class Particula extends Punto {
	private final static double G = 6.67408e-11;
	private double masa;
	
	public Particula (float m) {
		this(0, 0, m);
	}
	public Particula (double a, double b, double m) {
		super(a, b);
		masa = m;
	}
	public void setMasa (double m) {
		masa = m;
	}
	public double getMasa () {
		return masa;
	}
	public double atraccion (Particula part) {
		return G * this.masa * part.masa / Math.pow(this.distancia(part), 2);
	}

}

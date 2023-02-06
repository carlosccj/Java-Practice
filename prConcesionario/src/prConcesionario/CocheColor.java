package prConcesionario;

public class CocheColor extends Coche {
	private static final String[] COLORES = { "Negro", "Rojo", "Verde", "Azul", "Blanco" };
	private static final double[] PRECIO = { 0, 10, 20, 30, 40 };
	private int coloridx;

	public CocheColor(String m, double p) {
		super(m, p);
		coloridx = 0;
	}
	
	public CocheColor(String m, double p, String c) {
		super(m, p);
		int i = 0;
		while (i < COLORES.length && (!c.equalsIgnoreCase(COLORES[i]))) {
			i++;
		}
		coloridx = (i < COLORES.length && i >= 0) ? i : 0;
	}
	
	public String getColor() {
		return COLORES[coloridx];
	}
	
	public void setColor(String c) {
		int i = 0;
		while (i < COLORES.length && (! c.equalsIgnoreCase(COLORES[i]))) {
			i++;
		}
		coloridx = (i >= 0 && i < COLORES.length) ? i : 0;
	}
	
	@Override
	public String getModelo() {
		return super.getModelo() + ", " + this.getColor();
	}
	
	protected double getPrecioColor() {
		return PRECIO[coloridx];
	}
	
	@Override
	protected double getPrecioBase() {
		double pf = super.getPrecioBase() + this.getPrecioColor();
		return pf;
	}
	
	public static String[] coloresDisponibles() {
		return COLORES;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += super.toString() + " " + this.getColor();
		return str;
	}
}

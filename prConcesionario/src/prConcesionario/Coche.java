package prConcesionario;

public class Coche {
	private static final double GASTOS_MATRICULACION = 100;
	private static double porcIVA = 10;
	private static int cntRef = 1;
	private final int referencia;
	private final String modelo;
	private double precioBase;

	public Coche(String m, double p) {
		if (m == "" || p < 0) {
			throw new RuntimeException("El modelo o el precio son incorrectos");
		}
		modelo = m;
		precioBase = p;
		referencia = cntRef;
		cntRef++;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public int getRef() {
		return referencia;
	}
	
	protected double getPrecioBase() {
		return precioBase;
	}
	
	public void setPrecioBase(double p) {
		if (p < 0) {
			throw new RuntimeException("Precio incorrecto");
		}
		precioBase = p;
	}
	
	public static double getIva() {
		return porcIVA;
	}
	
	public static void setIva(double d) {
		porcIVA = d;
	}
	
	public double calcPrecioFinal() {
		double pf = this.getPrecioBase() + GASTOS_MATRICULACION;
		pf = pf + (pf * (getIva() / 100));
		return pf;
	}
	
	@Override
	public String toString() {
		String str = "";
		str = "(" + this.getRef() + ", " + this.getModelo() + ", " + this.calcPrecioFinal() + ")";
		return str;
	}

}

package prLibreria;

public class Libro {
	private static double porcIVA = 10;
	private String autor;
	private String titulo;
	private double precioBase;

	public Libro (String a, String b, double x) {
		autor = a;
		titulo = b;
		precioBase = x;
	}
	public String getAutor() {
		String autor = this.autor;
		return autor;
	}
	public String getTitulo() {
		String titulo = this.titulo;
		return titulo;
	}
	public double getPrecioBase() {
		double precioBase = this.precioBase;
		return precioBase;
	}
	public double getPrecioFinal() {
		double precioFinal = getPrecioBase() + getPrecioBase() * (porcIVA / 100);
		return precioFinal;
	}
	public static double getIVA() {
		return porcIVA;
	}
	public static void setIVA (double a) {
		porcIVA = a;
	}
	@Override
	public String toString() {
		return "(" + this.autor + "; " + this.titulo + "; " + this.precioBase + 
				"; " + Libro.getIVA() + "% ; " + getPrecioFinal() + ")";
	}
	

}

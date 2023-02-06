package prLibreria;

public class LibroOferta extends Libro {
	private double porcDescuento;

	public LibroOferta(String a, String t, double pb, double dc) {
		super(a, t, pb);
		porcDescuento = dc;
	}

	public double getDescuento() {
		return porcDescuento;
	}

	@Override
	public double getPrecioFinal() {
		double px = super.getPrecioBase() - super.getPrecioBase() * this.getDescuento() / 100;
		double pf = px + px * super.getIVA() / 100;
		return pf;
	}

	private double getPrecioDescuento () {
		double res = super.getPrecioBase() - ((super.getPrecioBase() * (getDescuento() / 100)));
		return res;
	}
	@Override
	public String toString() {
		return "(" + super.getAutor() + "; " + super.getTitulo() + "; " + super.getPrecioBase() + "; "
				+ this.getDescuento() + "%; "+ this.getPrecioDescuento() + "; " + super.getIVA() + "%; " 
				+ this.getPrecioFinal() + ")";
	}

}

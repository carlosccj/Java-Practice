package prLibreria;

public class OfertaPrecio implements OfertaFlex {
	private double porcDescuento;
	private double umbralPrecio;

	public OfertaPrecio(double pd, double up) {
		porcDescuento = pd;
		umbralPrecio = up;
	}

	@Override
	public double getDescuento(Libro x) {
		double pd = 0;
		if (x.getPrecioBase() >= umbralPrecio) {
			pd = porcDescuento;
		}
		return pd;
	}

	@Override
	public String toString() {
		String str = porcDescuento + "% (" + umbralPrecio + ")";
		return str;
	}

}

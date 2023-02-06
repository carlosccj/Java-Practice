package prLibreria;

public class LibreriaOfertaFlex extends Libreria {
	private OfertaFlex oferta;
	
	public LibreriaOfertaFlex (OfertaFlex x) {
		this(CAP_INICIAL, x);
	}
	public LibreriaOfertaFlex (int cap, OfertaFlex x) {
		super(cap);
		oferta = x;
	}
	
	public void setOferta (OfertaFlex suto) {
		oferta = suto;
	}
	public OfertaFlex getOferta() {
		return oferta;
	}
	@Override
	public void addLibro(String a, String t, double p) {
		Libro x = new Libro(a, t, p);
		double pd = oferta.getDescuento(x);
		if (pd != 0) {
			LibroOferta y = new LibroOferta(a, t, p, pd);
			anyadirLibro(y);
		} else {
			anyadirLibro(x);
		}
	}
	@Override
	public String toString() {
		String str = "";
		str+= oferta.toString();
		str+= super.toString();
		return str;
	}
	

}

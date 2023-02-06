package prLibreria;

public class LibreriaOferta extends Libreria {
	private String[] libsOf;
	private double porcDescuento;
	
	public LibreriaOferta (double dc, String[] arr) {
		this(CAP_INICIAL, dc, arr);
	}
	public LibreriaOferta (int cap, double dc, String[] arr) {
		super(cap);
		porcDescuento = dc;
		libsOf = arr;
	}
	public void setOferta (double dc, String[] arr) {
		porcDescuento = dc;
		libsOf = arr;
	}
	public String[] getOferta() {
		return libsOf;
	}
	public double getDescuento() {
		return porcDescuento;
	}
	private boolean buscarLibroOf(String a) {
		boolean cnt = false;
		for (int i = 0; i < libsOf.length && !cnt; i++) {
			if (libsOf[i] != null && libsOf[i].equalsIgnoreCase(a)) {
				cnt = true;
			}
		}
		return cnt;
	}
	@Override
	public void addLibro (String a, String t, double pb) {
		boolean cnt = buscarLibroOf(a);
		if (cnt) {
			anyadirLibro(new LibroOferta(a, t, pb, getDescuento()));
		} else {
			anyadirLibro(new Libro(a, t, pb));
		}
	}
	@Override
	public String toString() {
		String str = "";
		str+= getDescuento() + "% [";
		if (libsOf.length > 0) {
			str+= libsOf[0].toString();
		}
		for (int i = 1; i < libsOf.length; i++) {
			str+= ", " + libsOf[i].toString();
		}
		str+= "] \n";
		str+= super.toString();
		return str;
	}
}

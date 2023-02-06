package prLibreria;

public class OfertaAutor implements OfertaFlex {
	private double porcDescuento;
	private String[] autoresOferta;
	
	public OfertaAutor (double pd, String[] autof) {
		porcDescuento = pd;
		autoresOferta = autof;
	}
	
	private boolean buscarAutor (String aut) {
		boolean found = false;
		int j = 0;
		while (j < autoresOferta.length && !found) {
			found = aut.equalsIgnoreCase(autoresOferta[j]);
			j++;
		}
		return found;
	}
	
	@Override
	public double getDescuento (Libro x) {
		double pd = 0;
		String aut = x.getAutor();
		boolean cnt = buscarAutor(aut);
		if (cnt) {
			pd = porcDescuento;
		}
		return pd;
	}
	@Override
	public String toString() {
		String str = porcDescuento + "% ";
		str+= "[" + autoresOferta[0];
		for (int i = 1; i < autoresOferta.length; i++) {
			str+= ", " + autoresOferta[i];
		}
		str+= "]" + "\n";
		return str;
	}
}

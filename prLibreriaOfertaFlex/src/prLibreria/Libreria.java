
package prLibreria;

import java.util.Arrays;

public class Libreria {
	protected static final int CAP_INICIAL = 8;
	private int numLibs;
	private Libro[] libs;
	public Libreria() {
		this(CAP_INICIAL);
	}
	public Libreria(int cap) {
		if (cap <= 0) {
			throw new RuntimeException("BadArgs "+ cap);
		}
		numLibs = 0;
		libs = new Libro[cap];
	}
	public void addLibro(String a, String t, double p) {
		anyadirLibro(new Libro(a, t, p));
	}
	public void remLibro(String a, String t) {
		int i = buscarLibro(a, t);
		if (0 <= i && i < numLibs) {
			eliminarLibro(i);
		}
	}
	public double getPrecioBase(String a, String t) {
		double p = 0;
		int i = buscarLibro(a, t);
		if (0 <= i && i < numLibs) {
			p = libs[i].getPrecioBase();
		}
		return p;
	}
	public double getPrecioFinal(String a, String t) {
		double p = 0;
		int i = buscarLibro(a, t);
		if (0 <= i && i < numLibs) {
			p = libs[i].getPrecioFinal();
		}
		return p;
	}
	@Override
	public String toString() {
		String str = "";
		if (numLibs > 0) {
			str += libs[0].toString();
			for (int i = 1; i < numLibs; ++i) {
				str += ",\n " + libs[i].toString();
			}
		}
		return "["+str+"]";
	}
	protected void anyadirLibro(Libro lb) {
		int i = buscarLibro(lb.getAutor(), lb.getTitulo());
		if (0 <= i && i < numLibs) {
			libs[i] = lb;
		} else {
			if (numLibs == libs.length) {
				libs = Arrays.copyOf(libs, 2 * libs.length);
			}
			libs[numLibs] = lb;
			++numLibs;
		}
	}
	private void eliminarLibro(int i) {
		if (0 <= i && i < numLibs) {
			--numLibs;
			libs[i] = libs[numLibs];
			libs[numLibs] = null;
		}
	}
	//private void eliminarLibroOrdenRelativo(int i) {
	//	if (0 <= i && i < numLibs) {
	//		System.arraycopy(libs, i+1, libs, i, numLibs-(i+1));
	//		--numLibs;
	//		libs[numLibs] = null;
	//	}
	//}
	private int buscarLibro(String a, String t) {
		int i = 0;
		while ((i < numLibs)
			   && ! (libs[i].getAutor().equalsIgnoreCase(a)
					 && libs[i].getTitulo().equalsIgnoreCase(t))) {
			++i;
		}
		return (i < numLibs) ? i : -1;
	}
}

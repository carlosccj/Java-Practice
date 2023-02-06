package prLibreria;

public class Libreria {
	private static final int CAP_INICIAL = 8;
	private int numlibs;
	private Libro[] libs;

	public Libreria() {
		this(CAP_INICIAL);
	}

	public Libreria(int CAP_INICIAL) {
		if (CAP_INICIAL < 0) {
			throw new RuntimeException("Capacidad erronea");
		}
		numlibs = 0;
		libs = new Libro[CAP_INICIAL];
	}

	public double getPrecioBase(String a, String t) {
		double result = 0;
		int idx = buscarLibro(a, t);
		if (idx != -1) {
			result = libs[idx].getPrecioBase();
		} else {
			result = 0;
		}
		return result;
	}

	public double getPrecioFinal(String a, String t) {
		double result = 0;
		int idx = buscarLibro(a, t);
		if (idx != -1) {
			result = libs[idx].getPrecioFinal();
		} else {
			result = 0;
		}
		return result;
	}

	public void addLibro(String a, String t, double p) {
		anyadirLibro(new Libro(a, t, p));
	}

	public void remLibro(String a, String t) {
		if (buscarLibro(a, t) >= 0 && buscarLibro(a, t) < numlibs) {
			eliminarLibro(buscarLibro(a, t));
		}
	}

	private void anyadirLibro(Libro lib) {
		int idx = buscarLibro(lib.getAutor(), lib.getTitulo());
		if (idx >= 0 && idx < numlibs) {
			libs[idx] = lib;
		} else {
			if (numlibs == libs.length) {
				libs = java.util.Arrays.copyOf(libs, 2 * libs.length);
			}
			libs[numlibs] = lib;
			++numlibs;
		}
	}

	private void eliminarLibro(int pos) {
		int i = numlibs - (pos + 1);
		while (i > 0) {
			libs[pos] = libs[pos + 1];
			--i;
			++pos;
		}
		--numlibs;
	}

	private int buscarLibro(String a, String t) {
		int i = 0;
		int result = 0;
		while (i < numlibs && !(a.equalsIgnoreCase(libs[i].getAutor()) && t.equalsIgnoreCase(libs[i].getTitulo()))) {
			i++;
		}
		if (i < numlibs) {
			result = i;
		} else {
			result = -1;
		}
		return result;
	}

	@Override
	public String toString() {
		String result = "[";
		if (numlibs > 0) {
			result += libs[0].toString() + "\n";
			for (int i = 1; i < numlibs; i++) {
				result += ", " + libs[i].toString() + "\n";
			}
		}
		return result += "]";
	}
}
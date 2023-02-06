package prConcesionario;

import java.util.Arrays;

public class Concesionario {
	private static final int CAPACIDAD_INICIAL = 10;
	private int nCoches;
	private Coche[] coches;

	public Concesionario() {
		this(CAPACIDAD_INICIAL);
	}

	public Concesionario(int n) {
		if (n <= 0) {
			throw new RuntimeException("Tamaño no valido");
		}
		nCoches = 0;
		coches = new Coche[n];
	}

	public int buscarCoche(String m) {
		int i = 0;
		while ((i < nCoches) && (!m.equalsIgnoreCase(coches[i].getModelo()))) {
			i++; // Si no está en el array, i será mayor que nCoches
		}
		return i;
	}

	private void anyadirFinal(Coche x) {
		if (nCoches == coches.length) {
			coches = Arrays.copyOf(coches, 2 * coches.length);
		}
		coches[nCoches] = x;
	}

	public void anyadirCoche(Coche x) {
		int idx = buscarCoche(x.getModelo());
		if (idx >= 0 && idx < nCoches) {
			coches[idx] = x;
		} else {
			anyadirFinal(x);
			nCoches++;
		}
	}

	public Coche cocheMasBarato() {
		if (nCoches == 0) {
			throw new RuntimeException("No hay coches en el concesionario");
		}
		int cnt = 0;
		double p = coches[0].calcPrecioFinal();
		for (int i = 0; i < nCoches; i++) {
			if (p > coches[i].calcPrecioFinal()) {
				p = coches[i].calcPrecioFinal();
				cnt = i;
			}
		}
		return coches[cnt];
	}

	@Override
	public String toString() {
		String str = "";
		if (nCoches > 0) {
			str += "[ " + coches[0].toString();
			for (int i = 1; i < nCoches; i++) {
				str += ", " + coches[i].toString();
			}
		}
		str += " ]";
		return str;
	}

	public void eliminarCoche(String m) {
		int idx = buscarCoche(m);
		if (idx >= 0 && idx < nCoches) {
			nCoches--;
			coches[idx] = coches[nCoches];
			coches[nCoches] = null;
		} else {
			throw new RuntimeException("Error");
		}
	}
	
	public Coche[] seleccionar(SelectorCoche sc) {
		Coche[] selec = new Coche[nCoches];
		int cnt = 0;
		for (int i = 0; i < nCoches; i++) {
			if(sc.esSeleccionable(coches[i])) {
				selec[cnt] = coches[i];
				cnt++;
			}
		}
		selec = Arrays.copyOf(selec, cnt);
		return selec;
	}

	public void eliminarCocheAlternativo(String m) {
		int idx = buscarCoche(m);
		if (idx >= 0 && idx < nCoches) {
			System.arraycopy(coches, (idx + 1), coches, idx, nCoches - (idx + 1));
			nCoches--;
			coches[nCoches] = null;
		} else {
			throw new RuntimeException("Error");
		}
	}
}

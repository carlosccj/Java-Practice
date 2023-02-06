
import java.util.*;

/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class MochilaAV extends Mochila {

	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = new SolucionMochila();
		double[] density = createDensity(pm, pm.getValores(), pm.getPesos());
		int[] objects = createObjects(pm);
		doubleQuickSort(density, objects, 0, pm.size() - 1);
		ArrayList<Integer> vectorSol = createVectorSol(pm, objects);
		sm.setSolucion(vectorSol);
		sm.setSumaPesos(pesoTotal(pm, vectorSol));
		sm.setSumaValores(valorTotal(pm, vectorSol));
		return sm;
	}

	public int pesoTotal(ProblemaMochila pm, ArrayList<Integer> vectorSol) {
		int pesoT = 0;
		for (int i = 0; i < vectorSol.size(); i++) {
			if (vectorSol.get(i) > 0) {
				pesoT = pesoT + pm.getPeso(i) * vectorSol.get(i);
			}
		}
		return pesoT;
	}

	public int valorTotal(ProblemaMochila pm, ArrayList<Integer> vectorSol) {
		int valorT = 0;
		for (int i = 0; i < vectorSol.size(); i++) {
			if (vectorSol.get(i) > 0) {
				valorT = valorT + pm.getValor(i) * vectorSol.get(i);
			}
		}
		return valorT;
	}

	public ArrayList<Integer> createVectorSol(ProblemaMochila pm, int[] objects) {
		ArrayList<Integer> vectorSol = new ArrayList<Integer>(Collections.nCopies(pm.size(), 0));
		int[] units = pm.getUnidades();
		int i = 0;
		while (i < pm.size() && units[objects[i]] > 0
				&& pm.getPesoMaximo() - pesoTotal(pm, vectorSol) >= pm.getPeso(objects[i])) {
			vectorSol.set(objects[i], vectorSol.get(objects[i]) + 1);
			units[objects[i]]--;
			if (units[objects[i]] == 0 || pm.getPesoMaximo() - pesoTotal(pm, vectorSol) < pm.getPeso(objects[i])) {
				i++;
			}
		}
		return vectorSol;
	}

	public double[] createDensity(ProblemaMochila pm, int[] values, int[] weights) {
		double[] density = new double[pm.size()];
		for (int i = 0; i < pm.size(); i++) {
			density[i] = (double) values[i] / weights[i];
		}
		return density;
	}

	public int[] createObjects(ProblemaMochila pm) {
		int[] objects = new int[pm.size()];
		for (int i = 0; i < pm.size(); i++) {
			objects[i] = i;
		}
		return objects;
	}

	void doubleQuickSort(double[] density, int[] objects, int first, int last) {
		if (first < last) {
			int pi = slash(density, objects, first, last);
			doubleQuickSort(density, objects, first, pi - 1);
			doubleQuickSort(density, objects, pi + 1, last);
		}
	}

	public int slash(double[] density, int[] objects, int first, int last) {
		double pivot = density[last]; // pivot
		int i = (first - 1);
		for (int j = first; j <= last - 1; j++) {
			if (density[j] > pivot) {
				i++;
				interchange(density, i, j);
				interchange(objects, i, j);
			}
		}
		interchange(density, i + 1, last);
		interchange(objects, i + 1, last);
		return (i + 1);
	}

	public void interchange(double[] density, int i, int j) {
		double aux = density[i];
		density[i] = density[j];
		density[j] = aux;
	}

	public void interchange(int[] objects, int i, int j) {
		int aux = objects[i];
		objects[i] = objects[j];
		objects[j] = aux;
	}
}

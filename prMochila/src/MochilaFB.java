import java.util.*;

/**
 * 
 * @author ***** Jose A. Onieva ******* Asumimos que: a) Todos los items tienen
 *         un valor >=1 b) W>0
 */

public class MochilaFB extends Mochila {

	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = new SolucionMochila();
		int[] comb = new int[pm.size()];
		int[] sol = comb;
		int[] solucion = combinaciones(pm, 0, sol, comb);
		ArrayList<Integer> vectorSolucion = convertToArray(solucion);
		sm.setSolucion(vectorSolucion);
		sm.setSumaPesos(calcularPeso(pm, solucion));
		sm.setSumaValores(calcularValor(pm, solucion));
		return sm;
	}

	public ArrayList<Integer> convertToArray(int[] solucion) {
		ArrayList<Integer> res = new ArrayList<Integer>(solucion.length);
		for (int i = 0; i < solucion.length; i++) {
			res.add(i, solucion[i]);
		}
		return res;
	}

	public int[] combinaciones(ProblemaMochila pm, int val, int[] sol, int[] comb) {
		int[] uni = pm.getUnidades();
		if (Arrays.equals(comb, uni)) {
			return sol;
		} else {
			int[] combSiguiente = nComb(pm, comb);
			int valProv = calcularValor(pm, combSiguiente);
			int pesoT = calcularPeso(pm, combSiguiente);
			if (pesoT <= pm.getPesoMaximo() && valProv >= val) {
				for (int i = 0; i < pm.size(); i++) {
					sol[i] = combSiguiente[i];
				}
				val = valProv;
			}
			return combinaciones(pm, val, sol, combSiguiente);
		}
	}

	public int[] nComb(ProblemaMochila pm, int[] combin) {
		boolean ok = false;
		int[] nuevaComb = new int[pm.size()];
		for (int i = pm.size() - 1; i >= 0 && !ok; i--) {
			if (combin[i] < pm.getUnidad(i)) {
				combin[i]++;
				System.arraycopy(combin, 0, nuevaComb, 0, i + 1);
				ok = true;
			}
		}
		return nuevaComb;
	}

	public int calcularValor(ProblemaMochila pm, int[] combin) {
		int val = 0;
		for (int i = 0; i < combin.length; i++) {
			val = val + combin[i] * pm.getValor(i);
		}
		return val;
	}

	public int calcularPeso(ProblemaMochila pm, int[] combin) {
		int pesoT = 0;
		for (int i = 0; i < combin.length; i++) {
			pesoT = pesoT + combin[i] * pm.getPeso(i);
		}
		return pesoT;
	}
}

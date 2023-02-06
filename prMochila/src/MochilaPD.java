
/**
 * 
 * @author ***** Jose A. Onieva *******
 *
 */
import java.util.*;

public class MochilaPD extends Mochila {

	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = new SolucionMochila();
		int[][] tablaSoluciones = crearTabla(pm);
		ArrayList<Integer> vectorSolucion = new ArrayList<Integer>(Collections.nCopies(pm.size(), 0));
		ArrayList<Integer> soluciones = crearSolucion(tablaSoluciones, pm, vectorSolucion, pm.size(),
				pm.getPesoMaximo());
		sm.setSolucion(soluciones);
		sm.setSumaPesos(pesoTotal(pm, soluciones));
		sm.setSumaValores(valorTotal(pm, soluciones));
		return sm;
	}

	public int pesoTotal(ProblemaMochila pm, ArrayList<Integer> soluciones) {
		int pesoT = 0;
		for (int i = 0; i < soluciones.size(); i++) {
			if (soluciones.get(i) > 0) {
				pesoT = pesoT + pm.getPeso(i) * soluciones.get(i);
			}
		}
		return pesoT;
	}

	public int valorTotal(ProblemaMochila pm, ArrayList<Integer> soluciones) {
		int valorT = 0;
		for (int i = 0; i < soluciones.size(); i++) {
			if (soluciones.get(i) > 0) {
				valorT = valorT + pm.getValor(i) * soluciones.get(i);
			}
		}
		return valorT;
	}

	public ArrayList<Integer> crearSolucion(int[][] tablaSoluciones, ProblemaMochila pm,
			ArrayList<Integer> vectorSolucion, int i, int j) {
		if (i > 0 && j > 0) {
			if (tablaSoluciones[i - 1][j] < tablaSoluciones[i][j] && vectorSolucion.get(i - 1) < pm.getUnidad(i - 1))  {
				vectorSolucion.set(i - 1, vectorSolucion.get(i - 1) + 1);
				crearSolucion(tablaSoluciones, pm, vectorSolucion, i, j - pm.getPeso(i - 1));
			} else {
				crearSolucion(tablaSoluciones, pm, vectorSolucion, i - 1, j);
			}
		}
		return vectorSolucion;
	}

	public int[][] crearTabla(ProblemaMochila pm) {
		int[][] tablaSoluciones = new int[pm.size() + 1][pm.getPesoMaximo() + 1];
		for (int i = 0; i < pm.size() + 1; i++) {
			for (int j = 0; j < pm.getPesoMaximo() + 1; j++) {
				if (i == 0 || j == 0) {
					tablaSoluciones[i][j] = 0;
				} else if (j < pm.getPeso(i - 1)) {
					tablaSoluciones[i][j] = tablaSoluciones[i - 1][j];
				} else {
					int k = maximal(pm, tablaSoluciones, i, j);
					tablaSoluciones[i][j] = Math.max(tablaSoluciones[i - 1][j],
							tablaSoluciones[i - 1][j - (k * pm.getPeso(i - 1))] + k * pm.getValor(i - 1));
				}
			}
		}
		return tablaSoluciones;
	}

	public int maximal(ProblemaMochila pm, int[][] tablaSoluciones, int i, int j) {
		int res = 0;
		for (int k = 1; k <= pm.getUnidad(i - 1) && (j >= k * pm.getPeso(i - 1)); k++) {
			res = k;
		}
		return res;
	}
}

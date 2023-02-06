
/**
 * 
 * @author ***** Jose A. Onieva *******
 *
 */
public class MochilaPD extends Mochila {

	public SolucionMochila resolver(ProblemaMochila pm) {
		// A resolver por el alumno
		SolucionMochila sm = new SolucionMochila();
		int[][] tablaSoluciones = crearTabla(pm);
		return sm;
	}

	public int[][] crearTabla(ProblemaMochila pm) {
		int[][] tablaSoluciones = new int[pm.size()][pm.size()];
		for (int i = 0; i < pm.size(); i++) {
			for (int j = 0; j < pm.size(); j++) {
				if (i == 0 || j == 0) {
					tablaSoluciones[i][j] = 0;
				} else if (j < pm.getPeso(i - 1)) {
					tablaSoluciones[i][j] = tablaSoluciones[i - 1][j];
				} else {
					int k = maximal(pm, tablaSoluciones, i, j);
					tablaSoluciones[i][j] = Math.max(tablaSoluciones[i - 1][j], k);
				}
			}
		}
		return tablaSoluciones;
	}

	public int maximal(ProblemaMochila pm, int[][] tablaSoluciones, int i, int j) {
		int maximal = 0;
		for (int k = 1; k < pm.getUnidad(i - 1); k++) {
			if (j >= k * pm.getValor(i - 1)
					&& maximal < tabalSoluciones[i - 1][j - (k * pm.getPeso(i - 1)) + k * pm.getValor(i - 1)]) {
				maximal = k;
			}
		}
		return maximal;
	}
}

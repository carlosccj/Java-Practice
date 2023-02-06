package prOperacionesConColecciones;

import java.util.*;

public class OperacionesConColecciones {

	public static List<Integer> intercambiarPares(List<Integer> vanilla) {
		int cnt = (vanilla.size() % 2 == 0) ? vanilla.size() : vanilla.size() - 1;
		for (int i = 0; i < cnt; i += 2) {
				Integer a = vanilla.get(i);
				Integer b = vanilla.get(i + 1);
				vanilla.set(i, b);
				vanilla.set(i + 1, a);
		}
		return vanilla;
	}

	public static double mediaVocales(Set<String> conjunto) {
		double vocales = 0.0;
		int palabras = 0;
		Iterator<String> it = conjunto.iterator();
		while (it.hasNext()) {
			palabras++;
			String x = it.next();
			for (int i = 0; i < x.length(); i++) {
				if (x.charAt(i) == 'a' || x.charAt(i) == 'e' || x.charAt(i) == 'i' || x.charAt(i) == 'o'
						|| x.charAt(i) == 'u') {
					vocales += 1;
				}
			}
		}
		return vocales / palabras;
	}

	public static List<String> eliminarDuplicados(List<String> vanilla) {
		vanilla.sort(null);
		ListIterator<String> it = vanilla.listIterator();
		while (it.hasNext()) {
			String anterior = it.next();
			while (it.hasNext()) {
				String posterior = it.next();
				if (anterior.equals(posterior)) {
					it.remove();
				} else {
					anterior = posterior;
				}
			}
		}
		return vanilla;
	}
	
	public static Set<String> eliminarLongitudPar(Set<String> vanilla) {
		Iterator<String> it = vanilla.iterator();
		while (it.hasNext()) {
			String x = it.next();
			if (x.length() % 2 == 0) {
				it.remove();
			}
		}
		return vanilla;
	}
	
	public static List<String> marcarLong4(List<String> vanilla) {
		ListIterator<String> it = vanilla.listIterator();
		List<String> res = new ArrayList<String>();
		while (it.hasNext()) {
			String x = it.next();
			res.add(x);
			if (x.length() == 4) {
				res.add("****");
			}
		}
		vanilla.clear();
		vanilla.addAll(res);
		return vanilla;
	}
	
	public static Set<Integer> superInterseccion(List<Set<Integer>> vanilla) {
		Set<Integer> res = vanilla.get(0);
		ListIterator<Set<Integer>> it = vanilla.listIterator();
		while (it.hasNext()) {
			res.retainAll(it.next());
		}
		return res;
	}
	
	public static List<Set<Integer>> eliminarConjDePares(List<Set<Integer>> vanilla) {
		ListIterator<Set<Integer>> it = vanilla.listIterator();
		while (it.hasNext()) {
			Set<Integer> x = it.next();
			boolean ok = true;
			Iterator<Integer> it2 = x.iterator();
			while (it2.hasNext()) {
				if (it2.next() % 2 != 0) {
					ok = false;
				}
			}
			if (ok) {
				it.remove();
			}
		}
		return vanilla;
	}
	
	public static double mediaAltura(Map<String, Double> alturas) {
		double media = 0.0;
		int cnt = 0;
		for (Map.Entry<String, Double> entry : alturas.entrySet()) {
			media += entry.getValue();
			cnt++;
		}
		return media / cnt;
	}
	
	public static Map<String, Integer> anyadirPedido(Map<String, Integer> vanilla, String nom, int cant) {
		if (vanilla.containsKey(nom)) {
			Integer oldCant = vanilla.remove(nom);
			vanilla.put(nom, oldCant + cant);
		} else {
			vanilla.put(nom, cant);
		}
		return vanilla;
	}
}

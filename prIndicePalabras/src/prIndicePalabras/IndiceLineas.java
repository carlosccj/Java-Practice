package prIndicePalabras;
import java.util.*;
import java.io.*;

public class IndiceLineas extends IndiceAbstracto {
	
	private SortedMap<String, SortedSet<Integer>> indice;
	
	public IndiceLineas() {
		indice = new TreeMap<String, SortedSet<Integer>>();
	}
	
	@Override
	public void resolver(String delimitadores) {
		indice.clear();
		int cnt = 1;
		ListIterator<String> it = frases.listIterator();
		while (it.hasNext()) {
			String linea = it.next().toLowerCase();
			escanear(linea, delimitadores, cnt);
			cnt++;
		}
	}
	
	@Override
	public void presentarIndice(PrintWriter pw) {
		for (Map.Entry<String, SortedSet<Integer>> entry : indice.entrySet()) {
			String clave = entry.getKey();
			SortedSet<Integer> valores = entry.getValue();
			Iterator<Integer> it = valores.iterator();
			StringBuilder sb = new StringBuilder();
			while (it.hasNext()) {
				sb.append(it.next() + ", ");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
			String res = "<" + sb.toString() + ">";
			pw.printf("%8s %15s %s", clave, res, "\n");
		}
	}
	
	private void escanear(String linea, String delimitadores, int cnt) {
		try(Scanner sc = new Scanner(linea)) {
			sc.useDelimiter(delimitadores);
			while (sc.hasNext()) {
				agregar(sc.next(), cnt);
			}
		}
	}
	
	private void agregar(String palabra, int cnt) {
		SortedSet<Integer> valores = indice.get(palabra);
		if (valores == null) {
			valores = new TreeSet<Integer>();
			valores.add(cnt);
			indice.put(palabra, valores);
		} else {
			valores.add(cnt);
			indice.put(palabra, valores);
		}
	}

}

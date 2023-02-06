package prIndicePalabras;
import java.util.*;
import java.io.*;

public class IndicePosicionesEnLineas extends IndiceAbstracto {
	private SortedMap<String, SortedMap<Integer, SortedSet<Integer>>> indice;
	
	public IndicePosicionesEnLineas() {
		indice = new TreeMap<String, SortedMap<Integer, SortedSet<Integer>>>();
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
		for (Map.Entry<String, SortedMap<Integer, SortedSet<Integer>>> entry : indice.entrySet()) {
			String palabra = entry.getKey();
			pw.println(palabra + "\n");
			for (Map.Entry<Integer, SortedSet<Integer>> nlinea : entry.getValue().entrySet()) {
				SortedSet<Integer> nposiciones = nlinea.getValue();
				Iterator<Integer> it = nposiciones.iterator();
				StringBuilder sb = new StringBuilder();
				while (it.hasNext()) {
					sb.append(it.next() + ", ");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.deleteCharAt(sb.length() - 1);
				String res = "<" + sb.toString() + ">";
				pw.println("\t" +  nlinea.getKey() + " " + res + "\n");
			}
		}
	}
	
	private void escanear(String linea, String delimitadores, int cnt) {
		try(Scanner sc = new Scanner(linea)) {
			sc.useDelimiter(delimitadores);
			int npos = 1;
			while (sc.hasNext()) {
				agregar(sc.next(), cnt, npos);
				npos++;
			}
		}
	}
	
	private void agregar(String palabra, int cnt, int npos) {
		SortedMap<Integer, SortedSet<Integer>> valores = indice.get(palabra);
		if (valores == null) {
			valores = new TreeMap<Integer, SortedSet<Integer>>();
			SortedSet<Integer> posicion = new TreeSet<Integer>();
			posicion.add(npos);
			valores.put(cnt, posicion);
			indice.put(palabra, valores);
			
		} else if (valores.containsKey(cnt)) {
			SortedSet<Integer> posiciones = valores.get(cnt);
			posiciones.add(npos);
			valores.put(cnt, posiciones);
			
		} else {
			SortedSet<Integer> posicion = new TreeSet<Integer>();
			posicion.add(npos);
			valores.put(cnt, posicion);
		}
	}

}

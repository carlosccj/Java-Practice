package prIndicePalabras;
import java.io.*;
import java.util.*;

public class IndiceContador extends IndiceAbstracto {
	
	private SortedMap<String, Integer> indice;
	
	public IndiceContador() {
		indice = new TreeMap<String, Integer>();
	}
	
	@Override
	public void resolver(String delimitadores) {
		indice.clear();
		ListIterator<String> it = frases.listIterator();
		while (it.hasNext()) {
			String linea = it.next().toLowerCase();
			escanear(linea, delimitadores);
		}
	}
	
	@Override
	public void presentarIndice(PrintWriter pw) {
		for (Map.Entry<String, Integer> entry : indice.entrySet()) {
			String clave = entry.getKey();
			Integer valor = entry.getValue();
			pw.printf("%8s %15s %s", clave, valor, "\n");
		}
	}
	
	private void escanear(String linea, String delimitadores) {
		try(Scanner sc = new Scanner(linea)) {
			sc.useDelimiter(delimitadores);
			while (sc.hasNext()) {
				agregar(sc.next());
			}
		}
	}
	
	private void agregar(String palabra) {
		Integer val = indice.get(palabra);
		if (val == null) {
			indice.put(palabra, 1);
		} else {
			indice.put(palabra, val + 1);
		}
	}
}

package prCuentaPalabrasSimpleCorrespondencias;

import java.util.*;
import java.io.*;

public class ContadorPalabras {
	private SortedMap<String, Integer> palabras;

	public ContadorPalabras() {
		palabras = new TreeMap<String, Integer>();
	}

	protected void incluye(String pal) {
		if (pal != "") {
			if (palabras.containsKey(pal.toUpperCase())) {
				Integer inc = palabras.remove(pal.toUpperCase());
				palabras.put(pal.toUpperCase(), inc + 1);
			} else {
				palabras.put(pal.toUpperCase(), 1);
			}
		}
	}

	private void incluyeTodas(String linea, String del) {
		String[] pals = linea.split(del);
		for (int i = 0; i < pals.length; i++) {
			incluye(pals[i]);
		}
	}

	public void incluyeTodas(String[] texto, String del) {
		for (int i = 0; i < texto.length; i++) {
			incluyeTodas(texto[i], del);
		}
	}

	public void incluyeTodasFichero(String nomFich, String del) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(nomFich))) {
			leerFichero(sc, del);
		}
	}

	private void leerFichero(Scanner sc, String del) {
		while (sc.hasNextLine()) {
			try (Scanner sc2 = new Scanner(sc.nextLine())) {
				sc2.useLocale(Locale.ENGLISH);
				sc2.useDelimiter(del);
				while (sc2.hasNext()) {
					incluye(sc2.next());
				}
			} catch (InputMismatchException e) {

			} catch (NoSuchElementException e) {

			}
		}
	}

	public PalabraEnTexto encuentra(String pal) {
		PalabraEnTexto x = new PalabraEnTexto(pal);
		if (palabras.containsKey(pal.toUpperCase())) {
			x = new PalabraEnTexto(pal, palabras.get(pal.toUpperCase()));
		} else {
			throw new NoSuchElementException("La palabra " + pal + " no existe");
		}
		return x;
	}

	public void presentaPalabras(String fichero) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(new File(fichero))) {
			presentaPalabras(pw);
		}
	}

	public void presentaPalabras(PrintWriter pw) {
		for (Map.Entry<String, Integer> entry : palabras.entrySet()) {
			PalabraEnTexto x = new PalabraEnTexto(entry.getKey(), entry.getValue());
			pw.println(x.toString());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int cnt = 0;
		if (!palabras.isEmpty()) {
			for (Map.Entry<String, Integer> entry : palabras.entrySet()) {
				PalabraEnTexto x = new PalabraEnTexto(entry.getKey(), entry.getValue());
				if (cnt != palabras.size() - 1) {
					sb.append(x.toString() + ", ");
					cnt++;
				} else {
					sb.append(x.toString());
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}

}

package prCuentaPalabrasSimpleColecciones;

import java.util.*;
import java.io.*;

public class ContadorPalabras {
	private SortedSet<PalabraEnTexto> palabras;

	public ContadorPalabras() {
		palabras = new TreeSet<PalabraEnTexto>();
	}

	protected void incluye(String pal) {
		if (pal != "") {
			PalabraEnTexto x = new PalabraEnTexto(pal);
			Set<PalabraEnTexto> nuevas = new HashSet<PalabraEnTexto>();
			if (palabras.contains(x)) {
				Iterator<PalabraEnTexto> it = palabras.iterator();
				while (it.hasNext()) {
					PalabraEnTexto y = it.next();
					if (x.equals(y)) {
						y.incrementa();
						it.remove();
						nuevas.add(y);
					}
				}
				palabras.addAll(nuevas);
			} else {
				palabras.add(x);
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
		if (palabras.contains(x)) {
			x = buscar(x);
		} else {
			throw new NoSuchElementException();
		}
		return x;
	}
	
	private PalabraEnTexto buscar(PalabraEnTexto x) {
		Iterator<PalabraEnTexto> it = palabras.iterator();
		PalabraEnTexto res = null;
		boolean ok = false;
		while (it.hasNext() && !ok) {
			PalabraEnTexto y = it.next();
			if (x.equals(y)) {
				res = y;
				ok = true;
			}
		}
		return res;
	}

	public void presentaPalabras(String fichero) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(new File(fichero))) {
			presentaPalabras(pw);
		}
	}

	public void presentaPalabras(PrintWriter pw) {
		Iterator<PalabraEnTexto> it = palabras.iterator();
		while (it.hasNext()) {
			pw.println(it.next());
		}
	}

	@Override
	public String toString() {
		Iterator<PalabraEnTexto> it = palabras.iterator();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int cnt = 0;
		if (!palabras.isEmpty()) {
			while (it.hasNext() && cnt < palabras.size() - 1) {
				sb.append(it.next().toString() + ", ");
				cnt++;
			}
			sb.append(palabras.last());
		}
		sb.append("]");
		return sb.toString();
	}

}

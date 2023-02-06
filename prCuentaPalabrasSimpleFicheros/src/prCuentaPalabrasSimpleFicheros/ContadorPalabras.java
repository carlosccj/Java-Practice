package prCuentaPalabrasSimpleFicheros;

import java.util.*;
import java.io.*;

public class ContadorPalabras {
	private int numPalabras;
	private static final int TAM_INICIAL = 10;
	private PalabraEnTexto[] palabras;

	public ContadorPalabras() {
		this(TAM_INICIAL);
	}

	public ContadorPalabras(int tam) {
		numPalabras = 0;
		palabras = new PalabraEnTexto[tam];
	}

	private int esta(String pal) {
		int idx = -1;
		PalabraEnTexto x = new PalabraEnTexto(pal);
		for (int i = 0; i < this.numPalabras && idx == -1; i++) {
			if (x.equals(palabras[i])) {
				idx = i;
			}
		}
		return idx;
	}

	protected void incluye(String linea) {
		int var = this.esta(linea);
		if (var == -1 && !(linea.equals(""))) {
			anyadir(linea);
		} else if (var >= 0 && var <= numPalabras) {
			palabras[var].incrementa();
		}
	}

	private void incluyeTodas(String linea, String del) {
		String[] extr = linea.split(del);
		for (String x : extr) {
			incluye(x);
		}
	}

	public void incluyeTodas(String[] texto, String del) {
		for (int i = 0; i < texto.length; i++) {
			String linea = texto[i];
			incluyeTodas(linea, del);
		}
	}

	public void incluyeTodasFichero(String nomFich, String del) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File("datos.txt"))) {
			leerFichero(sc, del);
		} catch (InputMismatchException e) {

		} catch (NoSuchElementException e) {

		}
	}

	private void leerFichero(Scanner sc, String del) throws InputMismatchException, NoSuchElementException {
		while (sc.hasNextLine()) {
			String[] nlinea = sc.nextLine().split(del);
			for (String x : nlinea) {
				incluye(x);
			}
		}
	}

	public PalabraEnTexto encuentra(String pal) {
		int idx = esta(pal);
		if (idx == -1) {
			throw new NoSuchElementException("No existe la palabra " + pal);
		} else {
			return palabras[idx];
		}
	}

	protected void anyadir(String linea) {
		PalabraEnTexto x = new PalabraEnTexto(linea);
		if (numPalabras == palabras.length) {
			palabras = java.util.Arrays.copyOf(palabras, 2 * palabras.length);
		}
		palabras[numPalabras] = x;
		numPalabras++;
	}

	public void presentaPalabras(String fichero) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(fichero)) {
			presentaPalabras(pw);
		}
	}

	public void presentaPalabras(PrintWriter pw) {
		for (int i = 0; i < numPalabras; i++) {
			pw.println(palabras[i].toString());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (numPalabras > 0) {
			for (int i = 0; i < numPalabras - 1; i++) {
				sb.append(palabras[i].toString() + ", ");
			}
			sb.append(palabras[numPalabras - 1].toString());
		}
		String res = sb.toString();
		return "[" + res + "]";
	}

}

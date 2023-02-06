package prCuentaPalabrasSimplesFichero2;

import java.util.*;
import java.io.*;

public class ContadorPalabras {
	private int numPalabras;
	private static final int TAM_INICIAL = 10;
	PalabraEnTexto[] palabras;
	
	public ContadorPalabras() {
		this(TAM_INICIAL);
	}
	
	public ContadorPalabras(int n) {
		palabras = new PalabraEnTexto[n];
		numPalabras = 0;
	}
	
	public int esta(String pal) {
		PalabraEnTexto busc = new PalabraEnTexto(pal);
		int idx = -1;
		for (int i = 0; i < numPalabras && idx == -1; i++) {
			if (palabras[i].equals(busc)) {
				idx = i;
			}
		}
		return idx;
	}
	
	protected void incluye(String pal) {
		int idx = esta(pal);
		if (idx != -1) {
			palabras[idx].incrementa();
		} else {
			anyadir(pal);
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
	
	public void incluyeTodasFichero(String nomFich, String del) {
		try(Scanner sc = new Scanner(new File(nomFich))) {
			leerFichero(sc, del);
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no fue encontrado");
		}
	}
	
	private void leerFichero(Scanner sc, String del) {
		while (sc.hasNextLine()) {
			try(Scanner sc2 = new Scanner(sc.nextLine())) {
				sc2.useDelimiter(del);
				while (sc2.hasNext()) {
					incluye(sc2.next());
				}
			}
		}
	}
	
	public PalabraEnTexto encuentra(String pal) {
		PalabraEnTexto x = new PalabraEnTexto(pal);
		int i = 0;
		while (i < numPalabras && !(x.equals(palabras[i]))) {
			i++;
		}
		if (i == numPalabras) {
			throw new NoSuchElementException();
		}
		return palabras[i];
	}
	
	public void presentaPalabras(String fichero) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(new File(fichero))) {
			presentaPalabras(pw);
		}
	}
	
	public void presentaPalabras(PrintWriter pw) {
		for (int i = 0; i < numPalabras; i++) {
			pw.println(palabras[i]);
		}
	}
	
	private void anyadir(String pal) {
		PalabraEnTexto nueva = new PalabraEnTexto(pal);
		if (palabras.length == numPalabras) {
			palabras = Arrays.copyOf(palabras, 2 * palabras.length);
		}
		palabras[numPalabras] = nueva;
		numPalabras++;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (numPalabras > 0) {
			for (int i = 0; i < numPalabras - 1; i++) {
				sb.append(palabras[i].toString() + ", ");
			}
			sb.append(palabras[numPalabras - 1].toString());
		}
		sb.append("]");
		return sb.toString();
	}
	
}

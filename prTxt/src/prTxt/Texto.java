package prTxt;

import java.util.*;

public class Texto {
	private static final int TAM = 8;
	private int nlineas;
	private String[] lista;

	public Texto() {
		nlineas = 0;
		lista = new String[TAM];
	}

	public void anyadirTexto(String txt) {
		if (txt == null) {
			throw new RuntimeException("Argumentos erróneos");
		}
		if (nlineas == lista.length) {
			lista = Arrays.copyOf(lista, 2 * lista.length);
		}
		lista[nlineas] = txt;
		++nlineas;
	}
}
package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

public abstract class IndiceAbstracto implements Indice {

	protected List<String> frases;

	public IndiceAbstracto() {
		frases = new ArrayList<String>();
	}

	@Override
	public void agregarFrase(String frase) {
		frases.add(frase);
	}

	@Override
	public void resolver(String delimitadores) {
		// TODO Auto-generated method stub

	}

	@Override
	public void presentarIndice(PrintWriter pw) {

	}

	@Override
	public void presentarIndiceConsola() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(System.out, true);
			presentarIndice(pw);
		} finally {
			if (pw != null) {
				pw.flush();
			}
		}
	}

}

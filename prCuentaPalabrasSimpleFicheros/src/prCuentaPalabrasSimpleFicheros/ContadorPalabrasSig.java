package prCuentaPalabrasSimpleFicheros;

import java.io.*;
import java.util.*;

public class ContadorPalabrasSig extends ContadorPalabras {
	private String[] noSignificativas;
	private static final int TAM = 10;
	private int numPalNoSig;

	public ContadorPalabrasSig(String[] palsNS) {
		this(TAM, palsNS);
	}

	public ContadorPalabrasSig(int n, String[] palsNS) {
		super(n);
		palsNS = normalizar(palsNS);
		noSignificativas = Arrays.copyOf(palsNS, palsNS.length);
		numPalNoSig = noSignificativas.length;
	}
	
	public ContadorPalabrasSig(String FileNoSig, String del) throws FileNotFoundException {
		this(TAM, FileNoSig, del);
	}

	public ContadorPalabrasSig(int n, String FilNoSig, String del) throws FileNotFoundException {
		super(n);
		noSignificativas = new String[TAM];
		numPalNoSig = 0;
		leerFicheroNoSig(FilNoSig, del);
	}

	private void leerFicheroNoSig(String FilNoSig, String del) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(FilNoSig))) {
			leerPalabrasNoSignificativas(sc, del);
		}
	}

	private void leerPalabrasNoSignificativas(Scanner sc, String del) {
		while (sc.hasNextLine()) {
			String[] linea = sc.nextLine().split(del);
			linea = normalizar(linea);
			for (int i = 0; i < linea.length; i++) {
				anyadirNoSig(linea[i]);
			}
		}
	}
	
	protected void anyadirNoSig(String linea) {
		if (numPalNoSig == noSignificativas.length) {
			noSignificativas = java.util.Arrays.copyOf(noSignificativas, 2 * noSignificativas.length);
		}
		noSignificativas[numPalNoSig] = linea;
		numPalNoSig++;
	}

	@Override
	protected void incluye(String linea) {
		boolean esta = estaNoSig(linea);
		if (!esta) {
			super.incluye(linea);
		}
	}
	
	private boolean estaNoSig(String linea) {
		boolean res = false;
		int i = 0;
		while (i < numPalNoSig && res == false) {
			if (noSignificativas[i].equals(linea.toUpperCase())) {
				res = true;
			}
			i++;
		}
		return res;
	}

	private String[] normalizar(String[] palsNS) {
		for (int i = 0; i < palsNS.length; i++) {
			palsNS[i] = palsNS[i].toUpperCase();
		}
		return palsNS;
	}
}

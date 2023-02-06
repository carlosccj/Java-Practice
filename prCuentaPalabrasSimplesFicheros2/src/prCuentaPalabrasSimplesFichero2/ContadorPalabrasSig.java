package prCuentaPalabrasSimplesFichero2;

import java.io.*;
import java.util.*;

public class ContadorPalabrasSig extends ContadorPalabras {
	private String[] noSignificativas;
	private static final int TAM = 8;
	private int numPalNoSig;
	
	public ContadorPalabrasSig(String[] palNS) {
		this(TAM, palNS);
	}
	
	public ContadorPalabrasSig(int n, String[] palNS) {
		super(n);
		noSignificativas = normalizar(palNS);
		numPalNoSig = palNS.length;
	}
	
	private String[] normalizar(String[] pals) {
		String[] norm = new String[pals.length];
		for (int i = 0; i < pals.length; i++) {
			norm[i] = pals[i].toUpperCase();
		}
		return norm;
	}
	
	public ContadorPalabrasSig(String filNoSig, String del) throws FileNotFoundException {
		super();
		noSignificativas = new String[TAM];
		numPalNoSig = 0;
		leerFicheroNoSig(filNoSig, del);
	}
	
	public ContadorPalabrasSig(int n, String filNoSig, String del) throws FileNotFoundException {
		super(n);
		noSignificativas = new String[TAM];
		numPalNoSig = 0;
		leerFicheroNoSig(filNoSig, del);
	}
	
	private void leerFicheroNoSig(String filNoSig, String del) throws FileNotFoundException {
		try(Scanner sc = new Scanner(new File(filNoSig))) {
			leerPalabrasNoSignificativas(sc, del);
		}
	}
	
	private void leerPalabrasNoSignificativas(Scanner sc, String del) {
		int cnt = 0;
		while(sc.hasNextLine()) {
			try(Scanner sc2 = new Scanner(sc.nextLine())) {
				sc2.useDelimiter(del);
				while(sc2.hasNext()) {
					String y = sc2.next();
					if (numPalNoSig == noSignificativas.length) {
						noSignificativas = Arrays.copyOf(noSignificativas, 2 * noSignificativas.length);
					}
					noSignificativas[cnt] = y.toUpperCase();
					cnt++;
				}
			}
		}
	}
	
	@Override
	protected void incluye(String pal) {
		boolean sig = buscar(pal);
		if (!sig) {
			super.incluye(pal);
		}
	}
	
	private boolean buscar(String pal) {
		boolean ok = false;
		for (int i = 0; i < numPalNoSig && !ok; i++) {
			if(pal.toUpperCase().equals(noSignificativas[i])) {
				ok = true;
			}
		}
		return ok;
	}

}

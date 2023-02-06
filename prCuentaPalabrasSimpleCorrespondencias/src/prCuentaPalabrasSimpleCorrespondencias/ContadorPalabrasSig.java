package prCuentaPalabrasSimpleCorrespondencias;

import java.io.*;
import java.util.*;

public class ContadorPalabrasSig extends ContadorPalabras {
	private Set<String> noSignificativas;

	public ContadorPalabrasSig(Collection<String> palNS) {
		super();
		noSignificativas = normalizar(palNS);
	}

	public ContadorPalabrasSig(String filNoSig, String del) throws FileNotFoundException {
		super();
		noSignificativas = new HashSet<String>();
		leerFicheroNoSig(filNoSig, del);
	}

	private void leerFicheroNoSig(String filNoSig, String del) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(filNoSig))) {
			leerPalabrasNoSignificativas(sc, del);
		}
	}

	private void leerPalabrasNoSignificativas(Scanner sc, String del) {
		while (sc.hasNextLine()) {
			try (Scanner sc2 = new Scanner(sc.nextLine())) {
				sc2.useLocale(Locale.ENGLISH);
				sc2.useDelimiter(del);
				while (sc2.hasNext()) {
					noSignificativas.add(sc2.next().toUpperCase());
				}
			} catch (InputMismatchException e) {
				
			} catch (NoSuchElementException e) {
				
			}
		}
	}

	private Set<String> normalizar(Collection<String> x) {
		Set<String> res = new HashSet<String>();
		Iterator<String> it = x.iterator();
		while (it.hasNext()) {
			String mayus = it.next().toUpperCase();
			res.add(mayus);
		}
		return res;
	}

	@Override
	protected void incluye(String pal) {
		if (!(noSignificativas.contains(pal.toUpperCase()))) {
			super.incluye(pal);
		}
	}
}

package prAlturas2;

import java.util.*;
import java.io.*;

public class Mundo {

	private List<Pais> paises;

	private Mundo(List<Pais> listaPaises) {
		paises = listaPaises;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public static Mundo createFromFile(String file) throws FileNotFoundException {
		List<Pais> listaPaises = new ArrayList<Pais>();
		try (Scanner sc = new Scanner(new File(file))) {
			while (sc.hasNextLine()) {
				anyadirPais(sc.nextLine(), listaPaises);
			}
		}
		return new Mundo(listaPaises);

	}

	private static void anyadirPais(String data, List<Pais> listaPaises) {
		try (Scanner sc = new Scanner(data)) {
			sc.useLocale(Locale.ENGLISH);
			sc.useDelimiter("\\s*[,]\\s*");
			Pais nuevo = new Pais(sc.next(), sc.next(), Double.parseDouble(sc.next()));
			listaPaises.add(nuevo);
		} catch (NumberFormatException e) {

		} catch (NoSuchElementException e) {

		}
	}

	public static <K, V> void presentaEnConsola(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println(entry.getKey().toString() + " " + entry.getValue().toString() + "\n");
		}
	}

	public SortedMap<String, Integer> numeroDePaisesPorContinente() {
		SortedMap<String, Integer> cpn = new TreeMap<String, Integer>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while (it.hasNext()) {
			Pais x = it.next();
			if (cpn.containsKey(x.getContinente())) {
				int cuenta = cpn.remove(x.getContinente()) + 1;
				cpn.put(x.getContinente(), cuenta);
			} else {
				cpn.put(x.getContinente(), 1);
			}
		}
		return cpn;
	}
	
	public SortedMap<Double, List<Pais>> paisesPorAltura() {
		SortedMap<Double, List<Pais>> ppa = new TreeMap<Double, List<Pais>>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while (it.hasNext()) {
			Pais p = it.next();
			Double alt = Math.floor(p.getAltura() * 10) / 10;
			if (ppa.containsKey(alt)) {
				List<Pais> x = ppa.remove(alt);
				x.add(p);
				ppa.put(alt, x);
			} else {
				List<Pais> x = new ArrayList<Pais>();
				x.add(p);
				ppa.put(alt, x);
			}
		}
		return ppa;
	}
	
	public SortedMap<String, SortedSet<Pais>> paisesPorContinente() {
		SortedMap<String, SortedSet<Pais>> ppc = new TreeMap<String, SortedSet<Pais>>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while(it.hasNext()) {
			Pais x = it.next();
			if (ppc.containsKey(x.getContinente())) {
				SortedSet<Pais> listaPaises = ppc.remove(x.getContinente());
				listaPaises.add(x);
				ppc.put(x.getContinente(), listaPaises);
			} else {
				SortedSet<Pais> listaPaises = new TreeSet<Pais>();
				listaPaises.add(x);
				ppc.put(x.getContinente(), listaPaises);
			}
		}
		return ppc;
	}
	
	public SortedMap<Character, SortedSet<Pais>> paisesPorInicial() {
		SortedMap<Character, SortedSet<Pais>> ppi = new TreeMap<Character, SortedSet<Pais>>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while (it.hasNext()) {
			Pais x = it.next();
			Character inicial = x.getNombre().charAt(0);
			if (ppi.containsKey(inicial)) {
				SortedSet<Pais> listaPaises = ppi.remove(inicial);
				listaPaises.add(x);
				ppi.put(inicial, listaPaises);
			} else {
				SortedSet<Pais> listaPaises = new TreeSet<Pais>();
				listaPaises.add(x);
				ppi.put(inicial, listaPaises);
			}
		}
		return ppi;
	}
	
	public SortedMap<String, Double> mediaPorContinente() {
		SortedMap<String, Double> mpc = new TreeMap<String, Double>();
		SortedMap<String, SortedSet<Pais>> ppc = this.paisesPorContinente();
		for (Map.Entry<String, SortedSet<Pais>> entry : ppc.entrySet()) {
			mpc.put(entry.getKey(), calcMediaPaises(entry.getValue()));
		}
		return mpc;
	}
	
	public List<String> continentesConMasPaises() {
		List<String> ccmp = new ArrayList<String>();
		SortedMap<String, Integer> ppc = this.numeroDePaisesPorContinente();
		int npaises = 0;
		String cont = "";
		for (Map.Entry<String, Integer> entry : ppc.entrySet()) {
			if (npaises < entry.getValue()) {
				npaises = entry.getValue();
				cont = entry.getKey();
			}
		}
		ccmp.add(cont);
		return ccmp;
	}
	
	private Double calcMediaPaises(SortedSet<Pais> listaPaises) {
		Iterator<Pais> it = listaPaises.iterator();
		Double media = 0.0;
		int cnt = 0;
		while (it.hasNext()) {
			media += it.next().getAltura();
			cnt++;
		}
		return media / cnt;
	}
 
}

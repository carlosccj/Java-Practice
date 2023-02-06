package alturas;

import java.util.*;
import java.io.*;

public class Mundo {

	private List<Pais> paises;

	private Mundo(List<Pais> res) {
		paises = res;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public static Mundo createFromFile(String file) throws FileNotFoundException {
		List<Pais> listaPaises = new ArrayList<Pais>();
		try (Scanner sc = new Scanner(new File(file))) {
			while (sc.hasNextLine()) {
				anyadir(sc.nextLine(), listaPaises);
			}
		}
		Mundo res = new Mundo(listaPaises);
		return res;
	}

	private static void anyadir(String linea, List<Pais> listaPaises) {
		try {
		String[] data = linea.split("\\s*[,]\\s*");
		double alt = Double.parseDouble(data[2]);
		Pais p = new Pais(data[0], data[1], alt);
		listaPaises.add(p);
		} catch (NumberFormatException e) {

		} catch (IndexOutOfBoundsException e) {

		}
	}

	public static <K, V> void presentaEnConsola(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println(entry.getKey().toString() + " " + entry.getValue().toString() + "\n");
		}
	}

	public SortedMap<String, Integer> numeroDePaisesPorContinente() {
		SortedMap<String, Integer> npc = new TreeMap<String, Integer>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while (it.hasNext()) {
			String cont = it.next().getContinente();
			if (npc.containsKey(cont)) {
				Integer inc = npc.get(cont) + 1;
				npc.remove(cont);
				npc.put(cont, inc);
			} else {
				npc.put(cont, 1);
			}
		}
		return npc;
	}

	public SortedMap<Double, List<Pais>> paisesPorAltura() {
		SortedMap<Double, List<Pais>> ppa = new TreeMap<Double, List<Pais>>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while (it.hasNext()) {
			Double alt = it.next().getAltura();
			if (!ppa.containsKey(alt)) {
				List<Pais> x = listaPorAltura(alt);
				ppa.put(round(alt, 1), x);
			}
		}
		return ppa;
	}

	private double round(double value, int places) {
		double scale = Math.pow(10, places);
		return Math.floor(value * scale) / scale;
	}

	private List<Pais> listaPorAltura(Double alt) {
		List<Pais> listAltura = new ArrayList<Pais>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while (it.hasNext()) {
			Pais x = it.next();
			if (round(x.getAltura(), 1) == round(alt, 1)) {
				listAltura.add(x);
			}
		}
		return listAltura;
	}

	public SortedMap<String, SortedSet<Pais>> paisesPorContinente() {
		SortedMap<String, SortedSet<Pais>> ppc = new TreeMap<String, SortedSet<Pais>>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while (it.hasNext()) {
			String cont = it.next().getContinente();
			if (!ppc.containsKey(cont)) {
				SortedSet<Pais> setPaises = setPorPaises(cont);
				ppc.put(cont, setPaises);
			}
		}
		return ppc;
	}

	private SortedSet<Pais> setPorPaises(String cont) {
		SortedSet<Pais> setPaises = new TreeSet<Pais>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while (it.hasNext()) {
			Pais x = it.next();
			if (x.getContinente().equals(cont)) {
				setPaises.add(x);
			}
		}
		return setPaises;
	}

	public SortedMap<Character, SortedSet<Pais>> paisesPorInicial() {
		SortedMap<Character, SortedSet<Pais>> ppi = new TreeMap<Character, SortedSet<Pais>>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while (it.hasNext()) {
			Character inicial = it.next().getNombre().charAt(0);
			if (!ppi.containsKey(inicial)) {
				SortedSet<Pais> setIniciales = setPorIniciales(inicial);
				ppi.put(inicial, setIniciales);
			}
		}
		return ppi;
	}

	private SortedSet<Pais> setPorIniciales(Character inc) {
		SortedSet<Pais> setIniciales = new TreeSet<Pais>();
		ListIterator<Pais> it = this.getPaises().listIterator();
		while (it.hasNext()) {
			Pais x = it.next();
			if (x.getNombre().charAt(0) == inc) {
				setIniciales.add(x);
			}
		}
		return setIniciales;
	}

	public SortedMap<String, Double> mediaPorContinente() {
		SortedMap<String, Double> ppm = new TreeMap<String, Double>();
		SortedMap<String, SortedSet<Pais>> ppc = paisesPorContinente();
		for (Map.Entry<String, SortedSet<Pais>> entry : ppc.entrySet()) {
			ppm.put(entry.getKey(), calcularMedia(entry.getValue()));
		}
		return ppm;
	}

	private double calcularMedia(SortedSet<Pais> listaPaises) {
		double media = 0;
		Iterator<Pais> it = listaPaises.iterator();
		while (it.hasNext()) {
			media += it.next().getAltura();
		}
		return media / listaPaises.size();
	}

	public List<String> continentesConMasPaises() {
		List<String> maxPaises = new ArrayList<String>();
		SortedMap<String, Integer> ppc = numeroDePaisesPorContinente();
		int max = maximo(ppc);
		for (Map.Entry<String, Integer> entry : ppc.entrySet()) {
			if (entry.getValue() == max) {
				maxPaises.add(entry.getKey());
			}
		}
		return maxPaises;
	}

	private int maximo(SortedMap<String, Integer> ppc) {
		int max = 0;
		for (Map.Entry<String, Integer> entry : ppc.entrySet()) {
			int n = entry.getValue();
			max = (max < n) ? n : max;
		}
		return max;
	}
}

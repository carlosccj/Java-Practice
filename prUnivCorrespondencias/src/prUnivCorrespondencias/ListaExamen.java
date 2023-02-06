package prUnivCorrespondencias;

import java.util.*;

public class ListaExamen {

	private SortedMap<Persona, Double> personas;

	public ListaExamen() {
		personas = new TreeMap<Persona, Double>();
	}

	public void anyadirNota(Persona per, double nt) {
		if (personas.containsKey(per)) {
			personas.remove(per);
			personas.put(per, nt);
		} else {
			personas.put(per, nt);
		}
	}

	public double buscarNota(String n, String d) {
		double nt = -1.0;
		Persona per = new Persona(n, d);
		if (personas.containsKey(per)) {
			nt = personas.get(per);
		}
		return nt;
	}

	public void eliminarNota(String n, String d) {
		Persona per = new Persona(n, d);
		if (personas.containsKey(per)) {
			personas.remove(per);
		}
	}

	public Set<Persona> listaAprobados() {
		Set<Persona> aprobados = new TreeSet<Persona>();
		for (Map.Entry<Persona, Double> entry : personas.entrySet()) {
			if (entry.getValue() >= 5) {
				aprobados.add(entry.getKey());
			}
		}
		return aprobados;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		int cnt = 0;
		for (Map.Entry<Persona, Double> entry : personas.entrySet()) {
			Persona x = entry.getKey();
			Double nt = entry.getValue();
			if (cnt != personas.size() - 1) {
				sb.append("(" + x.getNombre() + ", " + x.getDni() + ", " + nt + "); ");
				cnt++;
			}
		}
		sb.append("(" + personas.lastKey().getNombre() + ", " + personas.lastKey().getDni() + ", "
				+ personas.get(personas.lastKey()) + ")");
		sb.append(" ]");
		return sb.toString();
	}
}

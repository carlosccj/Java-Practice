package prUnivCorrespondencias;

import java.util.*;

public class ListaNotas {

	private SortedMap<Persona, List<Double>> notas;

	public ListaNotas() {
		notas = new TreeMap<Persona, List<Double>>();
	}

	public void anyadirNota(Persona per, double nt) {
		if (notas.containsKey(per)) {
			List<Double> lista = notas.remove(per);
			lista.add(nt);
			notas.put(per, lista);
		} else {
			List<Double> lista = new ArrayList<Double>();
			lista.add(nt);
			notas.put(per, lista);
		}
	}

	public double buscarNota(String n, String d) {
		Persona per = new Persona(n, d);
		double notaMed = -1.0;
		if (notas.containsKey(per)) {
			notaMed = calcularMedia(notas.get(per));
		}
		return notaMed;
	}

	private double calcularMedia(List<Double> lista) {
		double notaMed = 0.0;
		ListIterator<Double> it = lista.listIterator();
		while (it.hasNext()) {
			notaMed += it.next();
		}
		return notaMed / lista.size();
	}

	public void eliminarNota(String n, String d, double nt) {
		Persona per = new Persona(n, d);
		if (notas.containsKey(per)) {
			eliminar(notas.get(per), nt);
		}
		if (notas.get(per).size() == 0) {
			notas.remove(per);
		}
	}

	private void eliminar(List<Double> lista, double nt) {
		ListIterator<Double> it = lista.listIterator();
		while (it.hasNext()) {
			double nota = it.next();
			if (nt == nota) {
				it.remove();
			}
		}
	}

	public void eliminarNotas(String n, String d) {
		Persona per = new Persona(n, d);
		if (notas.containsKey(per)) {
			notas.remove(per);
		}
	}

	public Set<Persona> listaAprobados() {
		Set<Persona> aprobados = new HashSet<Persona>();
		for (Map.Entry<Persona, List<Double>> entry : notas.entrySet()) {
			double notaMed = calcularMedia(entry.getValue());
			if (notaMed >= 5) {
				aprobados.add(entry.getKey());
			}
		}
		return aprobados;
	}
	
	public double buscarMayorNota() {
		double mayorNt = mayorNota(notas.get(notas.firstKey()));
		for (Map.Entry<Persona, List<Double>> entry : notas.entrySet()) {
			double notaMed = mayorNota(entry.getValue());
			if (mayorNt < notaMed) {
				mayorNt = notaMed;
			}
		}
		return mayorNt;
	}
	
	private double mayorNota(List<Double> lista) {
		double nt = 0.0;
		ListIterator<Double> it = lista.listIterator();
		while (it.hasNext()) {
			double nota = it.next();
			if (nt < nota) {
				nt = nota;
			}
		}
		return nt;
	}
	
	//public Set<Persona> buscarAlumnosConMayorNota() {
		Set<Persona> mejores = new HashSet<Persona>();
		
	//}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		int cnt = 0;
		for (Map.Entry<Persona, List<Double>> entry : notas.entrySet()) {
			Persona per = entry.getKey();
			List<Double> lista = entry.getValue();
			if (cnt != notas.size() - 1) {
				sb.append("(" + per.getNombre() + ", " + per.getDni() + ", " + lista.toString() + "); ");
			}
		}
		sb.append("(" + notas.lastKey().getNombre() + ", " + notas.lastKey().getDni() + ", " + 
		notas.get(notas.lastKey()).toString() + ")");
		sb.append( "]");
		return sb.toString();
	}

}

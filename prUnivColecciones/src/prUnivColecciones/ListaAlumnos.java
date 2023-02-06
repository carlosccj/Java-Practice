package prUnivColecciones;

import java.util.*;

public class ListaAlumnos {

	private SortedSet<Alumno> alumnos;

	public ListaAlumnos() {
		alumnos = new TreeSet<Alumno>();
	}

	public ListaAlumnos(Comparator<Alumno> cmp) {
		alumnos = new TreeSet<Alumno>(cmp);
	}

	public void anyadirAlumno(Alumno al) {
		if (alumnos.contains(al)) {
			alumnos.remove(al);
		}
		alumnos.add(al);
	}

	public Optional<Alumno> buscarAlumno(String n, String d) {
		Optional<Alumno> res;
		Alumno aln = buscarAlumno(new Alumno(n, d, 0));
		if (aln != null) {
			res = Optional.of(aln);
		} else {
			res = Optional.empty();
		}
		return res;
	}

	private Alumno buscarAlumno(Alumno aln) {
		Alumno a = null;
		boolean ok = false;
		Iterator<Alumno> it = alumnos.iterator();
		while (!ok && it.hasNext()) {
			a = it.next();
			ok = a.equals(aln);
		}
		return ok ? a : null;
	}

	public void eliminarAlumno(String n, String d) {
		Alumno al = new Alumno(n, d, 0.0);
		if (alumnos.contains(al)) {
			alumnos.remove(al);
		}
	}

	public Set<Alumno> listaAprobados() {
		Set<Alumno> aprobados = new HashSet<Alumno>();
		Iterator<Alumno> it = alumnos.iterator();
		while (it.hasNext()) {
			Alumno al = it.next();
			if (al.getNota() >= 5) {
				aprobados.add(al);
			}
		}
		return aprobados;
	}
	
	public Set<Alumno> seleccionar(SelectorAlumno selAl) {
		Set<Alumno> seleccionados = new HashSet<Alumno>();
		Iterator<Alumno> it = alumnos.iterator();
		while (it.hasNext()) {
			Alumno x = it.next();
			boolean ok = selAl.esSeleccionable(x);
			if (ok) {
				seleccionados.add(x);
			}
		}
		return seleccionados;
	}
	
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof ListaAlumnos) {
			ListaAlumnos other = (ListaAlumnos) o;
			ok = (this.alumnos.size() == other.alumnos.size() && this.alumnos.containsAll(other.alumnos));
		}
		return ok;
	}
	
	public int hashCode() {
		int hc = Integer.hashCode(alumnos.size());
		Iterator<Alumno> it = alumnos.iterator();
		while (it.hasNext()) {
			hc += it.next().hashCode();
		}
		return hc;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Alumno> it = alumnos.iterator();
		int cnt = 0;
		while (it.hasNext() && cnt < alumnos.size() - 1) {
			sb.append(it.next().toString() + ", ");
			cnt++;
		}
		sb.append(alumnos.last().toString());
		return sb.toString();
	}

}

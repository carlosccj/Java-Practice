package prUniv;

import java.util.*;
import java.io.*;

public class ListaAlumnos {
	private Alumno[] lista;
	private int nalms;
	private static int TAM = 8;

	public ListaAlumnos() {
		lista = new Alumno[TAM];
		nalms = 0;
	}

	public void anyadirAlumno(Alumno x) {
		int idx = detectar(x);
		if (idx != -1) {
			lista[idx] = x;
		} else {
			agregar(x);
		}
	}

	public void anyadirAlumnos(String linea) {
		String[] alums = linea.split("\\s*[;]\\s*");
		for (int i = 0; i < alums.length; i++) {
			String[] data = alums[i].split("\\s*[,]\\s*");
			try {
				anyadirAlumno(new Alumno(data[0], data[1], Double.parseDouble(data[2])));
			} catch (IndexOutOfBoundsException e) {

			} catch (NumberFormatException e) {
				
			}
		}
	}

	public void anyadirNotasAlumno(String alum) {
		try {
			String[] datos = alum.split("\\s*[,]\\s*");
			double media = calcMedia(datos);
			anyadirAlumno(new Alumno(datos[0], datos[1], media));
		} catch (RuntimeException e) {
			System.out.println("Error por falta de datos");
		}
	}

	private double calcMedia(String[] notas) {
		double sum = 0;
		try {
			for (int i = 2; i < notas.length; i++) {
				sum += Double.parseDouble(notas[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("Error en el cálculo de la media");
		}
		return sum / (notas.length - 2);
	}

	private int detectar(Alumno x) {
		int idx = -1;
		for (int i = 0; i < nalms && idx == -1; i++) {
			if (lista[i].equals(x)) {
				idx = i;
			}
		}
		return idx;
	}

	private void agregar(Alumno x) {
		if (nalms == lista.length) {
			lista = Arrays.copyOf(lista, 2 * lista.length);
		}
		lista[nalms] = x;
		nalms++;
	}

	public void cargarDeFichero(String fich) {
		try (Scanner sc = new Scanner(new File(fich))) {
			while (sc.hasNextLine()) {
				anyadirAlumnos(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("El fichero solicitado no existe");
		}
	}

	public void guardarEnFichero(String fich) {
		try (PrintWriter pw = new PrintWriter(fich)) {
			for (int i = 0; i < nalms; i++) {
				pw.println(lista[i].toString() + "\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: no se encuentra el fichero");
		}
	}

	public void mostrarEnConsola() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(System.out, true);
			for (int i = 0; i < nalms; i++) {
				pw.println(lista[i].toString() + "\n");
			}
		} finally {
			if (pw != null) {
				pw.flush();
			}
		}
	}

	public void eliminarAlumno(Alumno aln) {
		int idx = detectar(aln);
		if (idx != -1) {
			System.arraycopy(lista, (idx + 1), lista, idx, nalms - (idx + 1));
			nalms--;
			lista[nalms] = null;
		} else {
			throw new RuntimeException("Error: el alumno solicitado no existe");
		}
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("; ", "[ ", " ]");
		for (int i = 0; i < nalms; i++) {
			sj.add(lista[i].toString());
		}
		return sj.toString();
	}

	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof ListaAlumnos) {
			ListaAlumnos other = (ListaAlumnos) o;
			ok = (this.nalms == other.nalms && this.comparar(other));
		}
		return ok;
	}

	@Override
	public int hashCode() {
		int h = Integer.hashCode(this.nalms);
		for (int i = 0; i < nalms; i++) {
			h += lista[i].hashCode();
		}
		return h;
	}

	private boolean comparar(ListaAlumnos other) {
		boolean ok = true;
		for (int i = 0; i < other.nalms && ok; i++) {
			if (detectar(other.lista[i]) == -1) {
				ok = false;
			}
		}
		return ok;
	}

	public Alumno[] seleccionar(SelectorAlumno x) {
		Alumno[] selected = new Alumno[nalms];
		int nselec = 0;
		for (int i = 0; i < nalms; i++) {
			if (x.esSeleccionable(lista[i])) {
				selected[nselec] = lista[i];
				nselec++;
			}
		}
		selected = Arrays.copyOf(selected, nselec);
		return selected;
	}
}

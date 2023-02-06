package prNotas3;

import java.util.*;

import prNotas3.AlumnoException;

public class Asignatura {

	private String nombre;
	private List<String> errores;
	private List<Alumno> alumnos;

	public Asignatura(String nom, String[] datos) {
		nombre = nom;
		procesar(datos);
	}

	private void procesar(String[] datos) {
		errores = new ArrayList<String>();
		alumnos = new ArrayList<Alumno>();
		for (int i = 0; i < datos.length; i++) {
			try {
				String[] dataAlu = datos[i].split("\\s*[;]\\s*");
				Alumno x = new Alumno(dataAlu[0], dataAlu[1], Double.parseDouble(dataAlu[2]));
				alumnos.add(x);
			} catch (AlumnoException e) {
				errores.add("ERROR. Calificacion negativa: " + datos[i]);
			} catch (NumberFormatException e) {
				errores.add("ERROR. Nota no numerica: " + datos[i]);
			} catch (IndexOutOfBoundsException e) {
				errores.add("ERROR. Faltan datos: " + datos[i]);
			}
		}
	}
	
	public double getCalificacion(Alumno al) throws AlumnoException {
		double res = 0.0;
		boolean ok = false;
		if (alumnos.isEmpty()) {
			throw new AlumnoException("No hay alumnos");
		}
		ListIterator<Alumno> it = alumnos.listIterator();
		while (it.hasNext() && !ok) {
			Alumno x = it.next();
			if (x.getNombre().equals(al.getNombre())) {
				res = x.getCalificacion();
				ok = true;
			}
		}
		return res;
	}
	
	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}
	
	public List<String> getErrores() {
		return this.errores;
	}
	
	public double getMedia() throws AlumnoException {
		double media = 0.0;
		if (alumnos.isEmpty()) {
			throw new AlumnoException("No hay alumnos");
		}
		ListIterator<Alumno> it = alumnos.listIterator();
		while (it.hasNext()) {
			media += it.next().getCalificacion();
		}
		return media / alumnos.size();
	}
	
	public double getMedia(CalculoMedia calc) throws AlumnoException {
		return calc.calcular(this.getAlumnos());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nombre + ": { [");
		ListIterator<Alumno> it = alumnos.listIterator();
		int cnt = 0;
		while (it.hasNext() && cnt != alumnos.size() - 1) {
			sb.append(it.next().toString() + ", ");
			cnt++;
		}
		sb.append(alumnos.get(alumnos.size() - 1) + "], ");
		ListIterator<String> it2 = errores.listIterator();
		int cnt2 = 0;
		while (it2.hasNext() && cnt2 != errores.size() - 1) {
			sb.append(it2.next() + ", ");
			cnt2++;
		}
		sb.append(errores.get(errores.size() - 1) + "] }");
		return sb.toString();
	}

}

package prNotas;

import java.util.Arrays;

public class Asignatura {
	private String nombre;
	private String[] errores;
	private Alumno[] alumnos;

	public Asignatura(String nom, String[] alum) {
		nombre = nom;
		procesarDatos(alum);
	}

	private void procesarDatos(String[] alum) {
		alumnos = new Alumno[alum.length];
		errores = new String[alum.length];
		int al = 0;
		int err = 0;
		for (String x : alum) {
			String[] info = x.split("\\s*[;]\\s*");
			try {
				double notilla = Double.parseDouble(info[2]);
				Alumno z = new Alumno(info[0], info[1], notilla);
				alumnos[al] = z;
				al++;
			} catch (AlumnoException e) {
				errores[err] = "ERROR. Calificacion negativa: " + x;
				err++;
			} catch (NumberFormatException e) {
				errores[err] = "ERROR. Calificacion no numerica: " + x;
				err++;
			} catch (IndexOutOfBoundsException e) {
				errores[err] = "ERROR. Faltan datos: " + x;
				err++;
			}
		}

		alumnos = Arrays.copyOf(alumnos, al);
		errores = Arrays.copyOf(errores, err);
	}

	public double getCalificacion(Alumno al) throws AlumnoException {
		int idx = buscarAlumno(al);
		if (idx >= alumnos.length) {
			throw new AlumnoException("El alumno " + al.toString() + " no se encuentra");
		}
		return alumnos[idx].getCalificacion();
	}

	private int buscarAlumno(Alumno al) {
		int i = 0;
		while (i < alumnos.length && !(al.equals(alumnos[i]))) {
			i++;
		}
		return i;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public String[] getErrores() {
		return errores;
	}

	public double getMedia(CalculoMedia calc) throws AlumnoException {
		double media = calc.calcular(this.getAlumnos());
		return media;
	}
	
	public double getMedia() throws AlumnoException {
		double media = 0;
		if (alumnos.length <= 0) {
			throw new AlumnoException("No hay alumnos");
		}
		for (Alumno x : alumnos) {
			media += x.getCalificacion();
		}
		media = media / (alumnos.length);
		return media;
	}
	
	@Override
	public String toString() {
		java.util.StringJoiner sj1 = new java.util.StringJoiner(", ", "[", "]");
		java.util.StringJoiner sj2 = new java.util.StringJoiner(", ", "[", "]");
		String str = "";
		for (int i = 0; i < alumnos.length; i++) {
			sj1.add(alumnos[i].toString());
		}
		str += sj1 + ", \n";
		for (int i = 0; i < errores.length; i++) {
			sj2.add(errores[i]);
		}
		str += sj2;
		return this.nombre + ": {" + str + "}";
	}
/*
	@Override
	public String toString() {
		String str = "";
		if (alumnos.length > 0) {
			str += alumnos[0].toString() + "\n";
			for (int i = 1; i < alumnos.length; i++) {
				str += alumnos[i].toString() + "\n";
			}
		}
		return str;
	}
*/
}

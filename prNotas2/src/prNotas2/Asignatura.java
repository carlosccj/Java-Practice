package prNotas2;

import java.util.Arrays;

public class Asignatura {
	private String nombre;
	private String[] errores;
	private Alumno[] alumnos;

	public Asignatura(String nom, String[] datos) {
		nombre = nom;
		procesar(datos);
	}

	private void procesar(String[] datos) {
		int als = 0;
		int err = 0;
		alumnos = new Alumno[datos.length];
		errores = new String[datos.length];
		for (int i = 0; i < datos.length; i++) {
			String alumno = datos[i];
			String[] aludata = alumno.split("\\s*[;]\\s*");
			try {
				Alumno x = new Alumno(aludata[0], aludata[1], Double.parseDouble(aludata[2]));
				alumnos[als] = x;
				als++;
			} catch (AlumnoException e) {
				String error = "ERROR. Calificación negativa: " + alumno;
				errores[err] = error;
				err++;
			} catch (IndexOutOfBoundsException e) {
				String error = "ERROR. Faltan datos: " + alumno;
				errores[err] = error;
				err++;
			} catch (NumberFormatException e) {
				String error = "ERROR. Nota no numérica: " + alumno;
				errores[err] = error;
				err++;
			}
		}
		alumnos = Arrays.copyOf(alumnos, als);
		errores = Arrays.copyOf(errores, err);
	}

	public double getCalificacion(Alumno al) throws AlumnoException {
		double cal = -1;
		for (int i = 0; i < alumnos.length && cal == -1; i++) {
			if (al.equals(alumnos[i])) {
				cal = alumnos[i].getNota();
			} else {
				throw new AlumnoException("El alumno " + al + " no se encuentra");
			}
		}
		return cal;
	}
	
	public Alumno[] getAlumnos() {
		return alumnos;
	}
	
	public String[] getErrores() {
		return errores;
	}
	
	public double getMedia() throws AlumnoException {
		if (alumnos.length < 1) {
			throw new AlumnoException("No hay alumnos en la asignatura");
		}
		double sum = 0;
		for (int i = 0; i < alumnos.length; i++) {
			sum += alumnos[i].getNota();
		}
		return sum / alumnos.length;
	}
	
	@Override
	public String toString() {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb1.append(nombre + ": { [");
		if (alumnos.length > 0) {
		for (int i = 0; i < alumnos.length - 1; i++) {
			sb1.append(alumnos[i].toString() + ", ");
		}
		sb1.append(alumnos[alumnos.length - 1].toString() + "], \n");
		}
		if (errores.length > 0) {
		sb2.append("[");
		for (int j = 0; j < errores.length - 1; j++) {
			sb2.append(errores[j].toString() + ", ");
		}
		sb2.append(errores[errores.length - 1].toString() + "] }");
		}
		return sb1.toString() + sb2.toString();
	}

}

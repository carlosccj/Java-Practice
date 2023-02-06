package prNotas3;

import java.util.*;

import prNotas3.AlumnoException;

public class Asignatura {

	private String nombre;
	private String[] errores;
	private Alumno[] alumnos;

	public Asignatura(String nom, String[] datos) {
		nombre = nom;
		procesar(datos);
	}

	private void procesar(String[] datos) {
		int alu = 0;
		int err = 0;
		errores = new String[datos.length];
		alumnos = new Alumno[datos.length];
		for (int i = 0; i < datos.length; i++) {
			try {
				String[] dataAlu = datos[i].split("\\s*[;]\\s*");
				Alumno x = new Alumno(dataAlu[0], dataAlu[1], Double.parseDouble(dataAlu[2]));
				alumnos[alu] = x;
				alu++;
			} catch (AlumnoException e) {
				errores[err] = "ERROR. Calificacion negativa: " + datos[alu + err];
				err++;
			} catch (NumberFormatException e) {
				errores[err] = "ERROR. Nota no numerica: " + datos[alu + err];
				err++;
			} catch (IndexOutOfBoundsException e) {
				errores[err] = "ERROR. Faltan datos: " + datos[alu + err];
				err++;
			}
		}
		errores = Arrays.copyOf(errores, err);
		alumnos = Arrays.copyOf(alumnos, alu);
	}
	
	public double getCalificacion(Alumno al) throws AlumnoException {
		double res = -1.0;
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i].getNombre().equals(al.getNombre()) && res == -1.0) {
				res = alumnos[i].getCalificacion();
			}
		} if (res == -1.0) {
			throw new AlumnoException("El alumno " + al.getNombre() + " no se encuentra");
		}
		return res;
	}
	
	public Alumno[] getAlumnos() {
		return this.alumnos;
	}
	
	public String[] getErrores() {
		return this.errores;
	}
	
	public double getMedia() throws AlumnoException {
		double media = 0.0;
		if (alumnos.length == 0) {
			throw new AlumnoException("No hay alumnos");
		}
		for (int i = 0; i < alumnos.length; i++) {
			media += alumnos[i].getCalificacion();
		}
		return media / alumnos.length;
	}
	
	public double getMedia(CalculoMedia calc) throws AlumnoException {
		return calc.calcular(this.getAlumnos());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nombre + ": { [");
		for (int i = 0; i < alumnos.length - 1; i++) {
			sb.append(alumnos[i].toString() + ", ");
		}	
		sb.append(alumnos[alumnos.length - 1].toString() + "], ");
		for (int j = 0; j < errores.length - 1; j++) {
			sb.append(errores[j] + ", ");
		}
		sb.append(errores[errores.length - 1] + "] }");
		return sb.toString();
	}

}

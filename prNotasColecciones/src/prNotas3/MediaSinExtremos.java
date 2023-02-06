package prNotas3;
import java.util.*;

public class MediaSinExtremos implements CalculoMedia {

	private double min;
	private double max;
	
	public MediaSinExtremos(double minimo, double maximo) {
		min = minimo;
		max = maximo;
	}
	
	public double getMin() {
		return this.min;
	}
	
	public double getMax() {
		return this.max;
	}
	
	@Override
	public double calcular(List<Alumno> alumnos) throws AlumnoException {
		double media = 0.0;
		int cnt = 0;
		ListIterator<Alumno> it = alumnos.listIterator();
		while (it.hasNext()) {
			Alumno x = it.next();
			if (x.getCalificacion() <= max && x.getCalificacion() >= min) {
				media += x.getCalificacion();
				cnt++;
			}
		}
		return media / cnt;
	}

}

package prNotas;

public class MediaSinExtremos implements CalculoMedia {
	private double min;
	private double max;
	
	public MediaSinExtremos(double minimo, double maximo) {
		min = minimo;
		max = maximo;
	}

	@Override
	public double calcular(Alumno[] alumnos) throws AlumnoException {
		double media = 0;
		int cnt = 0;
		if (alumnos.length <= 0) {
			throw new AlumnoException("No hay alumnos");
		} else {
			for (Alumno x : alumnos) {
				if (x.getCalificacion() >= this.getMin() && x.getCalificacion() <= this.getMax()) {
					media += x.getCalificacion();
					cnt++;
				}
			}
		}
		if (cnt == 0) {
			throw new AlumnoException("No hay alumnos");
		}
		return media / cnt;
	}
	
	public double getMin() {
		return min;
	}
	
	public double getMax() {
		return max;
	}

}

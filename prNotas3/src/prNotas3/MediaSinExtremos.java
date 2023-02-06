package prNotas3;

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
	public double calcular(Alumno[] alumnos) throws AlumnoException {
		double media = 0.0;
		int cnt = 0;
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i].getCalificacion() <= max && alumnos[i].getCalificacion() >= min) {
				media += alumnos[i].getCalificacion();
				cnt++;
			}
			if (cnt == 0) {
				throw new AlumnoException("No hay alumnos");
			}
		}
		return media / cnt;
	}

}

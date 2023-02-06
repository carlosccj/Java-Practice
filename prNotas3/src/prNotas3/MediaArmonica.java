package prNotas3;

public class MediaArmonica implements CalculoMedia {

	@Override
	public double calcular(Alumno[] alumnos) throws AlumnoException {
		double media = 0.0;
		int cnt = 0;
		if (alumnos.length == 0) {
			throw new AlumnoException("No hay alumnos");
		}
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i].getCalificacion() > 0) {
				media += 1 / alumnos[i].getCalificacion();
				cnt++;
			}
		}
		return cnt / media;
	}
}

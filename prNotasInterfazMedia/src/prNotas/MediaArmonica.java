package prNotas;


public class MediaArmonica implements CalculoMedia {

	@Override
	public double calcular(Alumno[] alumnos) throws AlumnoException {
		double media = 0;
		int cnt = 0;
		if (alumnos.length <= 0) {
			throw new AlumnoException("No hay alumnos");
		} else {
			for (Alumno x : alumnos) {
				if (x.getCalificacion() > 0) {
					media += (1 / x.getCalificacion());
					cnt++;
				}
			}
			if (cnt == 0) {
				throw new AlumnoException("No hay alumnos");
			}
			media = (1/media) * cnt;
		}
		return media;
	}
}

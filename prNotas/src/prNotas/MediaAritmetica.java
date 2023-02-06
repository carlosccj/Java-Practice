package prNotas;

public class MediaAritmetica implements CalculoMedia {

	@Override
	public double calcular(Alumno[] alumnos) throws AlumnoException {
		double media = 0;
		if (alumnos.length <= 0) {
			throw new AlumnoException("No hay alumnos");
		} else {
			for (Alumno x : alumnos) {
				media += x.getCalificacion();
			}
		}
		return media / alumnos.length;
	}

}

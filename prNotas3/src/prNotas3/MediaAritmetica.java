package prNotas3;

public class MediaAritmetica implements CalculoMedia {
	
	@Override
	public double calcular(Alumno[] alumnos) throws AlumnoException {
		double media = 0.0;
		if (alumnos.length == 0) {
			throw new AlumnoException("No hay alumnos");
		}
		for (int i = 0; i < alumnos.length; i++) {
			media += alumnos[i].getCalificacion();
		}
		return media / alumnos.length;
	}

}

package prNotas3;
import java.util.*;

public class MediaArmonica implements CalculoMedia {

	@Override
	public double calcular(List<Alumno> alumnos) throws AlumnoException {
		double media = 0.0;
		int cnt = 0;
		if (alumnos.isEmpty()) {
			throw new AlumnoException("No hay alumnos");
		}
		ListIterator<Alumno> it = alumnos.listIterator();
		while (it.hasNext()) {
			Alumno x = it.next();
			if (x.getCalificacion() > 0) {
				media += 1 / x.getCalificacion();
				cnt++;
			}
		}
		return cnt / media;
	}
}

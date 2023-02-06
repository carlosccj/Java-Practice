package prNotas3;
import java.util.*;

public class MediaAritmetica implements CalculoMedia {
	
	@Override
	public double calcular(List<Alumno> alumnos) throws AlumnoException {
		double media = 0.0;
		if (alumnos.isEmpty()) {
			throw new AlumnoException("No hay alumnos");
		}
		ListIterator<Alumno> it = alumnos.listIterator();
		while (it.hasNext()) {
			media += it.next().getCalificacion();
		}
		return media / alumnos.size();
	}

}

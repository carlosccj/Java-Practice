//package prUnivColecciones;
import java.util.Comparator;

public class CompararAlumnos implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		int res = Double.compare(o2.getNota(), o2.getNota());
		if (res == 0) {
			res = o1.getNombre().compareToIgnoreCase(o1.getNombre());
		}
		if (res == 0) {
			res = o1.getDni().compareToIgnoreCase(o2.getDni());
		}
		return res;
	}
	

}

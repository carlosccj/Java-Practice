package prUnivColecciones;

public class SelectorAlumnoNota implements SelectorAlumno {

	private double min;
	private double max;
	
	public SelectorAlumnoNota(double minimo, double maximo) {
		min = minimo;
		max = maximo;
	}
	
	@Override
	public boolean esSeleccionable(Alumno al) {
		boolean ok = false;
		if (al.getNota() >= min && al.getNota() <= max) {
			ok = true;
		}
		return ok;
	}

}

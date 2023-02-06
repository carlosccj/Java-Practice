package prUniv;

public class SelectorAlumnoNota implements SelectorAlumno {
	private double max;
	private double min;
	
	public SelectorAlumnoNota (double minimo, double maximo) {
		max = maximo;
		min = minimo;
	}

	@Override
	public boolean esSeleccionable(Alumno x) {
		boolean ok = false;
		if (max >= x.getNota() && x.getNota() >= min) {
			ok = true;
		}
		return ok;
	}

}

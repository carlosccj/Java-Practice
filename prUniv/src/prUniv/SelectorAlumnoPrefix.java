package prUniv;

public class SelectorAlumnoPrefix implements SelectorAlumno {
	private String prefix;
	
	public SelectorAlumnoPrefix (String pre) {
		prefix = pre;
	}
	
	@Override
	public boolean esSeleccionable(Alumno x) {
		boolean ok = false;
		String[] prefijo = x.getNombre().split("\\s*[ ]\\s*");
		if (prefijo.length > 1 && prefijo[0] == prefix) {
			ok = true;
		}
		return ok;
	}
	
	

}

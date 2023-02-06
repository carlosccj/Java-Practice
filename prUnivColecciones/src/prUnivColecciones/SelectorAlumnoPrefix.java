package prUnivColecciones;

public class SelectorAlumnoPrefix implements SelectorAlumno {

	private String prefix;
	
	public SelectorAlumnoPrefix(String p) {
		prefix = p.toLowerCase();
	}
	
	@Override
	public boolean esSeleccionable(Alumno al) {
		boolean ok = false;
		int lon = prefix.length();
		try {
			String prefijo = al.getNombre().substring(0, lon).toLowerCase();
			if (lon == prefijo.length() && prefix.equals(prefijo)) {
				ok = true;
			}
		} catch (IndexOutOfBoundsException e) {
			
		}
		return ok;
	}

}

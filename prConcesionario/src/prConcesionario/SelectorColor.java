package prConcesionario;

public class SelectorColor implements SelectorCoche {

	private String color;
	
	public SelectorColor(String c) {
		color = c;
	}
	
	@Override
	public boolean esSeleccionable(Coche c) {
		boolean selec = false;
		String col = "";
		if (c instanceof CocheColor) {
			col = ((CocheColor) c).getColor();
		} else {
			throw new RuntimeException("No es un CocheColor");
		}
		if (color.equalsIgnoreCase(col)) {
			selec = true;
		}
		return selec;
	}

}

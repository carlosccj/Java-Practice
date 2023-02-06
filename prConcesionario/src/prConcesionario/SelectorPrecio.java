package prConcesionario;

public class SelectorPrecio implements SelectorCoche {
	
	private double margenInferior;
	private double margenSuperior;

	public SelectorPrecio(double a, double b) {
		if (!(a < b)) {
			throw new RuntimeException("El rango es incorrecto");
		}
		margenInferior = a;
		margenSuperior = b;
	}
	
	@Override
	public boolean esSeleccionable(Coche c) {
		double p = c.calcPrecioFinal();
		boolean selec = (p >= margenInferior && p <= margenSuperior) ? true : false;
		return selec;
	}
	

}

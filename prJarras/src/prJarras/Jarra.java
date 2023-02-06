package prJarras;

public class Jarra {
	private final int capacidad;
	private int contenido;
	public Jarra (int cap) {
		capacidad = cap;
		contenido = 0;
		if (capacidad <= 0) {
			throw new RuntimeException("capacidad erronea" + cap);
		}
	}
	public int capacidad() {
		int cap = capacidad;
		return cap;
	}
	public int contenido() {
		int cont = contenido;
		return cont;
	}
	public void llena() {
		contenido = capacidad();
	}
	public void vacia() {
		contenido = 0;
	}
	public void llenaDesde(Jarra x) {
		if (this == x) {
			throw new RuntimeException ("Error");
		} else {
		int espacio_disponible = this.capacidad() - this.contenido();
		int agua_disponible = x.contenido();
		if (agua_disponible <= espacio_disponible) {
			contenido = this.contenido() + x.contenido();
			x.vacia();
		} else {
			contenido = this.capacidad();
			x.contenido = x.contenido() - espacio_disponible;
		}
	}
}
		
		@Override 
		public String toString() {
			return "J(" + capacidad() + ", " + contenido() + ")" ;
	}

}

package prProductorConsumidor;

public class Recurso {
	public int valor;
	
	
	
	
	public static void main(String[] args) {
		Recurso r = new Recurso();
		Hebra0 h0 = new Hebra0(r);
		Hebra1 h1 = new Hebra1(r);
		
		h0.start();
		h1.start();

	}

}

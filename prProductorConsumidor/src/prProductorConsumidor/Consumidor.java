package prProductorConsumidor;


public class Consumidor extends Thread {
	private Buffer b;
	private int id;
	
	public Consumidor(Buffer b) {
		this.b = b;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			int dato = b.consumir(id);
			if(dato != i) {
				System.out.println("\t *** ERROR DE SINCRONIZACION ***");
			} else
				System.out.println("\t\t Dato consumido "+ dato);
		}
	}
}

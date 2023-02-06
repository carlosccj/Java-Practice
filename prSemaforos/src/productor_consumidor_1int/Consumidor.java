package productor_consumidor_1int;

public class Consumidor extends Thread {
	private Buffer b;
	private int id;
	public Consumidor(Buffer b, int id) {
		this.b = b;
		this.id = id;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			int dato = b.consumir(id);			
		}
	}
}

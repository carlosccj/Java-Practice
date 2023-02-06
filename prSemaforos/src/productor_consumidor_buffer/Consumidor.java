package productor_consumidor_buffer;

public class Consumidor extends Thread {
	private Buffer myBuffer;
	private int iter;
	public Consumidor(Buffer b, int it) {
		myBuffer= b;
		iter = it;
	}
	
	public void run() {
		int dato;
		for(int i =0; i < iter; i++ ){
			dato = myBuffer.consumir();
			System.out.println("Dato consumido "+ dato);
		}
	}
}

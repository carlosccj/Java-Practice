package productor_consumidor_1int;

import java.util.Random;

public class Productor extends Thread {
	private Buffer b;
	Random r;
	public Productor(Buffer b) {
		this.b =b;
		r = new Random();
	}
	public void run() {
		for(int i = 0; i < 100; i++) {
			int dato = r.nextInt(50);
			//System.out.println("Produce dato "+i);
			b.producir(i);
		}
	}
	
}

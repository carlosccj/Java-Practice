package productor_consumidor_buffer;

public class Productor extends Thread{
	private Buffer myBuffer;
	private int iter;
	public Productor(Buffer b, int it){
		myBuffer= b;
		iter = it;
	}
	
	public void run() {		
		for(int i = 0; i < iter; i++) {
			
			myBuffer.producir(i);
		}
	}
}

package productor_consumidor_buffer;

public class Buffer {
	private int elem[];
	private int p,c,nelem; //numero de datos por consumir
	//Semaforos para sincronizacion y exclusion mutua
	
	public Buffer(int n) {
		elem = new int[n];
		p = 0; c = 0; nelem = 0;
		// Incializar los semaforos
	}
	
	public void producir(int dato) {
		//pre-protocolo - sincronizacion y exclusion mutua
		//TODO
		
		//SC
		elem[p]=dato;
		p = (p+1)%elem.length;	
		nelem++;
		
		//post-protocolo
		//TODO
		
	}
	
	
	public int consumir() {
		int d;
		//pre-protocolo + sincronizacion 
		//TODO
		
		//SC
		d = elem[c];
		c = (c+1)%elem.length;		
		nelem--;
		//post-protocolo
		//TODO
		return d; 
	}
	public static void main(String[] args) {
		Buffer myBuffer = new Buffer(5);
		Productor prod= new Productor(myBuffer, 30);
		Consumidor cons = new Consumidor(myBuffer, 30);
		
		prod.start();
		cons.start();

	}

}

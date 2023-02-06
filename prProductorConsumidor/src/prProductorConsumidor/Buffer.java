package prProductorConsumidor;

public class Buffer {
	private int var;
	boolean hayDato;
	
	public Buffer() {
		var = 0;
		hayDato = false;
	}
	
	public void producir(int nuevoDato) {
		//pre
		while(hayDato) {
			System.out.println("Intentando producir");
			Thread.yield();
		}
		//sc
		var = nuevoDato;
		
		//pos
		hayDato = true;
	}
	
	public int consumir(int id) {
		int temp;
		//pre
		while(!hayDato)
			Thread.yield();
		temp = var;
		hayDato = false;
		return temp;
	}
	
	public static void main(String[] args) {
		Buffer b = new Buffer();
		Productor p = new Productor(b);
		Consumidor c = new Consumidor(b);
		// agregar nuevo consumidor
		Consumidor d = new Consumidor(b);
		
		p.start();
		c.start();
		d.start();

	}

}

package productor_consumidor_1int;

public class Buffer {
	private int var;
	//Aniadir atributos
	
	public Buffer() {
		var = 0;
		//inializar nuevos atributos
	}
	
	public void producir(int nuevoDato) {
		//pre
		   //TODO
		//sc
		var = nuevoDato;
		
		//pos
		  //TODO
	}
	
	public int consumir(int id) {
		int temp;
		//pre
		    //TODO
		//sc
		temp = var;
		System.out.println("\t\t "+id+"  Dato consumido "+ temp);
		//pos
		  //TODO
		return temp;
	}
	
	public static void main(String[] args) {
		Buffer b = new Buffer();
		Productor p = new Productor(b);
		Consumidor c0 = new Consumidor(b,0);		
		
		p.start();
		c0.start();
	}

}

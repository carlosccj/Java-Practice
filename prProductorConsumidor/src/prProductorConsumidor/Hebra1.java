package prProductorConsumidor;

public class Hebra1 extends Thread {
	private Recurso rec;
	
	public Hebra1(Recurso rec) {
		this.rec = rec;
	}
	
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			
			//Inicio seccion critica
			rec.valor--;
			System.out.println("Hebra1 nuevo valor");
			//Fin seccion critica
		
		}
		
		
	}
}

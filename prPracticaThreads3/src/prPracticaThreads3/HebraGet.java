package prPracticaThreads3;

public class HebraGet extends Thread {

	private VariableCompartida var;
	
	public HebraGet(VariableCompartida var) {
		this.var = var;
	}
	
	public void run() {
		for(int i = 0; i < 99; i++) {
			System.out.println("Valor leido: " + this.var.getV() + " Iteracion: " + i);
			//Thread.yield();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

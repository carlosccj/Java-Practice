package prPracticaThreads3;

public class HebraSet extends Thread {
	
	private VariableCompartida var;
	
	public HebraSet(VariableCompartida var) {
		this.var = var;
	}
	
	public void run() {
		for(int i = 0; i < 99; i++) {
			this.var.setV(i);
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

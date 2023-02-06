package prPracticaThreads;

public class Hebra extends Thread {
	
	private VariableCompartida var;
	
	public Hebra(VariableCompartida var) {
		this.var = var;
	}
	
	public void run() {
		for(int i = 0; i < 10000; i++) { // Comportamiento extraño a medida que subimos las iteraciones de i
			this.var.inc(1);
		}
	}
}

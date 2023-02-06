import prPracticaThreads3.*;

public class Main {
	public static void main(String[] args) {
		
		VariableCompartida var = new VariableCompartida(0);
		HebraSet hg = new HebraSet(var);
		HebraGet hm = new HebraGet(var);
		
		hg.start();
		hm.start();
		
	}
}

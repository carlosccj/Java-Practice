import prPracticaThreads.*;

public class Main {
	public static void main(String[] args) {

		VariableCompartida var = new VariableCompartida(0);
		Hebra h1 = new Hebra(var);
		Hebra h2 = new Hebra(var);

		h1.start();
		h2.start();

		try {
			h1.join();
			h2.join();
			System.out.println("Valor final: " + var.getV());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

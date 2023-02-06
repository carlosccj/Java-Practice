package prGeneradora;
import java.util.LinkedList;
import java.util.List;

public class Principal {

	public static void Main(String[] args) {
		List<Integer> l = new LinkedList<Integer>();
		Generadora g = new Generadora(l);
		g.start();

		/*
		try {
			Thread.sleep(100);
			g.join();
		} catch(InterruptedException e) {
			
		}
		*/
		
		while(g.isAlive()) {
			System.out.println("Main esperando activamente");
			Thread.sleep(10);
		} catch(InterruptedException e) {
			
		}
		
		System.out.println("La lista es: " + l);
		int length = l.size();
		int suma = 0;
		for (int i = 0; i < length; i++) {
			suma += l.get(i);
		}
		System.out.println("Total suma: " + suma);
	}

}

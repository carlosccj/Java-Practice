package prGeneradora;

import java.util.List;
import java.util.Random;

public class Generadora extends Thread {
	private List<Integer> lista;
	private Random r;
	
	public Generadora(List<Integer> lista) {
		this.lista = lista;
		r = new Random();
	}
	
	public void run() {
		int x = 1 + r.nextInt(10);
		try {
			for (int i = 0; i < x; i++) {
				lista.add(r.nextInt(20));
			}
		} finally {
			
		}
	}
}

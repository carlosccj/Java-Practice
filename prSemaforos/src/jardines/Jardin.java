package jardines;

import java.util.concurrent.Semaphore;

public class Jardin {
	
	private int visitantes;
	private Semaphore mutex;
	public Jardin() {
		visitantes = 0;
		mutex = new Semaphore(1, true); // si no tiene boolean entonces sera injusto por defecto
	}

	public int  getVisitantes() {
		return visitantes;
	}
	
	public void nuevoVisitante(int idP) {
		//pre-protocolo
		try {
		mutex.acquire();
		
		//SC
		System.out.println("Nuevo visitante por puerta "+idP);
		visitantes++;
		System.out.println("Total visitantes "+visitantes);
		
		//pos-protocolo
		mutex.release();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//MAIN
	
	public static void main(String[] args) {
		Jardin jardin = new Jardin();
		Puerta p1 = new Puerta(1,jardin);
		Puerta p2 = new Puerta(2,jardin);
		Puerta p3 = new Puerta(3, jardin);
		p1.start();
		p2.start();
		p3.start();
		
		try {
			p1.join();
			p2.join();
			p3.join();
			System.out.println("Total visitantes: "+jardin.getVisitantes());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

}

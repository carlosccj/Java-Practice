package prAhorcado;
import java.util.Timer;
import java.util.TimerTask;

public class Reloj extends Timer { // llama a reloj
	
	private Timer timer;
	private boolean timeout;
	private int tiempoSobrante;
	
	// Este constructor crea un timer con unos segundos y que muestra el tiempo en minutos y segundos. Cuando el contador
	// llega a 0 cancela el timer y pone el flag de timeout a true, para indicar que la partida ha finalizado.
	// En cada iteración se actualiza el tiempo sobrante en ese momento.
	public Reloj (int segundos) {
		this.timer = new Timer();
		this.timeout = false;
		this.tiempoSobrante = 0;
		
		timer.scheduleAtFixedRate(new TimerTask() {
			int i = segundos;
			int min;
			int sec;

			public void run() {
				min = i / 60;
				sec = i % 60;

				System.out.printf("Tiempo restante: %d:%02d\n", min , sec);
				--i;
				tiempoSobrante =- i;

				if (i < 0) {
					System.out.println("Tiempo agotado.\n");
					this.cancel();
					timeout = true;
				}
			}
		}, 0, 1000);
	}

	public boolean getTimeout() {
		return this.timeout;
	}
	
	public int getTiempoSobrante() {
		return (this.getTimeout() == true) ? this.tiempoSobrante : -1;
	}
}
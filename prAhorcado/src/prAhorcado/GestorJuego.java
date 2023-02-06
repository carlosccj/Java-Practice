package prAhorcado;

public class GestorJuego {
	private Jugador jugador1;
	private Jugador jugador2;
	private int dificultad;
	
	public GestorJuego(Jugador jugador1, Jugador jugador2, Juego juego, int dificultad) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.dificultad = dificultad;
	}
	
	public void empezarJuego() throws Exception {
		Juego juego = new Juego(setNumeroLetrasPalabra(this.dificultad), setNumeroIntentos(this.dificultad), 
				this.jugador1, null, setSegundos(dificultad));
	}
	
	public void empezarJuegoEstandar() throws Exception {
		Juego juego = new Juego(this.jugador1, null);
	}
	
	public int empezarJuegoMultijugador() throws Exception {
		Juego juegoJugador1 = new Juego(setNumeroLetrasPalabra(this.dificultad), setNumeroIntentos(this.dificultad), 
				this.jugador1, null, setSegundos(dificultad));
		Juego juegoJugador2 = new Juego(setNumeroLetrasPalabra(this.dificultad), setNumeroIntentos(this.dificultad), 
				this.jugador2, null, setSegundos(dificultad));
		while(!juegoJugador1.getTerminado() && !juegoJugador2.getTerminado()) {
			continue;
		}
		return getGanador(juegoJugador1, juegoJugador2);
		
	}
	
	public int getGanador(Juego juegoJugador1, Juego juegoJugador2) {
		int ganador = 0;
		if (juegoJugador1.getResuelto() && !juegoJugador2.getResuelto()) {
			ganador = 1;
		} else if (!juegoJugador1.getResuelto() && juegoJugador2.getResuelto()) {
			ganador = 2;
		} else if (juegoJugador1.getNumeroIntentos() > juegoJugador2.getNumeroIntentos()) {
			ganador = 1;
		} else if (juegoJugador1.getNumeroIntentos() < juegoJugador2.getNumeroIntentos()) {
			ganador = 2;
		} else if (juegoJugador1.getSegundos() > juegoJugador2.getSegundos()) {
			ganador = 1;
		} else if (juegoJugador1.getSegundos() < juegoJugador2.getSegundos()) {
			ganador = 2;
		} else {
			ganador = 3; //empate
		}
		return ganador;
	}
	
	public int setNumeroLetrasPalabra(int dificultad) {
		int numeroLetrasPalabra = 0;
		switch(dificultad) {
		case 0 : numeroLetrasPalabra = 4;
		break;
		case 1 : numeroLetrasPalabra = (int)Math.floor((Math.random() * 6 - 4 + 1) + 4);
		break;
		case 2 : numeroLetrasPalabra = (int)Math.floor((Math.random() * 10 - 6 + 1) + 6);
		break;
		case 3 : numeroLetrasPalabra = (int)Math.floor((Math.random() * 16 - 10 + 1) + 10);
		break;
		case 4 : numeroLetrasPalabra = (int)Math.floor((Math.random() * 23 - 16 + 1) + 16);
		break;
		}
		return numeroLetrasPalabra;
	}
	
	public int setNumeroIntentos(int dificultad) {
		int numeroIntentos = 0;
		switch(dificultad) {
		case 0 : numeroIntentos = 20;
		break;
		case 1 : numeroIntentos = 15;
		break;
		case 2 : numeroIntentos = 10;
		break;
		case 3 : numeroIntentos = 8;
		break;
		case 4 : numeroIntentos = 5;
		break;
		}
		return numeroIntentos;
	}
	
	public int setSegundos(int dificultad) {
		int segundos = 0;
		switch(dificultad) {
		case 0 : segundos = 120;
		break;
		case 1 : segundos = 90;
		break;
		case 2 : segundos = 60;
		break;
		case 3 : segundos = 45;
		break;
		case 4 : segundos = 30;
		break;
		}
		return segundos;
	}
}

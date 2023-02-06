package prJuegoCartas;

public class Carta {
	private int valor;
	private int valorJuego;
	private enum Palo {
		OROS,
		COPAS,
		ESPADAS,
		BASTOS,
	}
	
	public Carta (int valor, int palo) {
		this(valor, 0, palo);
	}
	
	public Carta (int valor, int valorJuego, int palo) {
		this.valor = valor;
		this.valorJuego = valorJuego;
		;
	}
}

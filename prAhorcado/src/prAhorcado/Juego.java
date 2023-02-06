package prAhorcado;
import java.util.Scanner;

public class Juego {
	
	private int numeroIntentos;
	private static final int maxIntentos = 20;
	private Palabra palabra;
	private String solucion;
	private Jugador jugador1;
	private Jugador jugador2;
	private Reloj timer; 
	private int segundos;
	private boolean resuelto;
	private boolean terminado;
	
	/* Hay una clase timer que forma parte de Juego pero no está implementada en el UML (¿pasarle los segundos desde aqui?)
	 * Hay que definir bien qué es la dificultad del JUEGO y qué es la dificultad de la PALABRA
	 * Falta funcion que compare la letra suministrada por el jugador y devuelva T o F (y el lugar tambien?)
	 */
	
	//Este constructor crea un juego "estándar" para un solo jugador con unos valores predefinidos (tamaño palabra [4, 6])
	public Juego(Jugador jugador1) throws Exception {
		this((int)Math.floor((Math.random() * 6 - 4 + 1) + 4), 8, jugador1, null, 120);
	}
	
	//Este constructor crea un juego "estándar" para dos jugadores con unos valores predefinidos (tamaño palabra [4, 6])
	public Juego(Jugador jugador1, Jugador jugador2) throws Exception {
		this((int)Math.floor((Math.random() * 6 - 4 + 1) + 4), 8, jugador1, jugador2, 120);
	}
	
	//Este constructor crea un juego "personalizado" para uno o dos jugadores con unos valores concretos
	public Juego(int numeroLetrasPalabra, int numeroIntentos, Jugador jugador1, Jugador jugador2, int segundos) throws Exception {
		if(numeroIntentos < 1 || numeroIntentos > maxIntentos) {
			throw new Exception("Los parámetros de creación de juego son erróneos\n");
		}
		this.numeroIntentos = numeroIntentos;
		this.palabra = new Palabra(numeroLetrasPalabra);
		this.solucion = palabra.getPalabra();
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.timer = new Reloj(segundos);
		this.resuelto = false;
		this.terminado = false;
	}
	
	public int getNumeroIntentos() {
		return this.numeroIntentos;
	}
	
	public void setNumeroIntentos(int numeroIntentos) {
		this.numeroIntentos = numeroIntentos;
	}
	
	public String getSolucion() {
		return this.solucion;
	}
	
	public void setPalabra(String solucion) {
		this.palabra.setPalabra(solucion);
	}
	
	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}
	
	public Jugador getJugador1() {
		return this.jugador1;
	}
	
	public Jugador getJugador2() {
		return this.jugador2;
	}
	
	public Reloj getTimer() {
		return this.timer;
	}
	
	public void setTimer(int segundos) {
		this.timer = new Reloj(segundos);
	}
	
	public int getSegundos() {
		return this.segundos;
	}
	
	public boolean getResuelto() {
		return this.resuelto;
	}
	
	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}
	
	public boolean getTerminado() {
		return terminado;
	}
	
	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
	
	/*
	 * Metodos para el juego:
	 * getLetra pide y registra letra al jugador,
	 * comprobarLetra comprueba que la letra esta en la palabra solucion y que aun no se ha puesto
	 * colocarLetra pone en su lugar en el array listaPalabra la letra comprobada.
	 */
	
	public char getLetra() {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Introduce una letra: "); // estos prints se sustituiran por la GUI que se esta preparando
	    char letra = sc.next().charAt(0);  //se obtiene solo el primer caracter del String introducido por teclado
	    System.out.println("Caracter introducido -> " + letra);
	    sc.close();
	    return letra;
	}
	
	// Este metodo recibe una letra y devuelve true si estaba en el String solucion, false en otro caso.
	// Contiene un bucle que va recorriendo el String solucion. Por cada aparicion de la letra, cambia el char
	// en esa posicion del String solucion a '_' y pasa a la siguiente. De esta manera, las letras que ya han
	// sido introducidas daran fallo. El String solucion una vez completado sera algo asi "_ _ _ _ _ _"
	public boolean comprobarLetra(char letra) {
		boolean presente = false;
		StringBuilder sb = new StringBuilder(this.getSolucion());
		for (int i = 0; i < this.getSolucion().length(); i++) {
			if (Character.toUpperCase(sb.charAt(i)) == letra) {
				sb.setCharAt(i, '_');
				presente = true;
			}
		}
		this.setSolucion(sb.toString());
		return presente;
	}
	
	
	// Se inicializan los aciertos y los fallos a 0 y luego entra en un bucle que no para mientras no se haya resuelto,
	// no se haya agotado el numero de intentos o aun quede tiempo en el timer. Si la letra no estaba en la palabra, 
	// aumenta la variable fallos. En otro caso, aumenta la variable aciertos y luego se comprueba si se ha llegado a 
	// una solucion. Si el jugador ha llegado a una solucion, sus partidas ganadas se incrementan y si no, se incrementan 
	// sus partidas perdidas. En cualquier caso el juego termina.
	public void jugarIndividual() {
		int aciertos = 0;
		while (!this.getResuelto() && this.getNumeroIntentos() > 0 && this.timer.getTimeout() == false) {
			char letra = Character.toUpperCase(getLetra());
			if (!comprobarLetra(letra)) {
				this.setNumeroIntentos(this.getNumeroIntentos() - 1);
			} else {
				aciertos += this.getSolucion().length() - this.getSolucion().replace("_", "").length();
				if (aciertos == this.getSolucion().length()) {
					this.setResuelto(true);
				}
			}
		}
		if (this.getResuelto()) {
			this.jugador1.ganarPartida();
		} else {
			this.jugador1.perderPartida();
		}
		this.setTerminado(true);
	}
}

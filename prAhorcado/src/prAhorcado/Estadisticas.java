package prAhorcado;

public class Estadisticas {
	
	private int partidasGanadas;
	private int partidasPerdidas;
	
	/*
	 * Quizás tendría sentido aqui calcular un ELO en base a (partidasGanadas, partidasPerdidas, dificultadUltimaPalabraResuelta)
	 */
	
	//Este constructor crea unas estadísticas vacías para un jugador nuevo
	public Estadisticas() throws Exception {
		this(0, 0);
	}
	
	//Este constructor instancia unas estadísticas con unos valores concretos para un jugador viejo
	public Estadisticas(int partidasGanadas, int partidasPerdidas) throws Exception {
		if(partidasGanadas < 0 || partidasPerdidas < 0) {
			throw new Exception("Los parametros son incorrectos\n");
		}
		this.partidasGanadas = partidasGanadas;
		this.partidasPerdidas = partidasPerdidas;
	}
	
	public int getPartidasGanadas() {
		return this.partidasGanadas;
	}
	
	public void setPartidasGanadas(int n) {
		this.partidasGanadas += n;
	}
	
	public void incPartidasGanadas() {
		this.setPartidasGanadas(1);
	}
	
	public int getPartidasPerdidas() {
		return this.partidasPerdidas;
	}
	
	public void setPartidasPerdidas(int n) {
		this.partidasPerdidas += n;
	}
	
	public void incPartidasPerdidas() {
		this.setPartidasPerdidas(1);
	}

}

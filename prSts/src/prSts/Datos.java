package prSts;
import java.util.*;

public class Datos {
	private double[] vector;
	
	public Datos(int n) {
		if (n <= 0) {
			throw new RuntimeException("Tamaño incorrecto maricón");
		}
		vector = new double[n];
	}
	
	public void generarEnteros(int min, int max) {
		Random rnd = new Random();
		for (int i = 0; i < vector.length; i++) {
			vector[i] = rnd.nextInt(min + 1) + (max - min);
		}
	}
	
	public void generarReales(double min, double max) {
		Random rnd = new Random();
		for (int i = 0; i < vector.length; i++) {
			vector[i] = min + (max - min) * rnd.nextDouble();
		}
	}
	
	public double calcMedia() {
		double sum = 0;
		for (int i = 0; i < vector.length; i++) {
			sum += vector[i];
		}
		return sum / vector.length;
	}
	
	public double calcDesvTipica() {
		double media = this.calcMedia();
		double sum = 0;
		for (int i = 0; i < vector.length; i++) {
			sum += Math.pow(vector[i] - media, 2);
		}
		sum = sum / vector.length;
		return Math.sqrt(sum);
	}
	
	public String toString() {
		StringJoiner sj = new StringJoiner(", ", "[ ", " ]");
		for (int i = 0; i < vector.length; i++) {
			sj.add(String.format(Locale.US, "%.2f", vector[i]));
		}
		return sj.toString();
	}
}

package prDatos;

import java.util.Arrays;

public class Datos {
	private double[] datos;
	private String[] errores;
	private double min;
	private double max;

	public Datos(String[] dat, double mini, double maxi) {
		min = mini;
		max = maxi;
		procesarDatos(dat);
	}

	private void procesarDatos(String[] dat) {
		datos = new double[dat.length];
		errores = new String[dat.length];
		int ndatos = 0;
		int nerrores = 0;
		for (String x : dat) {
			try {
				datos[ndatos] = Double.parseDouble(x);
				ndatos++;
			} catch (NumberFormatException e) {
				errores[nerrores] = x;
				nerrores++;
			}
		}
		datos = Arrays.copyOf(datos, ndatos);
		errores = Arrays.copyOf(errores, nerrores);
	}

	public double calcMedia() {
		int i = 0;
		double sum = 0;
		for (double x : datos) {
			if (x >= min && x <= max) {
				sum += x;
				i++;
			}
		} if (i == 0) {
			throw new DatosException("No hay datos en el rango especificado");
		}
		return sum / i;
	}
	
	public double calcDesvTipica() {
		double media = this.calcMedia();
		int i = 0;
		double sum = 0;
		for (double x : datos) {
			if (x >= min && x <= max) {
				sum += Math.pow((x), 2);
				i++;
			}
		}
		return sum = Math.sqrt((sum / i) - Math.pow(media, 2));
	}
	
	public void setRango(String range) {
		try {
			int idx = range.indexOf(";");
			this.min = Double.parseDouble(range.substring(0, idx));
			this.max = Double.parseDouble(range.substring(idx + 1));
		} catch (StringIndexOutOfBoundsException | NumberFormatException e) {
			throw new DatosException("Error en los datos al establecer el rango");
		}
	}
	
	public double[] getDatos() {
		return datos;
	}
	
	public String[] getErrores() {
		return errores;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "Min: " + this.min + ", Max: " + this.max + ", \n";
		str += "[" + datos[0];
		for (int i = 1; i < datos.length; i++) {
			str += ", " + datos[i];
		}
		str += "], \n [" + errores[0];
		for (int j = 1; j < errores.length; j++) {
			str += ", " + errores[j];
		}
		try {
		str += "], \n Media: " + this.calcMedia() + ", DesvTipica: " + this.calcDesvTipica();
		} catch (DatosException e) {
			str += "], \n Media: " + "ERROR" + ", DesvTipica: " + "ERROR";
		}
		return str;
	}
}

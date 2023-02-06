import java.util.Arrays;

import prDatos.*;

public class PruebaDatos {
	public static void main(String[] args) {
		try {
			double min = Double.parseDouble(args[0]);
			double max = Double.parseDouble(args[1]);
			String[] dat = Arrays.copyOfRange(args, 2, args.length);
			Datos datos = new Datos(dat, min, max);
			System.out.println(datos);
			String range = "0;4";
			datos.setRango(range);
			System.out.println(datos);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error, no hay valores suficientes");
		} catch (NumberFormatException a) {
			System.out.println("Error al convertir un valor a numero real " + "(" + a.getMessage() + ")");
		}
	}

}

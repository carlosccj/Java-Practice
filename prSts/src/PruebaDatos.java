import prSts.*;

public class PruebaDatos {
	public static void main(String[] args) {
		Datos d1 = new Datos(20);
		System.out.println("--------------");
		d1.generarEnteros(10, 30);
		System.out.println(d1.toString());
		System.out.println(d1.calcMedia() + " " + d1.calcDesvTipica());
		System.out.println("--------------");
		d1.generarReales(10, 30);
		System.out.println(d1.toString());
		System.out.println(d1.calcMedia() + " " + d1.calcDesvTipica());
		System.out.println("--------------");
	}
}

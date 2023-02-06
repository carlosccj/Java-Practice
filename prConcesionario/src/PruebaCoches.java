import prConcesionario.*;

public class PruebaCoches {
	public static void main (String[] args) {
		Coche coche1 = new Coche("seat", 10000);
		Coche coche2 = new Coche("renault", 12000);
		Coche coche3 = new Coche("peugeot", 13000);
		//----------------------------
		System.out.println("Impuesto: " + Coche.getIva() + "%");
		System.out.println("Coche-1: " + coche1.toString());
		System.out.println("Coche-2: " + coche2.toString());
		System.out.println("Coche-3: " + coche3.toString());
		//----------------------------
		Coche.setIva(20); // método de clase (estático)
		coche1.setPrecioBase(15000); // método de instancia
		//----------------------------
		System.out.println("Impuesto: " + Coche.getIva() + "%");
		System.out.println("Coche-1: " + coche1.toString());
		System.out.println("Coche-2: " + coche2.toString());
		System.out.println("Coche-3: " + coche3.toString());
	}

}

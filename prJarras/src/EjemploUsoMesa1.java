import prJarras.Mesa;

public class EjemploUsoMesa1 {
public static void main(String[] args) {
	Mesa mesapr = new Mesa(7, 5);
	mesapr.llena(2);
	System.out.println(mesapr);
	mesapr.llenaDesde(2);
	System.out.println(mesapr);
	mesapr.llena(2);
	System.out.println(mesapr);
	mesapr.llenaDesde(2);
	System.out.println(mesapr);
	mesapr.vacia(1);
	System.out.println(mesapr);
	mesapr.llenaDesde(2);
	System.out.println(mesapr);
	mesapr.llena(2);
	System.out.println(mesapr);
	mesapr.llenaDesde(2);
	System.out.println(mesapr);
}
}

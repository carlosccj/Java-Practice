import prVotacion.*;

public class PruebaUrnaExc {
	public static void main (String[] args) {
		UrnaExc a = new UrnaExc();
		System.out.println(a.estaAbierta());
		boolean vot = true;
		try {
		a.votar(vot);
		a.votar(vot);
		a.votar(vot);
		a.votar(!vot);
		a.resultado();
		a.cerrarVotacion();
		System.out.println(a.toString());
		} catch (UrnaException e) {
			a.cerrarVotacion();
			System.out.println(a.toString());
		}
	}
}

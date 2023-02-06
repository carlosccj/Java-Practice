import geometria.Segmento;
import geometria.Punto;
public class PruebaSegmento {
	public static void main (String[] args) {
		Segmento sgt = new Segmento (2, 1, 3, 3);
		double lg = sgt.longitud();
		System.out.println(sgt);
		System.out.println(lg);
	}

}

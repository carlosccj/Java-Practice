
import prOperacionesConColecciones.OperacionesConColecciones;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class PruebaOperacionesConColecciones {
	public static void prueba_1() {
		final Integer[] DATOS = { 3, 2, 7, 3, 4, 8, 7 };
		List<Integer> lista = new ArrayList<Integer>(Arrays.asList(DATOS));
		System.out.println("intercambiarPares");
		System.out.println(" " + lista);
		OperacionesConColecciones.intercambiarPares(lista);
		System.out.println(" " + lista);
	}

	public static void prueba_2() {
		final String[] DATOS = { "hola", "hello", "adios", "bye" };
		Set<String> set = new HashSet<String>(Arrays.asList(DATOS));
		System.out.println("mediaVocales");
		System.out.println(" " + set);
		System.out.println(" Media: " + OperacionesConColecciones.mediaVocales(set));
	}

	public static void prueba_3() {
		final String[] DATOS = { "esto", "es", "esto", "un", "ejemplo", "ejemplo", "un" };
		List<String> lista = new ArrayList<String>(Arrays.asList(DATOS));
		System.out.println("eliminarDuplicados");
		System.out.println(" " + lista);
		OperacionesConColecciones.eliminarDuplicados(lista);
		System.out.println(" " + lista);
	}

	public static void prueba_4() {
		final String[] DATOS = { "hola", "hello", "adios", "bye" };
		Set<String> set = new HashSet<String>(Arrays.asList(DATOS));
		System.out.println("eliminarLongitudPar");
		System.out.println(" " + set);
		OperacionesConColecciones.eliminarLongitudPar(set);
		System.out.println(" " + set);
	}

	public static void prueba_5() {
		final String[] DATOS = { "esto", "es", "un", "ejemplo", "como", "otro", "mas" };
		List<String> lista = new ArrayList<String>(Arrays.asList(DATOS));
		System.out.println("marcarLong4");
		System.out.println(" " + lista);
		OperacionesConColecciones.marcarLong4(lista);
		System.out.println(" " + lista);
	}

	public static void prueba_6() {
		final Integer[][] DATOS = { { 3, 8, 2 }, { 8, 7, 3 }, { 4, 2, 3 } };
		List<Set<Integer>> lista = new ArrayList<Set<Integer>>();
		for (int i = 0; i < DATOS.length; ++i) {
			lista.add(new HashSet<Integer>(Arrays.asList(DATOS[i])));
		}
		System.out.println("superInterseccion");
		System.out.println(" " + lista);
		Set<Integer> set = OperacionesConColecciones.superInterseccion(lista);
		System.out.println(" " + set);
	}

	public static void prueba_7() {
		final Integer[][] DATOS = { { 4, 8, 2 }, { 8, 6, 3 }, {}, { 1, 2, 8 } };
		List<Set<Integer>> lista = new ArrayList<Set<Integer>>();
		for (int i = 0; i < DATOS.length; ++i) {
			lista.add(new HashSet<Integer>(Arrays.asList(DATOS[i])));
		}
		System.out.println("eliminarConjDePares");
		System.out.println(" " + lista);
		OperacionesConColecciones.eliminarConjDePares(lista);
		System.out.println(" " + lista);
	}

	public static void prueba_8() {
		final String[] NOMBRES = { "Roberto", "Antonio", "Pepe", "Juan", "Luis" };
		final double[] ALTURAS = { 1.75, 1.85, 1.78, 1.63, 1.93 };
		Map<String, Double> map = new HashMap<String, Double>();
		for (int i = 0; i < NOMBRES.length; ++i) {
			map.put(NOMBRES[i], ALTURAS[i]);
		}
		System.out.println("mediaAltura");
		System.out.println(" " + map);
		System.out.println(" Media: " + OperacionesConColecciones.mediaAltura(map));
	}

	public static void prueba_9() {
		final String[] PRODUCTOS = { "arroz", "agua", "vino", "sal", "pan" };
		final int[] CANTIDADES = { 1, 6, 1, 1, 2 };
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < PRODUCTOS.length; ++i) {
			map.put(PRODUCTOS[i], CANTIDADES[i]);
		}
		System.out.println("anyadirPedido");
		System.out.println(" " + map);
		OperacionesConColecciones.anyadirPedido(map, "azafran", 1);
		OperacionesConColecciones.anyadirPedido(map, "vino", 1);
		System.out.println(" " + map);
	}

	public static void main(String[] args) {
		prueba_1();
		prueba_2();
		prueba_3();
		prueba_4();
		prueba_5();
		prueba_6();
		prueba_7();
		prueba_8();
		prueba_9();
	}
}
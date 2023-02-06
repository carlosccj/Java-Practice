package prGasolinera;

import java.util.*;
import java.io.*;

public class Gasolinera {
	protected String nombre;
	protected int contador;
	private Map<String, List<Double>> surtidores;
	private Map<String, SortedSet<Ticket>> repostajes;
	private TicketOrdenAlternativo alternativo;
	public static final String GASOLINA95 = "gasolina95";
	public static final String GASOLINA98 = "gasolina98";
	public static final String DIESEL = "diesel";
	public static final String DIESELPLUS = "dieselPlus";
	private final Map<String, Double> precios;
	private static final int NUM_SURT = 4;

	public Gasolinera(String nom, Map<String, Double> prec, String nomFich) throws FileNotFoundException {
		this(nom, prec, nomFich, null);
	}

	public Gasolinera(String nom, Map<String, Double> prec, String nomFich, TicketOrdenAlternativo alt)
			throws FileNotFoundException {
		nombre = nom;
		precios = prec;
		contador = 1;
		repostajes = new TreeMap<String, SortedSet<Ticket>>();
		surtidores = new TreeMap<String, List<Double>>();
		surtidores.put(GASOLINA95, crearListaSurtidores());
		surtidores.put(GASOLINA98, crearListaSurtidores());
		surtidores.put(DIESEL, crearListaSurtidores());
		surtidores.put(DIESELPLUS, crearListaSurtidores());
		leertxt(nomFich);
	}

	private List<Double> crearListaSurtidores() {
		List<Double> surt = new ArrayList<Double>();
		for (int i = 0; i < NUM_SURT; i++) {
			surt.add(0.0);
		}
		return surt;
	}

	private void leertxt(String nomFich) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(nomFich))) {
			while (sc.hasNextLine()) {
				leerLinea(sc.nextLine());
			}
		}
	}

	private void leerLinea(String linea) {
		try (Scanner sc = new Scanner(linea)) {
			sc.useLocale(Locale.ENGLISH);
			sc.useDelimiter("\\s*[ ]\\s*");
			int posicion = Integer.parseInt(sc.next());
			String nom = sc.next();
			double lits = Double.parseDouble(sc.next());
			if ((posicion <= 4 && posicion >= 1)
					&& (nom.equals("gasolina95") || nom.equals("gasolina98") || nom.equals("diesel") || nom.contentEquals("dieselPlus"))) {
				List<Double> surt = surtidores.get(nom);
				double litsAnterior = surt.get(posicion - 1);
				lits += litsAnterior;
				surt.set(posicion - 1, lits);
				surtidores.remove(nom);
				surtidores.put(nom, surt);
			}
		} catch (NumberFormatException e) {

		} catch (InputMismatchException e) {

		} catch (NoSuchElementException e) {

		}
	}

	public void repostar(String matr, String tipoComb, int tipoSurt, double cant) throws GasolineraException {
		if (tipoComb.contentEquals("gasolina95") || tipoComb.contentEquals("gasolina98") || tipoComb.contentEquals("diesel") 
				|| tipoComb.contentEquals("dieselPlus") && (tipoSurt >= 1 && tipoSurt <= 4) && cant > 0) {
			List<Double> listaCantidades = surtidores.get(tipoComb);
			double disp = listaCantidades.get(tipoSurt - 1);
			if (disp > 0) {
				disp -= cant;
				disp = (disp < 0) ? 0 : disp;
				listaCantidades.set(tipoSurt - 1, disp);
				Ticket generado = crearTicket(matr, cant, precios.get(tipoComb));
				almacenarTicket(generado, matr);
			}
		} else {
			throw new GasolineraException("ERROR: Incorrect data");
		}

	}

	protected Ticket crearTicket(String matr, double cant, double prec) throws GasolineraException {
		Ticket generado = new Ticket(nombre, contador, matr, cant, prec);
		contador++;
		return generado;

	}

	private void almacenarTicket(Ticket generado, String matr) throws GasolineraException {
		if (repostajes.containsKey(matr)) {
			SortedSet<Ticket> listaTickets = repostajes.get(matr);
			if (listaTickets.contains(generado)) {
				throw new GasolineraException("ERROR: This ticket already exists in this set");
			} else {
				listaTickets.add(generado);
				repostajes.remove(matr);
				repostajes.put(matr, listaTickets);
			}
		} else {
			SortedSet<Ticket> listaTickets = new TreeSet<Ticket>();
			listaTickets.add(generado);
			repostajes.put(matr, listaTickets);
		}
	}

	public void facturar(String matr) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(this.nombre + "_" + matr + ".txt")) {
			int cnt = 1;
			double total = 0;
			SortedSet<Ticket> listaTickets = repostajes.get(matr);
			Iterator<Ticket> it = listaTickets.iterator();
			while (it.hasNext()) {
				Ticket x = it.next();
				if (!x.getFacturado()) {
					pw.println("Ticket: " + cnt + " " + x.toString() + "\n");
					total += x.precioTotal();
					x.setFacturado(true);
					cnt++;
				}
			}
			pw.println("TOTAL = " + total);
		}
	}

	public double obtenerConsumoFacturado(String matr) {
		double total = 0;
		SortedSet<Ticket> listaFacturados = repostajes.get(matr);
		Iterator<Ticket> it = listaFacturados.iterator();
		while (it.hasNext()) {
			Ticket x = it.next();
			if (x.getFacturado()) {
				total += x.precioTotal();
			}
		}
		return total;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<" + this.nombre + "> = \n");
		for (Map.Entry<String, List<Double>> entry : surtidores.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}
		sb.append("Repostajes: ");
		for (Map.Entry<String, SortedSet<Ticket>> entry : repostajes.entrySet()) {
			sb.append(entry.getValue());
		}
		return sb.toString();
	}

}

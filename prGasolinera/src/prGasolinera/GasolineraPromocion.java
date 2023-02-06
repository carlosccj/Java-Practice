package prGasolinera;

import java.io.FileNotFoundException;
import java.util.Map;

public class GasolineraPromocion extends Gasolinera {
	
	private static final double CONSUMO_MINIMO1 = 100;
	private static final double CONSUMO_MINIMO2 = 300;
	private static final double DESCUENTO1 = 0.10;
	private static final double DESCUENTO2 = 0.30;

	public GasolineraPromocion(String nom, Map<String, Double> prec, String nomFich) throws FileNotFoundException {
		super(nom, prec, nomFich, null);
	}
	
	public GasolineraPromocion(String nom, Map<String, Double> prec, String nomFich, TicketOrdenAlternativo alt) throws FileNotFoundException {
		super(nom, prec, nomFich, alt);
	}
	
	@Override
	protected Ticket crearTicket(String matr, double cant, double prec) throws GasolineraException {
		double consumoFacturado = 0;
		Ticket generado = super.crearTicket(matr, cant, prec);
		if (consumoFacturado < CONSUMO_MINIMO1) {
			generado = super.crearTicket(matr, cant, prec);
		} else if (consumoFacturado > CONSUMO_MINIMO1 && consumoFacturado < CONSUMO_MINIMO2) {
			consumoFacturado = consumoFacturado * DESCUENTO1;
			generado = new TicketPromocion(contador, nombre, matr, cant, prec, DESCUENTO1);
			contador++;
		} else if (consumoFacturado > CONSUMO_MINIMO2) {
			consumoFacturado = consumoFacturado * DESCUENTO2;
			generado = new TicketPromocion(contador, nombre, matr, cant, prec, DESCUENTO2);
			contador++;
		}
		return generado;
	}
	
	
	
	

}

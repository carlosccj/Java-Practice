package prGasolinera;

public class TicketPromocion extends Ticket {
	
	private double descuento;

	public TicketPromocion(int num, String nom, String matr, double lit, double prec, double desc) throws GasolineraException {
		super(nom, num, matr, lit, prec);
		descuento = desc;
	}
	
	@Override
	public double precioTotal() {
		return super.precioTotal() - (super.precioTotal() * descuento);
	}
	
	@Override
	public String toString() {
			return "PROMOCION " + this.descuento * 100 + "%: Ticket: " + this.getNumTicket() + " (" + "gasolinera: " 
	+ this.getGasolinera() + ", matricula: " + this.matricula + ", litros: " + this.getNumLitros() + ", PRECIO = " + this.precioTotal() + ")";
		}
	}

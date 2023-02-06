package prGasolinera;
import java.util.*;

public class Ticket implements Comparable<Ticket> {
	
	private int numero;
	private String nombre;
	protected String matricula;
	private double litros;
	private double precioLitro;
	private boolean facturado;
	
	public Ticket(String nom, int num, String matr, double lit, double prec) throws GasolineraException {
		if (prec <= 0 || lit <= 0 || nom == null || nom.length() == 0 || nom == null || nom.length() == 0) {
			throw new GasolineraException("Datos incorrectos para crear el ticket");
		}
		
		numero = num;
		nombre = nom;
		matricula = matr;
		litros = lit;
		precioLitro = prec;
		facturado = false;
	}
	
	public int getNumTicket() {
		return numero;
	}
	
	public double getNumLitros() {
		return litros;
	}
	
	public String getGasolinera() {
		return nombre;
	}
	
	public boolean getFacturado() {
		return facturado;
	}
	
	public void setFacturado(boolean ok) {
		facturado = ok;
	}
	
	public double precioTotal() {
		return precioLitro * litros;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof Ticket) {
			Ticket other = (Ticket) o;
			ok = this.getGasolinera().equalsIgnoreCase(other.getGasolinera()) && this.getNumTicket() == other.getNumTicket();
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return this.getGasolinera().toLowerCase().hashCode() + Integer.hashCode(this.getNumTicket());
	}

	@Override
	public int compareTo(Ticket other) {
		int ok = this.getGasolinera().compareToIgnoreCase(other.getGasolinera());
		if (ok == 0) {
			ok = Integer.compare(this.getNumTicket(), other.getNumTicket());
		}
		return ok;
	}
	
	@Override
	public String toString() {
		return "Ticket: " + this.getNumTicket() + " (" + "gasolinera: " + this.getGasolinera() + ", matricula: " + this.matricula 
				+ ", litros: " + this.getNumLitros() + ", PRECIO = " + this.precioTotal() + ")";
	}

}

package prVotacion;

public class UrnaExc {

	private int vot_pos;
	private int vot_neg;
	private boolean estado;
	
	public UrnaExc() {
		vot_pos = 0;
		vot_neg = 0;
		estado = true;
	}
	
	public boolean estaAbierta() {
		return estado;
	}
	
	public void cerrarVotacion() {
		estado = false;
	}
	
	public void votar (boolean x) throws UrnaException {
		if (!this.estaAbierta()) {
			throw new UrnaException("La urna esta cerrada");
		} else {
			if (x) {
				vot_pos++;
			} else {
				vot_neg++;
			}
		}
	}
	
	public boolean resultado() throws UrnaException {
		boolean res = true;
		if (this.estaAbierta()) {
			throw new UrnaException("La urna esta abierta");
		} else {
			return (vot_pos > vot_neg) ? res : !res;
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		if (this.estaAbierta()) {
			str += "La urna aún está abierta";
		} try {
			str += this.vot_pos + ", " + this.vot_neg +  ", " + Boolean.toString(this.resultado());
		} catch (UrnaException e) {
			this.cerrarVotacion();
			this.toString();
			str = "";
		}
		return "(" + str + ")";
	}
}

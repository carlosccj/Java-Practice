package prJarras;

public class Mesa {
	private Jarra jarra1, jarra2;

	public Mesa (Jarra a, Jarra b) {
		jarra1 = a;
		jarra2 = b;
		if (jarra1 == jarra2) {
			throw new RuntimeException("Ambos objetos son iguales");
		}
	}
	public Mesa (int capJarra_a, int capJarra_b) {
		jarra1 = new Jarra(capJarra_a);
		jarra2 = new Jarra(capJarra_b);
	}
	public int capacidad(int x) {
		if (x != 1 & x != 2) {
			throw new RuntimeException("La jarra especificada no existe");
		}
		int cap = 0;
		if (x == 1) {
			cap = jarra1.capacidad();
		} else if (x == 2) {
			cap = jarra2.capacidad();
		}
		return cap;
	}
	public int contenido(int x) {
		if (x != 1 & x != 2) {
			throw new RuntimeException("La jarra especificada no existe");
		}
		int cont = 0;
		if (x == 1) {
			cont = jarra1.contenido();
		} else if (x == 2) {
			cont = jarra2.contenido();
		}
		return cont;
	}
	public void llena (int x) {
		if (x != 1 & x != 2) {
			throw new RuntimeException("La jarra especificada no existe");
		}
		if (x == 1) {
			jarra1.llena(); // llamar a m�todo de clase Jarra (no este)
		} else if (x == 2) {
			jarra2.llena();
		}
	}
	public void vacia (int x) {
		if (x != 1 & x != 2) {
			throw new RuntimeException("La jarra especificada no existe");
		}
		if (x == 1) {
			jarra1.vacia(); // llamar a m�todo de clase Jarra (no este)
		} else if (x == 2) {
			jarra2.vacia();
		}
	}
	public void llenaDesde (int x) {
		if (x != 1 & x != 2) {
			throw new RuntimeException("La jarra especificada no existe");
		}
		if (x == 1) {
			jarra2.llenaDesde(jarra1); // llamar a m�todo de clase Jarra (no este)
		} else if (x == 2) {
			jarra1.llenaDesde(jarra2);
		}
	}
	@Override
	public String toString() {
		return "M(J(" + jarra1.capacidad() + ", " + jarra1.contenido() + "), J(" + jarra2.capacidad() + ", " + jarra2.contenido() + "))";
	}

}

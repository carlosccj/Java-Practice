package prCalculos;

public class NumeroRacional {
	private int numerador;
	private int denominador;

	public NumeroRacional() {
		this(0, 1);
	}

	public NumeroRacional(int num, int den) {
		if (den == 0) {
			throw new RuntimeException("El denominador no puede ser cero");
		}
		numerador = num;
		denominador = den;
	}

	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public int mcd(NumeroRacional a) {
		int dena = a.getDenominador();
		int denb = this.getDenominador();
		int menor = dena < denb ? dena : denb;
		int mayor = dena > denb ? dena : denb;
		int cnt = 2;
		int res = 0;
		int menorcnt = menor;
		int mayorcnt = mayor;
		for (int i = 1; i < (dena * denb) && res == 0; i++) {
			menorcnt = menor * i;
			if (menorcnt == mayorcnt) {
				res = mayorcnt;
			} else if (menorcnt > mayorcnt) {
				mayorcnt = mayor * cnt;
				cnt++;
			}
		}
		return res;
	}

	public NumeroRacional suma(NumeroRacional sum) {
		int sumden = mcd(sum);
		int sumnum = ((sumden / this.getDenominador()) * this.getNumerador())
				+ ((sumden / sum.getDenominador()) * sum.getNumerador());
		NumeroRacional result = new NumeroRacional(sumnum, sumden);
		result = result.normalizar(sumden);
		return result;
	}

	public NumeroRacional resta(NumeroRacional rest) {
		int restden = mcd(rest);
		int restnum = ((restden / this.getDenominador()) * this.getNumerador())
				- ((restden / rest.getDenominador()) * rest.getNumerador());
		NumeroRacional result = new NumeroRacional(restnum, restden);
		result = result.normalizar(restden);
		return result;
	}

	public NumeroRacional mult(NumeroRacional mul) {
		int mulNumerador = this.getNumerador() * mul.getNumerador();
		int mulDenominador = this.getDenominador() * mul.getDenominador();
		NumeroRacional result = new NumeroRacional(mulNumerador, mulDenominador);
		result = result.normalizar(mcd(mul));
		return result;
	}

	public NumeroRacional div(NumeroRacional div) {
		int divNumerador = this.getNumerador() * div.getDenominador();
		int divDenominador = this.getDenominador() * div.getNumerador();
		NumeroRacional result = new NumeroRacional(divNumerador, divDenominador);
		result = result.normalizar(mcd(div));
		return result;
	}

	public NumeroRacional normalizar(int mcd) {
		int num = this.getNumerador();
		int den = this.getDenominador();
		NumeroRacional result;
		if (num == 0) {
			result = new NumeroRacional(this.getNumerador(), this.getDenominador());
		} else {
			for (int i = 2; i <= (mcd); i++) {
				while (num % i == 0 && den % i == 0) {
					den = den / i;
					num = num / i;
				}
			}
		}
		result = new NumeroRacional(num, den);
		return result;
	}

	@Override
	public String toString() {
		String str = "";
		str = getNumerador() + "/" + getDenominador();
		return str;
	}

}

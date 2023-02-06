// ALUMNO: Carlos Castrillo Jimenez
// GRUPO: E

import java.util.*;

public class TableroSudoku implements Cloneable {

	// constantes relativas al nº de filas y columnas del tablero
	protected static final int MAXVALOR = 9;
	protected static final int FILAS = 9;
	protected static final int COLUMNAS = 9;

	protected static Random r = new Random();

	protected int celdas[][]; // una celda vale cero si esta libre.

	public TableroSudoku() {
		celdas = new int[FILAS][COLUMNAS]; // todas a cero.
	}

	// crea una copia de su parametro
	public TableroSudoku(TableroSudoku uno) {
		TableroSudoku otro = (TableroSudoku) uno.clone();
		this.celdas = otro.celdas;
	}

	// crear un tablero a parir de una configuracion inicial (las celdas vacias
	// se representan con el caracter ".".
	public TableroSudoku(String s) {
		this();
		if (s.length() != FILAS * COLUMNAS) {
			throw new RuntimeException("Construcci\u00D3n de sudoku no v\u00E1lida.");
		} else {
			for (int f = 0; f < FILAS; f++)
				for (int c = 0; c < COLUMNAS; c++) {
					Character ch = s.charAt(f * FILAS + c);
					celdas[f][c] = (Character.isDigit(ch) ? Integer.parseInt(ch.toString()) : 0);
				}
		}
	}

	/*
	 * Realizar una copia en profundidad del objeto
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		TableroSudoku clon;
		try {
			clon = (TableroSudoku) super.clone();
			clon.celdas = new int[FILAS][COLUMNAS];
			for (int i = 0; i < celdas.length; i++)
				System.arraycopy(celdas[i], 0, clon.celdas[i], 0, celdas[i].length);
		} catch (CloneNotSupportedException e) {
			clon = null;
		}
		return clon;
	}

	/*
	 * Igualdad para la clase
	 * 
	 * @see java.lang.Object#equals()
	 */
	public boolean equals(Object obj) {
		if (obj instanceof TableroSudoku) {
			TableroSudoku otro = (TableroSudoku) obj;
			for (int f = 0; f < FILAS; f++)
				if (!Arrays.equals(this.celdas[f], otro.celdas[f]))
					return false;
			return true;
		} else
			return false;
	}

	public String toString() {
		String s = "";

		for (int f = 0; f < FILAS; f++) {
			for (int c = 0; c < COLUMNAS; c++)
				s += (celdas[f][c] == 0 ? "." : String.format("%d", celdas[f][c]));
		}
		return s;
	}

	// devuelva true si la celda del tablero dada por fila y columna esta vacia.
	protected boolean estaLibre(int fila, int columna) {
		return celdas[fila][columna] == 0;
	}

	// devuelve el número de casillas libres en un sudoku.
	protected int numeroDeLibres() {
		int n = 0;
		for (int f = 0; f < FILAS; f++)
			for (int c = 0; c < COLUMNAS; c++)
				if (estaLibre(f, c))
					n++;
		return n;
	}

	// devuelve el número de casillas ocupadas en un sudoku
	protected int numeroDeFijos() {
		return FILAS * COLUMNAS - numeroDeLibres();
	}

//Los siguientes metodos son a completar por el alumno

	// Devuelve true si @valor ya esta en la fila @fila.
	protected boolean estaEnFila(int fila, int valor) {
		boolean ok = false;
		for (int i = 0; i < MAXVALOR && !ok; i++) {
			ok = celdas[fila][i] == valor ? true : false;
		}
		return ok;
	}

	// Devuelve true si @valor ya esta en la columna @columna.
	protected boolean estaEnColumna(int columna, int valor) {
		boolean ok = false;
		for (int i = 0; i < MAXVALOR && !ok; i++) {
			ok = celdas[i][columna] == valor ? true : false;
		}
		return ok;
	}

	// Devuelve true si @valor ya esta en subtablero al que pertence @fila y
	// @columna.
	protected boolean estaEnSubtablero(int fila, int columna, int valor) {
		boolean ok = false;
		int cuadranteFila = calcularCuadrante(fila);
		int cuadranteColumna = calcularCuadrante(columna);
		int cf = cuadranteFila + 3;
		int cc = cuadranteColumna + 3;
		for (int i = cuadranteFila; i < (cf) && !ok; i++) {
			for (int j = cuadranteColumna; j < (cc) && !ok; j++) {
				ok = celdas[i][j] == valor ? true : false;
			}
		}
		return ok;
	}

	private int calcularCuadrante(int param) {
		int i = 0;
		if (param >= 0 && param < 3) {
			i = 0;
		} else if (param >= 3 && param < 6) {
			i = 3;
		} else {
			i = 6;
		}
		return i;
	}

	// Devuelve true si se puede colocar el @valor en la @fila y @columna dadas.
	protected boolean sePuedePonerEn(int fila, int columna, int valor) {
		boolean ok = false;
		if (!estaEnFila(fila, valor) && !estaEnColumna(columna, valor) && !estaEnSubtablero(fila, columna, valor)) {
			ok = true;
		}
		return ok;
	}

	protected void resolverTodos(List<TableroSudoku> soluciones, int fila, int columna) {
		if (numeroDeLibres() == 0) {
			soluciones.add(new TableroSudoku(this));
		} else {
			for (int i = 1; i <= MAXVALOR; i++) {
				if (sePuedePonerEn(fila, columna, i) && columna == MAXVALOR - 1) {
					TableroSudoku aux = new TableroSudoku(this);
					aux.celdas[fila][columna] = i;
					resolverTodos(soluciones, fila + 1, 0);
				} else if (sePuedePonerEn(fila, columna, i) && columna < MAXVALOR - 1) {
					TableroSudoku aux = new TableroSudoku(this);
					aux.celdas[fila][columna] = i;
					resolverTodos(soluciones, fila, columna + 1);
				} else if (!sePuedePonerEn(fila, columna, i) && columna == MAXVALOR - 1) {
					resolverTodos(soluciones, fila + 1, 0);
				} else if (!sePuedePonerEn(fila, columna, i) && columna < MAXVALOR - 1) {
					resolverTodos(soluciones, fila, columna + 1);
				}
			}
		}
	}

	// Los anteriores metodos son a completar por el alumno

	public List<TableroSudoku> resolverTodos() {
		List<TableroSudoku> sols = new LinkedList<TableroSudoku>();
		resolverTodos(sols, 0, 0);
		return sols;
	}

	public static void main(String arg[]) {
		TableroSudoku t = new TableroSudoku(
				".4....36263.941...5.7.3.....9.3751..3.48.....17..62...716.9..2...96.......312..9.");
		List<TableroSudoku> lt = t.resolverTodos();
		System.out.println(t);
		System.out.println(lt.size());
		for (Iterator<TableroSudoku> i = lt.iterator(); i.hasNext();) {
			TableroSudoku ts = i.next();
			System.out.println(ts);

		}

	}

}

/*
 * if (numeroDeLibres() == 0) {
			soluciones.add(new TableroSudoku(this));
		} else {
			for (int i = 1; i <= MAXVALOR; i++) {
				TableroSudoku aux = new TableroSudoku(this);
				if (estaLibre(fila, columna)) {
					if (sePuedePonerEn(fila, columna, i)) {
						aux.celdas[fila][columna] = i;
						if (columna == 8 && fila < 8) {
							aux.resolverTodos(soluciones, fila + 1, 0);
						} else if (columna < 8) {
							aux.resolverTodos(soluciones, fila, columna + 1);
						} else if (columna == 8 && fila == 8) {
							// System.out.println("KJAEBDFKJNDEWKJFNKEWJ");
						}
					}
				} else {
					if (columna == 8 && fila < 8) {
						resolverTodos(soluciones, fila + 1, 0);
					} else if (columna < 8) {
						resolverTodos(soluciones, fila, columna + 1);
					} else if (columna == 8 && fila == 8) {
						// System.out.println("KJAEBDFKJNDEWKJFNKEWJ");
					}
				}
			}
		}
		*/

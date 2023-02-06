import prCuentaPalabrasSimpleFicheros.*;

import java.util.NoSuchElementException;
import prCuentaPalabrasSimpleFicheros.*;
import java.io.*;

public class PruebaContadorPalabras {
	public static void main(String[] args) {
		ContadorPalabras cp = new ContadorPalabras(5);
		String[] datos = { "Esta es la primera frase del ejemplo", "y esta es la segunda frase" };
		cp.incluyeTodas(datos, " ");
		System.out.println(cp);
	}
}


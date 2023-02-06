import prLibreria.*;

public class PruebaLibreria {
	public static void main (String[] args) {
		Libreria a = new Libreria (8);
		a.addLibro("george orwell", "1984", 8.20);
		a.addLibro("Philip K. Dick", "�Sue�an los androides con ovejas el�ctricas?", 3.50);
		a.addLibro("Isaac Asimov", "Fundaci�n e Imperio", 9.40);
		a.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		a.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
		a.addLibro("Isaac Asimov", "La Fundaci�n", 7.30);
		a.addLibro("William Gibson", "Neuromante", 8.30);
		a.addLibro("Isaac Asimov", "Segunda Fundaci�n", 8.10);
		a.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
		a.addLibro("George Orwell", "1984", 6.20);
		a.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
		System.out.println(a.toString());
		a.remLibro("George Orwell", "1984");
		a.remLibro("Aldous Huxley", "Un Mundo Feliz");
		a.remLibro("Isaac Newton", "Arithmetica Universalis");
		a.remLibro("James Gosling", "The Java Language Specification");
		System.out.println(a.toString());
		System.out.println("PrecioFinal (George Orwell, 1984): " + a.getPrecioFinal("George Orwell", "1984"));
		System.out.println("PrecioFinal (Philip K. Dick, �Sue�an los androides con ovejas el�ctricas?): " + a.getPrecioFinal("Philip K. Dick", "�Sue�an los androides con ovejas el�ctricas?"));
		System.out.println("PrecioFinal (isaac asimov, fundaci�n e imperio): " + a.getPrecioFinal("isaac asimov", "fundaci�n e imperio"));
		System.out.println("PrecioFinal (Ray Bradbury, Fahrenheit 451): " + a.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
		System.out.println("PrecioFinal (Aldous Huxley, Un Mundo Feliz): " + a.getPrecioFinal("Aldous Huxley", "Un Mundo Feliz"));
		System.out.println("PrecioFinal (Isaac Asimov, La Fundaci�n): " + a.getPrecioFinal("Isaac Asimov", "La Fundaci�n"));				
		System.out.println("PrecioFinal (william gibson, neuromante): " + a.getPrecioFinal("william gibson", "neuromante"));
		System.out.println("PrecioFinal (Isaac Asimov, Segunda Fundaci�n): " + a.getPrecioFinal("Isaac Asimov", "Segunda Fundaci�n"));
		System.out.println("PrecioFinal (Isaac Newton, Arithmetica Universalis): " + a.getPrecioFinal("Isaac Newto", "Arithmetica Universalis"));
		
	}

}

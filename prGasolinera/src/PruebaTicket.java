import prGasolinera.*;
import java.util.*;

public class PruebaTicket {
	public static void main(String[] args) {
		try {
			Ticket a = new Ticket("Teatinos", 1, "1111aaa", 50, 1.40);
			Ticket b = new Ticket("TEATINOS", 1, "1111AAA", 45, 2.40);
			Ticket c = new Ticket("Teatinos", 2, "2222BBB", 50, 1.40);
			Ticket d = new Ticket("Ampliacion", 1, "333CCC", 40, 1.30);
			System.out.println(a);
			System.out.println(b);
			if (a.equals(b)) {
				System.out.println("Ambos objetos son iguales");
			} else {
				System.out.println("Los objetos no son iguales");
			}
			SortedSet<Ticket> tickets = new TreeSet<Ticket>();
			tickets.add(a);
			tickets.add(b);
			tickets.add(c);
			tickets.add(d);
			System.out.println(tickets);
			Ticket err = new Ticket("Teatinos", 1, "5555SSS", -10, 1.40);
		} catch (GasolineraException e) {
			System.out.println(e.getMessage());
		}
	}

}

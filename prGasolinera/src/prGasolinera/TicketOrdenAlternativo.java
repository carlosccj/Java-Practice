package prGasolinera;
import java.util.*;

public class TicketOrdenAlternativo implements Comparator<Ticket> {

	@Override
	public int compare(Ticket o1, Ticket o2) {
		int cmp = Integer.compare(o2.getNumTicket(), o1.getNumTicket());
		if (cmp == 0) {
			cmp = o1.getGasolinera().compareToIgnoreCase(o2.getGasolinera());
		}
		return cmp;
	}

}

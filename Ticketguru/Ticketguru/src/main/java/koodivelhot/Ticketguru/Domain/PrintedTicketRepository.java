package koodivelhot.Ticketguru.Domain;

import org.springframework.data.repository.CrudRepository;

public interface PrintedTicketRepository  extends CrudRepository <PrintedTicket, Long> {
	PrintedTicket findBypTicketId(Long pTicketId);
}

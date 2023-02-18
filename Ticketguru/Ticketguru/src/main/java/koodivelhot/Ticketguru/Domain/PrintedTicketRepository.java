package koodivelhot.Ticketguru.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PrintedTicketRepository  extends CrudRepository <PrintedTicket, Long> {
	List <PrintedTicket> findBypTicketId(Long pTicketId);
}

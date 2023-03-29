package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PrintedTicketRepository  extends CrudRepository <PrintedTicket, Long> {
	List <PrintedTicket> findBypTicketId(Long pTicketId);
	Optional <PrintedTicket> findById(Long pTicketId); // lisätty tämä metodi jotta controller toimii
}

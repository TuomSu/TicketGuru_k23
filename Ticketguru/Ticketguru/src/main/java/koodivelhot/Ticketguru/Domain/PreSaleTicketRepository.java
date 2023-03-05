package koodivelhot.Ticketguru.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PreSaleTicketRepository extends CrudRepository <PreSaleTicket, Long> {
		
	List <PreSaleTicket> findByPresaleticketid(Long presaleticketid);
}

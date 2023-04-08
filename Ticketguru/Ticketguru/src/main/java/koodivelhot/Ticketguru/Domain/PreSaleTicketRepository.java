package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PreSaleTicketRepository extends CrudRepository <PreSaleTicket, Long> {
		
	//Optional<PreSaleTicket> findById(Long presaleticketid);
	
	PreSaleTicket findByCode(String code);
	
	List<PreSaleTicket> findByPresaleticketid(Long presaleticketid);
}

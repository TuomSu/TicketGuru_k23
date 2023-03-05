package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AcceptableTicketTypesRepository extends CrudRepository<AcceptableTicketTypes, Long> {
	
	List<AcceptableTicketTypes> findByEvent(Event eventName);

}

package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AcceptableTicketTypesRepository extends CrudRepository<AcceptableTicketTypes, Long> {
	
	Optional<AcceptableTicketTypes> findByLineId(Long lineId);
	
	List<AcceptableTicketTypes> findByEventEventName(String eventName);
	
	Optional<AcceptableTicketTypes> findByEvent(Long event_id);

}

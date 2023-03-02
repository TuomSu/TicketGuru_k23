package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



public interface EventRepository extends CrudRepository<Event, Long> {

	List<Event> findByEventName(String eventName);
// muokattu hakua id:n perusteella
	Optional<Event> findById(Long event_id);
    
}

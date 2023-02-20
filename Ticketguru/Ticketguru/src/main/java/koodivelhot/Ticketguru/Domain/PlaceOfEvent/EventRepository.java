package koodivelhot.Ticketguru.Domain.PlaceOfEvent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface EventRepository extends CrudRepository<Event, String> {

	List<Event> findByEventName(String eventName);

	Event findById(Long event_id);
    
}

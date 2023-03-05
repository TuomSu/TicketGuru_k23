package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface VenueRepository extends CrudRepository<Venue, Long> {

	List<Venue> findByVenueName(String venueName);
	
	Optional<Venue> findById(Long venue_id);
    
}
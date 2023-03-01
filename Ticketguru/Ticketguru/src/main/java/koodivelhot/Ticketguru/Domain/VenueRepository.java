package koodivelhot.Ticketguru.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface VenueRepository extends CrudRepository<Venue, Long> {

	List<Venue> findByVenueName(String venueName);
    
}
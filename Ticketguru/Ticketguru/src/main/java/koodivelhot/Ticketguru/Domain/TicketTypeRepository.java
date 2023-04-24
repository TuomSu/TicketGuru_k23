package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {

	List<TicketType> findByType(String type);
	Optional<TicketType> findById(Long id);
 
}

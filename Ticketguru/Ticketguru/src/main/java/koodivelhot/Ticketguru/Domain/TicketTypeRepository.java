package koodivelhot.Ticketguru.Domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {

	List<TicketType> findByTicketTypeName(String type);
    
}

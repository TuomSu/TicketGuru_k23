package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface SaleEventRepository extends CrudRepository <SaleEvent, Long> {
	
	List<SaleEvent> findBySaleid(Long saleid);
	
	Optional<SaleEvent> findById(Long saleid);

}

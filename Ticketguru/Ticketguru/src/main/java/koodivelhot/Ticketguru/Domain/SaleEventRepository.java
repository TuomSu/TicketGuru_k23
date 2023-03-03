package koodivelhot.Ticketguru.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SaleEventRepository extends CrudRepository <SaleEvent, Long> {
	
	List<SaleEvent> findBySaleid(Long saleid);

}

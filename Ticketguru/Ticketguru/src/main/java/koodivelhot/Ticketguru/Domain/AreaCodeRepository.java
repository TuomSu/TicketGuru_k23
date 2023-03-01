package koodivelhot.Ticketguru.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface AreaCodeRepository extends CrudRepository<AreaCode, String> {

	List<AreaCode> findByAreaCode(String areaCode);
    
}

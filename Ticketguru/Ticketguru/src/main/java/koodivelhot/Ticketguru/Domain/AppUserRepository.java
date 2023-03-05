package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository <AppUser, Long> {
	List<AppUser> findByUsername(String username);
	Optional<AppUser> findById(Long userid);
	
	 
	
	

}

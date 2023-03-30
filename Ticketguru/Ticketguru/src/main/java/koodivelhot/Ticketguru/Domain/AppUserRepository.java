package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository <AppUser, Long> {
	//List<AppUser> findByUsername1(String username); // Jouduin kommentoimaan tämän pois jotta usedetails service toimii
	Optional<AppUser> findById(Long userid);
	AppUser findByUsername (String username); // tätä tarvitaan userdetailserviceen
	
	 
	
	

}

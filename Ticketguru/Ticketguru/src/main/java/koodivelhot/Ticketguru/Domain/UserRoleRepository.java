package koodivelhot.Ticketguru.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



public interface UserRoleRepository extends CrudRepository <UserRole, Long> {

	List<UserRole> findByRole(String role);
	Optional<UserRole> findById(Long roleid);
	
}

package koodivelhot.Ticketguru.Domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository <UserRole, Long> {

	UserRole findByRole(String role);
	
}

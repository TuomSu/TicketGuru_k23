package koodivelhot.Ticketguru;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	AppUserRepository users;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<AppUser> user = users.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username + " was not found");
        }
        return new org.springframework.security.core.userdetails.User(
                ((UserDetails) user).getUsername(),
                ((UserDetails) user).getPassword(),
                AuthorityUtils.createAuthorityList(( (AppUser) user).getRole().getRole())
        );
    }
}

package koodivelhot.Ticketguru.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	AppUserRepository users;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser curruser = users.findByUsername(username);
        
        if (curruser == null){
            throw new UsernameNotFoundException(username + " was not found");
        }
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole().getRights()));
        
        return user;
    }
}

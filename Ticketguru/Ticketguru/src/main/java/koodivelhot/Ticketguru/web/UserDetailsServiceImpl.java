/*package koodivelhot.Ticketguru.web;

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
        		AuthorityUtils.createAuthorityList(curruser.getRole().getRole()));
        
        return user;
    }
}*/


package koodivelhot.Ticketguru.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.AppUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	private final AppUserRepository usersRepo;
	
	@Autowired
	public UserDetailsServiceImpl(AppUserRepository usersRepo) {
		this.usersRepo = usersRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("Load user by username: " + username);
		AppUser curruser = usersRepo.findByUsername(username);
		log.info("Käyttäjä ID: " + curruser.getUserid());
		log.info("Rooli: " + curruser.getRole().getRole());
		log.info("Current user: " + curruser.toString());
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(curruser.getRole().getRole()));
		log.info("user: " + user.toString());
		log.info("Authorities: " + user.getAuthorities());
		return user;
	}
}

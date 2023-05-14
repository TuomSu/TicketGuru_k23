package koodivelhot.Ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.AreaCode;
import koodivelhot.Ticketguru.Domain.AreaCodeRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;

import koodivelhot.Ticketguru.Domain.PrintedTicket;
import koodivelhot.Ticketguru.Domain.PrintedTicketRepository;

import koodivelhot.Ticketguru.Domain.TicketType;
import koodivelhot.Ticketguru.Domain.TicketTypeRepository;
import koodivelhot.Ticketguru.Domain.UserRole;
import koodivelhot.Ticketguru.Domain.UserRoleRepository;
import koodivelhot.Ticketguru.Domain.Venue;
import koodivelhot.Ticketguru.Domain.VenueRepository;

@RestController
public class TicketguruController {
	
	@Autowired
	private EventRepository erepository;
	
	@Autowired
	private VenueRepository vrepository;
	
	@Autowired
	private AreaCodeRepository acrepository;
	
	@Autowired
	AppUserRepository urepository;
	
	@Autowired
	UserRoleRepository rrepository;
	
	@Autowired
	TicketTypeRepository ttrepository;
	
	@Autowired
	private PrintedTicketRepository prrepository;
	
	@GetMapping("testi")
	@ResponseBody
	public String doTest() {
		return "Test successful";
	}
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
    

	
	//Tapahtuma
	
	// REST, get all events
	@PreAuthorize("hasAnyAuthority('admin','basic')")
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public @ResponseBody List<Event> eventListRest() {
		return(List<Event>) erepository.findAll();
	}
	
	// REST, get event by id
	@PreAuthorize("hasAnyAuthority('admin','basic')")
	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Event> findEventRest(@PathVariable("id") Long event_id) {
		Optional<Event> event = erepository.findById(event_id);
		
		if (event.isPresent()) {
			erepository.findById(event_id);
			return erepository.findById(event_id);
			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa ei löytynyt annetulla id:llä");
			}
	}
	
	// REST, add new event
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	public @ResponseBody Event newEvent(@RequestBody Event newEvent) {
		return erepository.save(newEvent);
	}
	
	//REST, update event by id
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/event/{id}", method = RequestMethod.PUT)
	public @ResponseBody Event editEvent(@RequestBody Event editedEvent, @PathVariable("id") Long event_id) {
		editedEvent.setEvent_id(event_id);
		return erepository.save(editedEvent);
	}
	
	//rest, delete by id and show updated list of events
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<Event> deleteEvent(@PathVariable("id") Long event_id) {
		Optional<Event> event = erepository.findById(event_id);
		
		if (event.isPresent()) {
			erepository.deleteById(event_id);
			return (List<Event>) erepository.findAll();
			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa ei löytynyt annetulla id:llä");
			}
	}
	
	//Tapahtumaan hyväksyttävät lipputyypit
	
	// REST, delete acceptable ticket type by line id
	/*@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/atickettypes/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<AcceptableTicketTypes> deleteAcceptableTicketTypes(@PathVariable("id") Long lineId) {
		attrepository.deleteById(lineId);
		return (List<AcceptableTicketTypes>) attrepository.findAll();
	}

	// REST, add new acceptable ticket type
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/acceptabletickettypes", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Tapahtumaan hyväksyttävä lipputyyppi luotu")
	public @ResponseBody AcceptableTicketTypes newAcceptableTicketTypes(@RequestBody AcceptableTicketTypes newAcceptableTicketTypes) {
		return attrepository.save(newAcceptableTicketTypes);
	}*/
	
	//Tapahtumapaikka
	
	// REST, get all venues
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/venues", method = RequestMethod.GET)
	public @ResponseBody List<Venue> venueListRest() {
		return(List<Venue>) vrepository.findAll();
	}
	
	// REST, get venue by id
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/venue/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Venue> findVenueRest(@PathVariable("id") Long venue_id) {
		return vrepository.findById(venue_id);
	}
	
	// REST, add new venue
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/venues", method = RequestMethod.POST)
	public @ResponseBody Venue newVenue(@RequestBody Venue newVenue) {
		return vrepository.save(newVenue);
	}
	
	//REST, update venue by id
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/venue/{id}", method = RequestMethod.PUT)
	public @ResponseBody Venue editVenue(@RequestBody Venue editedVenue, @PathVariable("id") Long venue_id) {
		Optional<Venue> venue = vrepository.findById(venue_id);
		
		
			if (venue.isPresent()) {
			editedVenue.setVenue_id(venue_id);
			return vrepository.save(editedVenue);
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annettua tapahtumapaikkaa ei löytynyt");
			} 
	}
	
	//rest, delete by id and show updated list of venues
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/venue/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<Venue> deleteVenue(@PathVariable("id") Long venue_id) {
		Optional<Venue> venue = vrepository.findById(venue_id);
		
		if (venue.isPresent()) {
			vrepository.deleteById(venue_id);
			return (List<Venue>) vrepository.findAll();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annettua tapahtumapaikkaa ei löytynyt");
		} 
	}
	
	//Kaupunki
	
	// REST, get all areacodes
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/acodes", method = RequestMethod.GET)
	public @ResponseBody List<AreaCode> areacodeListRest() {
		return(List<AreaCode>) acrepository.findAll();
	}
	
	// REST, get areacode
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody List<AreaCode> findAreaCodeRest(@PathVariable("id") String areaCode) {
		return acrepository.findByAreaCode(areaCode);
	}
	
	// REST, add new areacode
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/acodes", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Postinumero lisätty")
	public @ResponseBody AreaCode newAreaCode(@RequestBody AreaCode newAreaCode) {
		return acrepository.save(newAreaCode);
	}
	
	//REST, update areacode by id
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody AreaCode editAreaCode(@RequestBody AreaCode editedAreaCode, @PathVariable("id") String areaCode) {
		Optional<AreaCode> acode = acrepository.findById(areaCode);
		if (acode.isPresent()) {
			editedAreaCode.setAreaCode(areaCode);
			return acrepository.save(editedAreaCode);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annettua postikoodia ei löytynyt");	
		}
		
		
		
	}
	
	//rest, delete by id and show updated list of areacodes
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<AreaCode> deleteAreaCode(@PathVariable("id") String areaCode) {
		Optional<AreaCode> acode = acrepository.findById(areaCode);
		
		if (acode.isPresent()) {
			acrepository.deleteById(areaCode);
			return (List<AreaCode>) acrepository.findAll();
			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Annettua postikoodia ei löytynyt");
		}
	}
	
	// Lipputyypit
	
	// REST, get all tickettypes
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/tickettypes", method = RequestMethod.GET)
	public @ResponseBody List<TicketType> tickettypeListRest() {
		return(List<TicketType>) ttrepository.findAll();
	}
	
	// REST, get tickettype by id
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "tickettype/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<TicketType> findTicketTypeRest(@PathVariable("id") Long type_id) {
		Optional<TicketType> type = ttrepository.findById(type_id);
		
		if (type.isPresent()) {
			return ttrepository.findById(type_id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lipputyyppiä ei löytynyt annetulla id:llä");
		}
	}

	// REST, update tickettype by id
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "tickettype/{id}", method = RequestMethod.PUT)
	public @ResponseBody TicketType editTicketType(@Valid @RequestBody TicketType editedTicketType, @PathVariable("id") Long type_id) {
		Optional<TicketType> type = ttrepository.findById(type_id);
		
		if (type.isPresent()) {
			editedTicketType.setType_id(type_id);
			return ttrepository.save(editedTicketType);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lipputyyppiä ei löytynyt annetulla id:llä");
		}
	}

	// REST, delete tickettype by id
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "tickettype/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<TicketType> deleteTicketType(@PathVariable("id") Long type_id) {
		Optional<TicketType> type = ttrepository.findById(type_id);
		
		if (type.isPresent()) {
			ttrepository.deleteById(type_id);
			return (List<TicketType>) ttrepository.findAll();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lipputyyppiä ei löytynyt annetulla id:llä");
		}
	}

	// REST, add new tickettype
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/tickettypes", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Lipputyyppi luotu")
	public @ResponseBody TicketType newTicketType(@Valid @RequestBody TicketType newTicketType) {
		return ttrepository.save(newTicketType);
	}
	
	//PrintedTicket

		// REST, get all printed tickets
		@PreAuthorize("hasAnyAuthority('admin','basic')")
		@RequestMapping(value = "/printedtickets", method = RequestMethod.GET)
		public @ResponseBody List<PrintedTicket> PrintedTicketListRest() {
			return(List<PrintedTicket>) prrepository.findAll();
		}
		
		// REST, get printedticket by id
		@PreAuthorize("hasAnyAuthority('admin','basic')")
		@RequestMapping(value = "/printedticket/{id}", method = RequestMethod.GET)
		public @ResponseBody List<PrintedTicket> findPrintedTicketRest(@PathVariable("id") Long pTicketId) {
			Optional<PrintedTicket> printedticket = prrepository.findById(pTicketId);
			
			if(printedticket.isPresent()) {
				return prrepository.findBypTicketId(pTicketId);
			} else {
				throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "Tulostettua lippua ei löytynyt annetulla id:llä");
			}
		}
				
		// REST, delete printed ticket by id
		@PreAuthorize("hasAuthority('admin')")
		@RequestMapping(value = "/printedticket/{id}", method = RequestMethod.DELETE)
		public @ResponseBody List<PrintedTicket> deletePrintedTicket(@PathVariable("id") Long pTicketId) {
			Optional<PrintedTicket> printedticket = prrepository.findById(pTicketId);
			
			if(printedticket.isPresent()) {
				prrepository.deleteById(pTicketId);
				return (List<PrintedTicket>) prrepository.findAll();
			} else {
				throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "Tulostettua lippua ei löytynyt annetulla id:llä");
			}
		}

		//REST, update printed ticket by id
		@PreAuthorize("hasAuthority('admin')")
		@RequestMapping(value = "/printedticket/{id}", method = RequestMethod.PUT)
		public @ResponseBody PrintedTicket editPrintedticket(@Valid @RequestBody PrintedTicket editedPrintedTicket, @PathVariable("id") Long pTicketId) {
			Optional<PrintedTicket> printedticket = prrepository.findById(pTicketId);
			
			if (printedticket.isPresent()) {
				editedPrintedTicket.setpTicketId(pTicketId);
				return prrepository.save(editedPrintedTicket);
			} else { // jos tulostetulla ei löydy annetulla id:llä ei muokkaus ole mahdollista eikä luoda uutta tulostettualippua
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tulostettualippua ei löytynyt annetulla id:llä");
			}
			
			
		}

		// REST, add new printed ticket
		@PreAuthorize("hasAuthority('admin')")
		@RequestMapping(value = "printedtickets", method = RequestMethod.POST)
		@ResponseStatus(value = HttpStatus.CREATED, reason = "Tulostettu luotu")
		public @ResponseBody PrintedTicket newPrintedTicket(@Valid @RequestBody PrintedTicket printedticket) {
				return prrepository.save(printedticket);
		}

	
	

	
	// Käyttäjät
	
	//REST, get all users
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<AppUser> UserListRest() {
		return(List<AppUser>) urepository.findAll();
	}
	
	// GET user by id
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<AppUser> findUserRest(@PathVariable("id") Long userid) {
		Optional<AppUser> user = urepository.findById(userid);
		if(user.isPresent()) {
			return urepository.findById(userid);
		}else {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Käyttäjää ei löytynyt annetulla id:llä");
		}
	}
		
	// REST, add new user
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "users", method = RequestMethod.POST)
	public @ResponseBody AppUser newAppUser(@Valid @RequestBody AppUser appuser) {
			return urepository.save(appuser);
		}
		
	//REST, update user
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public @ResponseBody AppUser editUser(@Valid @RequestBody AppUser editedUser, @PathVariable("id") Long userid) {
		Optional<AppUser> user = urepository.findById(userid);
		if(user.isPresent()) {
			editedUser.setUserid(userid);
			return urepository.save(editedUser);
		}else { //jos käyttäjää ei löydy annetulla id:llä, ei muokkaus ole mahdollista eikä luoda uutta käyttäjää
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Käyttäjää ei löytynyt annetulla id:llä");
		}
	}
			
	//REST, delete by id user
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<AppUser> deleteUser(@PathVariable("id") Long userid) {
		Optional<AppUser> user = urepository.findById(userid);
		if(user.isPresent()) {
			urepository.deleteById(userid);
			return (List<AppUser>) urepository.findAll();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Käyttäjää ei löytynyt annetulla id:llä");
			}
	}

	// REST, get all ROLES
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public @ResponseBody List<UserRole> UserRoleRest() {
		return(List<UserRole>) rrepository.findAll();
	}
	// GET role by id
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<UserRole> findRoleRest(@PathVariable("id") Long roleid) {
		Optional<UserRole> role = rrepository.findById(roleid);
		if(role.isPresent()) {
			return rrepository.findById(roleid);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Roolia ei löytynyt annetulla id:llä");
		}
		
	}
			
	// REST, add new role
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "roles", method = RequestMethod.POST)
	public @ResponseBody UserRole newUserRole(@RequestBody UserRole role) {
		return rrepository.save(role);
	}
	
}

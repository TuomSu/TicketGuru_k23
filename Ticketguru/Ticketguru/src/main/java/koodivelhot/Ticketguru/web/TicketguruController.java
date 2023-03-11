package koodivelhot.Ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.AreaCode;
import koodivelhot.Ticketguru.Domain.AreaCodeRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;
import koodivelhot.Ticketguru.Domain.SaleEvent;
import koodivelhot.Ticketguru.Domain.SaleEventRepository;
import koodivelhot.Ticketguru.Domain.UserRole;
import koodivelhot.Ticketguru.Domain.UserRoleRepository;
import koodivelhot.Ticketguru.Domain.Venue;
import koodivelhot.Ticketguru.Domain.VenueRepository;

@Controller
public class TicketguruController {
	
	@Autowired
	private EventRepository erepository;
	
	@Autowired
	private VenueRepository vrepository;
	
	@Autowired
	private AreaCodeRepository acrepository;
	
	@Autowired
	private SaleEventRepository serepository;
	
	@Autowired
	AppUserRepository urepository;
	
	@Autowired
	UserRoleRepository rrepository;
	
	@GetMapping("testi")
	@ResponseBody
	public String doTest() {
		return "Test successful";
	}
	
	//Tapahtuma
	
	// REST, get all events
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public @ResponseBody List<Event> eventListRest() {
		return(List<Event>) erepository.findAll();
	}
	
	// REST, get event by id
	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Event> findEventRest(@PathVariable("id") Long event_id) {
		return erepository.findById(event_id);
	}
	
	// REST, add new event
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	public @ResponseBody Event newEvent(@RequestBody Event newEvent) {
		return erepository.save(newEvent);
	}
	
	//REST, update event by id
	@RequestMapping(value = "/event/{id}", method = RequestMethod.PUT)
	public @ResponseBody Event editEvent(@RequestBody Event editedEvent, @PathVariable("id") Long event_id) {
		editedEvent.setEvent_id(event_id);
		return erepository.save(editedEvent);
	}
	
	//rest, delete by id and show updated list of events
	@RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<Event> deleteEvent(@PathVariable("id") Long event_id) {
		erepository.deleteById(event_id);
		return (List<Event>) erepository.findAll();
	}
	
	//Tapahtumapaikka
	
	// REST, get all venues
	@RequestMapping(value = "/venues", method = RequestMethod.GET)
	public @ResponseBody List<Venue> venueListRest() {
		return(List<Venue>) vrepository.findAll();
	}
	
	// REST, get venue by id
	@RequestMapping(value = "/venue/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Venue> findVenueRest(@PathVariable("id") Long venue_id) {
		return vrepository.findById(venue_id);
	}
	
	// REST, add new venue
	@RequestMapping(value = "/venues", method = RequestMethod.POST)
	public @ResponseBody Venue newVenue(@RequestBody Venue newVenue) {
		return vrepository.save(newVenue);
	}
	
	//REST, update venue by id
	@RequestMapping(value = "/venue/{id}", method = RequestMethod.PUT)
	public @ResponseBody Venue editVenue(@RequestBody Venue editedVenue, @PathVariable("id") Long venue_id) {
		editedVenue.setVenue_id(venue_id);
		return vrepository.save(editedVenue);
	}
	
	//rest, delete by id and show updated list of venues
	@RequestMapping(value = "/venue/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<Venue> deleteVenue(@PathVariable("id") Long venue_id) {
		vrepository.deleteById(venue_id);
		return (List<Venue>) vrepository.findAll();
	}
	
	//Kaupunki
	
	// REST, get all areacodes
	@RequestMapping(value = "/acodes", method = RequestMethod.GET)
	public @ResponseBody List<AreaCode> areacodeListRest() {
		return(List<AreaCode>) acrepository.findAll();
	}
	
	// REST, get areacode
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody List<AreaCode> findAreaCodeRest(@PathVariable("id") String areaCode) {
		return acrepository.findByAreaCode(areaCode);
	}
	
	// REST, add new areacode
	@RequestMapping(value = "/acodes", method = RequestMethod.POST)
	public @ResponseBody AreaCode newAreaCode(@RequestBody AreaCode newAreaCode) {
		return acrepository.save(newAreaCode);
	}
	
	//REST, update areacode by id
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody AreaCode editAreaCode(@RequestBody AreaCode editedAreaCode, @PathVariable("id") String areaCode) {
		editedAreaCode.setAreaCode(areaCode);
		return acrepository.save(editedAreaCode);
	}
	
	//rest, delete by id and show updated list of areacodes
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<AreaCode> deleteAreaCode(@PathVariable("id") String areaCode) {
		acrepository.deleteById(areaCode);
		return (List<AreaCode>) acrepository.findAll();
	}
	
	//Myyntitapahtuma
	
	// REST, get all sale events
	@RequestMapping(value = "/saleEvents", method = RequestMethod.GET)
	public @ResponseBody List<SaleEvent> saleEventListRest() {
		return(List<SaleEvent>) serepository.findAll();
	}
	
	// REST, get sale event by id
	@RequestMapping(value = "/saleEvent/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<SaleEvent> findsaleEventRest(@PathVariable("id") Long saleid) {
		return serepository.findById(saleid);
	}
	
	
	// REST, delete sale event by id
	@RequestMapping(value = "/saleEvent/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<SaleEvent> deleteSaleEvent(@PathVariable("id") Long saleid) {
		serepository.deleteById(saleid);
		return (List<SaleEvent>) serepository.findAll();
	}
	
	//REST, update sale event by id
	@RequestMapping(value = "/saleEvent/{id}", method = RequestMethod.PUT)
	public @ResponseBody SaleEvent editSaleEvent(@RequestBody SaleEvent editedSaleEvent, @PathVariable("id") Long saleid) {
		editedSaleEvent.setSaleid(saleid);
		return serepository.save(editedSaleEvent);
	}
	
	// REST, add new SaleEvent
	@RequestMapping(value = "saleEvents", method = RequestMethod.POST)
	public @ResponseBody SaleEvent newSaleEvent(@RequestBody SaleEvent saleevent) {
			return serepository.save(saleevent);
	}

	
	// Käyttäjät
	
	//REST, get all users
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<AppUser> UserListRest() {
		return(List<AppUser>) urepository.findAll();
	}
	
	// GET user by id
		@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<AppUser> findUserRest(@PathVariable("id") Long userid) {
			return urepository.findById(userid);
		}
		
		// REST, add new user
			@RequestMapping(value = "users", method = RequestMethod.POST)
			public @ResponseBody AppUser newAppUser(@Valid @RequestBody AppUser appuser) {
				return urepository.save(appuser);
			}
			
			//REST, update user
			@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
			public @ResponseBody AppUser editUser(@Valid @RequestBody AppUser editedUser, @PathVariable("id") Long userid) {
				editedUser.setUserid(userid);
				return urepository.save(editedUser);
			}
			
			//REST, delete by id user
			@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
			public @ResponseBody List<AppUser> deleteUser(@PathVariable("id") Long userid) {
				urepository.deleteById(userid);
				return (List<AppUser>) urepository.findAll();
			}

	// REST, get all ROLES
			@RequestMapping(value = "/roles", method = RequestMethod.GET)
			public @ResponseBody List<UserRole> UserRoleRest() {
				return(List<UserRole>) rrepository.findAll();
			}
			// GET role by id
			@RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
			public @ResponseBody Optional<UserRole> findRoleRest(@PathVariable("id") Long roleid) {
				return rrepository.findById(roleid);
			}
			
			// REST, add new role
				@RequestMapping(value = "roles", method = RequestMethod.POST)
				public @ResponseBody UserRole newUserRole(@RequestBody UserRole role) {
					return rrepository.save(role);
				}
	
	
}

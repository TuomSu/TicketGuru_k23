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
import koodivelhot.Ticketguru.Domain.AcceptableTicketTypes;
import koodivelhot.Ticketguru.Domain.AcceptableTicketTypesRepository;
import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.AreaCode;
import koodivelhot.Ticketguru.Domain.AreaCodeRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;
import koodivelhot.Ticketguru.Domain.PreSaleTicket;
import koodivelhot.Ticketguru.Domain.PreSaleTicketRepository;
import koodivelhot.Ticketguru.Domain.PrintedTicket;
import koodivelhot.Ticketguru.Domain.PrintedTicketRepository;
import koodivelhot.Ticketguru.Domain.SaleEvent;
import koodivelhot.Ticketguru.Domain.SaleEventRepository;
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
	private SaleEventRepository serepository;
	
	@Autowired
	AppUserRepository urepository;
	
	@Autowired
	UserRoleRepository rrepository;
	
	@Autowired
	PreSaleTicketRepository pstrepository;
	
	@Autowired
	TicketTypeRepository ttrepository;
	
	@Autowired
	AcceptableTicketTypesRepository attrepository;
	
	@Autowired
	PrintedTicketRepository prrepository;
	
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
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public @ResponseBody List<Event> eventListRest() {
		return(List<Event>) erepository.findAll();
	}
	
	// REST, get event by id
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
	@PreAuthorize("hasAuthority('ADMIN'")
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
	@RequestMapping(value = "/atickettypes/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<AcceptableTicketTypes> deleteAcceptableTicketTypes(@PathVariable("id") Long lineId) {
		attrepository.deleteById(lineId);
		return (List<AcceptableTicketTypes>) attrepository.findAll();
	}

	// REST, add new acceptable ticket type
	@RequestMapping(value = "/acceptabletickettypes", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Tapahtumaan hyväksyttävä lipputyyppi luotu")
	public @ResponseBody AcceptableTicketTypes newAcceptableTicketTypes(@RequestBody AcceptableTicketTypes newAcceptableTicketTypes) {
		return attrepository.save(newAcceptableTicketTypes);
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
	// Lipputyypit
	
	// REST, get all tickettypes
	@RequestMapping(value = "/tickettypes", method = RequestMethod.GET)
	public @ResponseBody List<TicketType> tickettypeListRest() {
		return(List<TicketType>) ttrepository.findAll();
	}
	
	// REST, get tickettype by id
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
	@RequestMapping(value = "/tickettypes", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Lipputyyppi luotu")
	public @ResponseBody TicketType newTicketType(@Valid @RequestBody TicketType newTicketType) {
		return ttrepository.save(newTicketType);
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
			Optional<PreSaleTicket> sale = pstrepository.findById(saleid);
		
		if (sale.isPresent()) {
			return serepository.findById(saleid);
		} else {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Myyntitapahtumaa ei löytynyt annetulla id:llä");
		}
	}
	
	// REST, delete sale event by id
	@RequestMapping(value = "/saleEvent/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<SaleEvent> deleteSaleEvent(@PathVariable("id") Long saleid) {
		Optional<SaleEvent> sale = serepository.findById(saleid);
		
		if (sale.isPresent()) {
			serepository.deleteById(saleid);
			return (List<SaleEvent>) serepository.findAll();
			
		} else {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Myyntitapahtumaa ei löytynyt annetulla id:llä");
		}
	}
	
	//REST, update sale event by id
	@RequestMapping(value = "/saleEvent/{id}", method = RequestMethod.PUT)
	public @ResponseBody SaleEvent editSaleEvent(@RequestBody SaleEvent editedSaleEvent, @PathVariable("id") Long saleid) {
		Optional<SaleEvent> sale = serepository.findById(saleid);
		
		if (sale.isPresent()) {
			editedSaleEvent.setSaleid(saleid);
			return serepository.save(editedSaleEvent);
			
		} else { // jos myyntitapahtumaa ei löydy annetulla id:llä, muokkaus ei ole mahdollista eikä synny uutta myyntitapahtumaa
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Myyntitapahtumaa ei löytynyt annetulla id:llä");
		}	
	}
	
	// REST, add new SaleEvent
	@RequestMapping(value = "saleEvents", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Myyntitapahtuma luotu")
	public @ResponseBody SaleEvent newSaleEvent(@RequestBody SaleEvent saleevent) {
			return serepository.save(saleevent);
	}
	
	// Ennakkoliput
	
	// REST, get all presale tickects
	@RequestMapping(value = "/presaletickets", method = RequestMethod.GET)
	public @ResponseBody List<PreSaleTicket> PreSaleTicketListRest() {
		return(List<PreSaleTicket>) pstrepository.findAll();
	}
		
	// REST, get presaleticket by id
	@RequestMapping(value = "/presaleticket/{id}", method = RequestMethod.GET)
	public @ResponseBody List<PreSaleTicket> findPreSaleTicketRest(@PathVariable("id") Long presaleticketid) {
		Optional<PreSaleTicket> presaleticket = pstrepository.findById(presaleticketid);
		
		if (presaleticket.isPresent()) {
			return pstrepository.findByPresaleticketid(presaleticketid);
		} else {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ennakkolippua ei löytynyt annetulla id:llä");
		}
	}
	
	// REST, delete presale ticket by id
	@RequestMapping(value = "/presaleticket/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<PreSaleTicket> deletePreSaleTicket(@PathVariable("id") Long presaleticketid) {
		Optional<PreSaleTicket> presaleticket = pstrepository.findById(presaleticketid);
		
		if (presaleticket.isPresent()) {
			pstrepository.deleteById(presaleticketid);
			return (List<PreSaleTicket>) pstrepository.findAll();
		} else {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ennakkolippua ei löytynyt annetulla id:llä");
		}
	}
	
	//REST, update presale ticket by id
	@RequestMapping(value = "/presaleticket/{id}", method = RequestMethod.PUT)
	public @ResponseBody PreSaleTicket editPreSaleticket(@Valid @RequestBody PreSaleTicket editedPreSaleTicket, @PathVariable("id") Long presaleticketid) {
		Optional<PreSaleTicket> presaleticket = pstrepository.findById(presaleticketid);
		
		if (presaleticket.isPresent()) {
			editedPreSaleTicket.setPresaleticketid(presaleticketid);
			return pstrepository.save(editedPreSaleTicket);
		} else { // jos ennakkolippua ei löydy annetulla id:llä ei muokkaus ole mahdollista eikä luoda uutta ennakkolippua
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ennakkolippua ei löytynyt annetulla id:llä");
		}
	}
	
	// REST, add new presale ticket
	@RequestMapping(value = "presaletickets", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Ennakkolippu luotu")
	public @ResponseBody PreSaleTicket newPreSaleTicket(@Valid @RequestBody PreSaleTicket presaleticket) {
			return pstrepository.save(presaleticket);
	}
	
	
	
	//PrintedTicket

		// REST, get all printed tickets
		@RequestMapping(value = "/printedtickets", method = RequestMethod.GET)
		public @ResponseBody List<PrintedTicket> PrintedTicketListRest() {
			return(List<PrintedTicket>) prrepository.findAll();
		}
		
	
		

		// REST, get printedticket by id
		@RequestMapping(value = "/printedticket/{id}", method = RequestMethod.GET)
		public @ResponseBody List<PrintedTicket> findPrintedTicketRest(@PathVariable("id") Long pTicketId) {
			Optional<PrintedTicket> printedticket = prrepository.findById(pTicketId);
			
			if(printedticket.isPresent()) {
				return prrepository.findBypTicketId(pTicketId);
			} else {
				throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "Tulostettua lippua ei löytynyt annetulla id:llä");
			}
		}
				
			
	

		// REST, delete sale event by id
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
			
			
			
		

		//REST, update sale event by id
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
		@RequestMapping(value = "printedtickets", method = RequestMethod.POST)
		@ResponseStatus(value = HttpStatus.CREATED, reason = "Tulostettu luotu")
		public @ResponseBody PrintedTicket newPrintedTicket(@Valid @RequestBody PrintedTicket printedticket) {
				return prrepository.save(printedticket);
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
			Optional<AppUser> user = urepository.findById(userid);
			if(user.isPresent()) {
				return urepository.findById(userid);
			}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Käyttäjää ei löytynyt annetulla id:llä");
			}
		}
		
		// REST, add new user
			@RequestMapping(value = "users", method = RequestMethod.POST)
			public @ResponseBody AppUser newAppUser(@Valid @RequestBody AppUser appuser) {
				return urepository.save(appuser);
			}
			
			//REST, update user
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
			@RequestMapping(value = "/roles", method = RequestMethod.GET)
			public @ResponseBody List<UserRole> UserRoleRest() {
				return(List<UserRole>) rrepository.findAll();
			}
			// GET role by id
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
				@RequestMapping(value = "roles", method = RequestMethod.POST)
				public @ResponseBody UserRole newUserRole(@RequestBody UserRole role) {
					return rrepository.save(role);
				}
	
	
}

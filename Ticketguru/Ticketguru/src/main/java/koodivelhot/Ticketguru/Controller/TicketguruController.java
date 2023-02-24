package koodivelhot.Ticketguru.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.PlaceOfEvent.Event;
import koodivelhot.Ticketguru.Domain.PlaceOfEvent.EventRepository;

@Controller
public class TicketguruController {
	
	//@Autowired
	EventRepository eventRepository;
	//@Autowired
	//AppUserRepository urepository;
	
	@GetMapping("testi")
	@ResponseBody
	public String doTest() {
		return "Test successful";
	}
	
	// REST, get all events
	// Ei vielä testattu, heittää jotain erroreita entiteetteihin liittyen käynnistäessä
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public @ResponseBody List<Event> eventListRest() {
		return(List<Event>) eventRepository.findAll();
	}
	
	// REST, get event by id
	//@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	//public @ResponseBody Event findEventRest(@PathVariable("id") Long event_id) {
		//return eventRepository.findById(event_id);
	//}
	
	// REST, add new event
	//@PostMapping("events")
	//public Event newEvent(@RequestBody Event newEvent) {
		//return eventRepository.save(newEvent);
	//}
	
	// REST, get all users
	
	//@RequestMapping(value = "/users", method = RequestMethod.GET)
	//public @ResponseBody List<AppUser> UserListRest() {
		//return(List<AppUser>) urepository.findAll();
	//}
	
}

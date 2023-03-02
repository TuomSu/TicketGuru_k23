package koodivelhot.Ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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


import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;

@Controller
public class TicketguruController {
	
	@Autowired
	private EventRepository erepository;
	//@Autowired
	//AppUserRepository urepository;
	
	@GetMapping("testi")
	@ResponseBody
	public String doTest() {
		return "Test successful";
	}
	
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
	
	// REST, get all users
	
	//@RequestMapping(value = "/users", method = RequestMethod.GET)
	//public @ResponseBody List<AppUser> UserListRest() {
		//return(List<AppUser>) urepository.findAll();
	//}
	
}

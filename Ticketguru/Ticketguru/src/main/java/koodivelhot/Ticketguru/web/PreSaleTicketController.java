package koodivelhot.Ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import koodivelhot.Ticketguru.Domain.PreSaleTicket;
import koodivelhot.Ticketguru.Domain.PreSaleTicketRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;

@RestController
public class PreSaleTicketController {
	
	@Autowired
	PreSaleTicketRepository pstrepository;
	
	@Autowired
	EventRepository erepository;
	
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
	
	// Get presaleticket by code => metodi ennakkolipun hakemiseen koodilla, koodi annetaan parametrina
	/*@GetMapping(value = "/presaletickets", params = {"code"})
	public PreSaleTicket findByCode(@RequestParam("code") String code) {
		PreSaleTicket presaleticket = pstrepository.findByCode(code);
		
		if (presaleticket == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Presaleticket with code" + code + "not found");
		}
		return presaleticket;
	}*/
	
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
	@RequestMapping(value = "presaletickets/{event_id}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Ennakkolippu luotu")
	public @ResponseBody PreSaleTicket newPreSaleTicket(@Valid @RequestBody PreSaleTicket newPresaleticket, @PathVariable("event_id") Long event_id) {
		
		Event event1 = erepository.findById(event_id)
				.orElseThrow(() -> new EntityNotFoundException("Event not found with id " + event_id));
		event1.setSoldTickets(event1.getSoldTickets() + 1);

		if (event1.getSoldTickets() <= event1.getTicketAmount()) {
			
			erepository.save(event1);
			
			return pstrepository.save(newPresaleticket);
			
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Tapahtuma " + event1.getEventName() + " on loppuunmyyty");	
		}
		
	}

}

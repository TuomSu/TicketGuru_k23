package koodivelhot.Ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.PreSaleTicket;
import koodivelhot.Ticketguru.Domain.PreSaleTicketRepository;
import koodivelhot.Ticketguru.Domain.SaleEvent;
import koodivelhot.Ticketguru.Domain.SaleEventRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;

@RestController
public class SaleEventController {
	
	@Autowired
	SaleEventRepository serepository;
	
	@Autowired
	PreSaleTicketRepository pstrepository;
	
	@Autowired
	AppUserRepository aurepository;
	
	@Autowired
	EventRepository erepository;
	
	
	
	//Myyntitapahtuma
	
		// REST, get all sale events
		@PreAuthorize("hasAnyAuthority('admin','basic')")
		@RequestMapping(value = "/saleEvents", method = RequestMethod.GET)
		public @ResponseBody List<SaleEvent> saleEventListRest() {
			return(List<SaleEvent>) serepository.findAll();
		}
		
		// REST, get sale event by id
		@PreAuthorize("hasAnyAuthority('admin','basic')")
		@RequestMapping(value = "/saleEvent/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<SaleEvent> findsaleEventRest(@PathVariable("id") Long saleid) {
				Optional<SaleEvent> sale = serepository.findById(saleid);
			
			if (sale.isPresent()) {
				return serepository.findById(saleid);
			} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Myyntitapahtumaa ei löytynyt annetulla id:llä");
			}
		}
		
		// REST, delete sale event by id
		@PreAuthorize("hasAuthority('admin')")
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
		@PreAuthorize("hasAuthority('admin')")
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
		@PreAuthorize("hasAnyAuthority('admin','basic')")
		@RequestMapping(value = "saleEvents", method = RequestMethod.POST)
		@ResponseStatus(value = HttpStatus.CREATED, reason = "Myyntitapahtuma luotu")
		public @ResponseBody SaleEvent newSaleEvent(@RequestBody SaleEvent saleevent) {
				return serepository.save(saleevent);
		}
		

}

package koodivelhot.Ticketguru.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;
import koodivelhot.Ticketguru.Domain.PreSaleTicket;
import koodivelhot.Ticketguru.Domain.PreSaleTicketRepository;
import koodivelhot.Ticketguru.Domain.SaleEvent;
import koodivelhot.Ticketguru.Domain.SaleEventRepository;
import koodivelhot.Ticketguru.Domain.TicketType;
import koodivelhot.Ticketguru.Domain.TicketTypeRepository;

@Controller //jouduin lisäämään uuden controllerin html-sivujen näyttämistä varten
public class ClientController {
	
	@Autowired
	PreSaleTicketRepository pstrepository;
	
	@Autowired
	SaleEventRepository serepository;
	
	@Autowired
	AppUserRepository aurepository;
	
	@Autowired
	EventRepository erepository;
	
	@Autowired
	TicketTypeRepository ttrepository;
	
	@Autowired
	AppUserRepository urepository;
		
	/*
	 * @RequestMapping(value = "/newSale") public String newSaleEvent(Model model){
	 * model.addAttribute("saleEvent", new SaleEvent()); model.addAttribute("user",
	 * aurepository.findAll()); model.addAttribute("ticket",
	 * pstrepository.findAll()); model.addAttribute("event", erepository.findAll());
	 * return "saleEvent"; }
	 */

	// Tapahtuma lista html
	@RequestMapping(value = { "/", "eventlist" })
	public String eventlist(Model model) {
		model.addAttribute("events", erepository.findAll());
		return "eventlist";
	}

	// Tapahtuman editointi html (vielä erittäin kesken)
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editEvent(@PathVariable("id") Long event_id, Model model) {
		model.addAttribute("event", erepository.findById(event_id));
		return "editevent";
	}
	
	// Show all presaletickets on ticketlist.html page
	@GetMapping("/ticketlist")
	public String showTickets(Model model) {
		model.addAttribute("tickets", pstrepository.findAll());
		return "ticketlist";
	}
	
	// Show createticket.html page
	@GetMapping("/createticket")
    public String showCreateForm(Model model) {
        model.addAttribute("presaleTicket", new PreSaleTicket());
        Iterable<Event> events = erepository.findAll();
        model.addAttribute("events", events);
        Iterable<TicketType> tickettypes = ttrepository.findAll();
        model.addAttribute("tickettypes", tickettypes);
        Iterable<SaleEvent> sales = serepository.findAll();
        model.addAttribute("sales", sales);
        return "createticket";
    }
	
	// Save new presaleticket
	@PostMapping("/saveticket")
	public String savePresaleTicket(@ModelAttribute("presaleTicket") PreSaleTicket presaleTicket) {
	    pstrepository.save(presaleTicket);
	    return "redirect:/ticketlist";
	}
	
	@GetMapping("/selltickets")
	public String sellTickets(Model model) {
	    Iterable<Event> events = erepository.findAll();
	    model.addAttribute("events", events);
	    Iterable<TicketType> tickettypes = ttrepository.findAll();
        model.addAttribute("tickettypes", tickettypes);
	    return "selltickets";
	}
	
	@PostMapping("/addpresaletickets")
	public String addPresaleTickets(@RequestParam("id") Long event_id, @RequestParam Map<String, String> ticketQuantities) {
		
		System.out.println("event_id = " + event_id);
	    System.out.println("ticket quantities = " + ticketQuantities);
	    
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    
	    String username = authentication.getName();
	    
	    AppUser curruser = urepository.findByUsername(username);
	    
	    System.out.println("Current user selling tickets: " + curruser);
	    
	    SaleEvent sale_event = new SaleEvent();
	    sale_event.setSaledate(LocalDateTime.now());
	    sale_event.setUser(curruser);
	    
	    serepository.save(sale_event);
	    
	    for (Map.Entry<String, String> entry : ticketQuantities.entrySet()) {
	        String key = entry.getKey();
	        String value = entry.getValue(); 

	        if (key.startsWith("quantities")) {
	          
	            Long ticketTypeId = Long.parseLong(key.substring(key.indexOf("[")+1, key.indexOf("]")));

	            Optional<TicketType> optionalTicketType = ttrepository.findById(ticketTypeId);

	            if (optionalTicketType.isPresent()) {
	                TicketType ticketType = optionalTicketType.get();

	                for (int i = 0; i < Integer.parseInt(value); i++) {
	                    PreSaleTicket preSaleTicket = new PreSaleTicket();
	                    Optional<Event> optionalEvent = erepository.findById(event_id);
	            	    
	            	    if (optionalEvent.isPresent()) {
	            	    	Event event = optionalEvent.get();
	            	    	preSaleTicket.setEvent(event);
	            	    	event.setSoldTickets(event.getSoldTickets() + 1);
	            	    }
	            	    
	                    preSaleTicket.setTickettype(ticketType);
	                    preSaleTicket.setUsed(false);
	                    preSaleTicket.setSale(sale_event);
	                    pstrepository.save(preSaleTicket);
	                }
	            }
	        }
	    }

	    return "redirect:/selltickets";
	}
	

}

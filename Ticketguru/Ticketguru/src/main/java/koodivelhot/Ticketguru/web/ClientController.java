package koodivelhot.Ticketguru.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import koodivelhot.Ticketguru.Domain.AreaCode;
import koodivelhot.Ticketguru.Domain.AreaCodeRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;
import koodivelhot.Ticketguru.Domain.PreSaleTicket;
import koodivelhot.Ticketguru.Domain.PreSaleTicketRepository;
import koodivelhot.Ticketguru.Domain.SaleEvent;
import koodivelhot.Ticketguru.Domain.SaleEventRepository;
import koodivelhot.Ticketguru.Domain.TicketType;
import koodivelhot.Ticketguru.Domain.TicketTypeRepository;
import koodivelhot.Ticketguru.Domain.Venue;
import koodivelhot.Ticketguru.Domain.VenueRepository;

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

	@Autowired
	VenueRepository vrepository;

	@Autowired
	AreaCodeRepository acrepository;
		
	/*
	 * @RequestMapping(value = "/newSale") public String newSaleEvent(Model model){
	 * model.addAttribute("saleEvent", new SaleEvent()); model.addAttribute("user",
	 * aurepository.findAll()); model.addAttribute("ticket",
	 * pstrepository.findAll()); model.addAttribute("event", erepository.findAll());
	 * return "saleEvent"; }
	 */

	// Tapahtuma lista html
	@PreAuthorize("hasAnyAuthority('admin','basic')")
	@RequestMapping(value = { "/", "eventlist" })
	public String eventlist(Model model) {
		model.addAttribute("events", erepository.findAll());
		return "eventlist";
	}

	// Tapahtuman editointi html
	@PreAuthorize("hasAnyAuthority('admin','basic')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editEvent(@PathVariable("id") Long event_id, Model model) {
		model.addAttribute("event", erepository.findById(event_id));
		model.addAttribute("venues", vrepository.findAll());
		model.addAttribute("areaCodes", acrepository.findAll());
		return "editevent";
	}
	
	// Lipputyyppien editointi html (erittäin kesken, eikä vielä toimi)
	@PreAuthorize("hasAnyAuthority('admin','basic')")
	@RequestMapping(value = "/atypes/{id}", method = RequestMethod.GET)
	public String editTicketTypes(@PathVariable("id") Long event_id, Model model) {
		model.addAttribute("event", erepository.findById(event_id));
		model.addAttribute("ticketTypes", ttrepository.findByEvent(erepository.findById(event_id).get()));
		// model.addAttribute("ticketTypes", ttrepository.findAll());
		model.addAttribute("ticketType", new TicketType());
		return "acceptabletypes";
	}

	// Tapahtuman lisäys html
	@PreAuthorize("hasAnyAuthority('admin','basic')")
	@RequestMapping(value = "/addEvent")
	public String addEvent(Model model) {
		model.addAttribute("event", new Event());
		model.addAttribute("venues", vrepository.findAll());
		model.addAttribute("areaCodes", acrepository.findAll());
		return "addevent";
	}

	@PreAuthorize("hasAnyAuthority('admin','basic')")
	@RequestMapping(value = "/newVenue")
	public String addVenue(Model model) {
		model.addAttribute("venue", new Venue());
		model.addAttribute("areaCodes", acrepository.findAll());
		return "addvenue";
	}

	@PreAuthorize("hasAnyAuthority('admin','basic')")
	@RequestMapping(value = "/newACode")
	public String addACode(Model model) {
		model.addAttribute("acode", new AreaCode());
		return "addacode";
	}

	@RequestMapping(value = "/saveType", method = RequestMethod.POST)
	public String save(TicketType type) {
		ttrepository.save(type);
		return "redirect:eventlist";
	}

	@RequestMapping(value = "/saveVenue", method = RequestMethod.POST)
	public String save(Venue venue) {
		vrepository.save(venue);
		return "redirect:addEvent";
	}

	@RequestMapping(value = "/saveACode", method = RequestMethod.POST)
	public String save(AreaCode areaCode) {
		acrepository.save(areaCode);
		return "redirect:newVenue";
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Event event) {
		erepository.save(event);
		return "redirect:eventlist";
	}

	// Show on ticketcheck.html page
	@GetMapping("/ticketcheck")
	public String showTickets(Model model) {
		model.addAttribute("tickets", pstrepository.findAll());
		return "ticketcheck";
	}
	
	// Show createticket.html page
	@PreAuthorize("hasAnyAuthority('admin','basic')")
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
	@PreAuthorize("hasAnyAuthority('admin','basic')")
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
	    
	    List<PreSaleTicket> preSaleTickets = new ArrayList<>();
	    
	    for (Map.Entry<String, String> entry : ticketQuantities.entrySet()) {
	        String key = entry.getKey();
	        String value = entry.getValue(); 

	        if (key.startsWith("quantities")) {
	          
	            Long ticketTypeId = Long.parseLong(key.substring(key.indexOf("[")+1, key.indexOf("]")));

	            Optional<TicketType> optionalTicketType = ttrepository.findById(ticketTypeId);

	            if (optionalTicketType.isPresent()) {
	                TicketType ticketType = optionalTicketType.get();
	                double price = ticketType.getPrice();
	                for (int i = 0; i < Integer.parseInt(value); i++) {
	                    PreSaleTicket preSaleTicket = new PreSaleTicket();
	                    Optional<Event> optionalEvent = erepository.findById(event_id);
	            	    
	            	    if (optionalEvent.isPresent()) {
	            	    	Event event = optionalEvent.get();
	            	    	preSaleTicket.setPrice(price);
	            	    	preSaleTicket.setEvent(event);
	            	    	event.setSoldTickets(event.getSoldTickets() + 1);
	            	    	sale_event.setTotalprice(sale_event.getTotalprice() + price);
	            	    }
	                    preSaleTicket.setTickettype(ticketType);
	                    preSaleTicket.setUsed(false);
	                    preSaleTicket.setSale(sale_event);
	                    preSaleTickets.add(preSaleTicket);
	                    pstrepository.save(preSaleTicket);
	                }
	            }
	        }
	    }
	    
	    sale_event.setPresaletickets(preSaleTickets);
	    
	    Long saleEventId = sale_event.getSaleid();
	    String saleEventUrl = "/saleevents/" + saleEventId;

	    return "redirect:" + saleEventUrl;
	}
	
	@GetMapping("/saleevents/{id}")
	public String viewSaleEvent(@PathVariable("id") Long id, Model model) {
	    Optional<SaleEvent> optionalSaleEvent = serepository.findById(id);

	    if (optionalSaleEvent.isPresent()) {
	        SaleEvent saleEvent = optionalSaleEvent.get();
	        model.addAttribute("saleEvent", saleEvent);
	        return "viewsaleevent";
	    } else {
	        return "redirect:/selltickets";
	    }
	}
	
	/* //Salesreport
	 @RequestMapping(value = "/salesreport")
	 public String getSalesreport () {
	 return "salesreport";
	 }*/
	 
	// Tapahtuman myyntitapahtumat html (vielä erittäin kesken)
		@PreAuthorize("hasAnyAuthority('admin','basic')")
		@RequestMapping(value = "/salesreport/{id}", method = RequestMethod.GET)
		public String getEventSalesReport(@PathVariable("id") Long event_id, Model model) {
			Optional<Event> optionalEvent = erepository.findById(event_id);
				if(optionalEvent.isPresent()) {
					Event event = optionalEvent.get();
			model.addAttribute("event", event);
			return "salesreport";
		}else {
			return "eventlist";
		}
		}
	
 
}

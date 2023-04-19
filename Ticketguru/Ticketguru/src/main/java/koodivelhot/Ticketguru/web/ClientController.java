package koodivelhot.Ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}

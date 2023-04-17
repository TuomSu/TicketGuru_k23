package koodivelhot.Ticketguru.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	EventRepository erepository;
	
	@Autowired
	TicketTypeRepository ttrepository;
	
	@Autowired
	SaleEventRepository serepository;
	
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

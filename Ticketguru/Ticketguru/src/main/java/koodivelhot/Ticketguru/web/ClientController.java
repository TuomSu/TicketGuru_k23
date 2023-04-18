package koodivelhot.Ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import koodivelhot.Ticketguru.Domain.PreSaleTicketRepository;
import koodivelhot.Ticketguru.Domain.SaleEvent;
import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.PreSaleTicket;
import koodivelhot.Ticketguru.Domain.SaleEventRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;

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
	
	// Show all presaletickets on ticketlist.html page
		@GetMapping("/ticketlist")
		public String showTickets(Model model) {
			model.addAttribute("tickets", pstrepository.findAll());
			return "ticketlist";
		}
		
		@RequestMapping(value = "/newSale")
	    public String newSaleEvent(Model model){
	    	model.addAttribute("saleEvent", new SaleEvent());
	    	model.addAttribute("user", aurepository.findAll());
	    	model.addAttribute("ticket", pstrepository.findAll());
	    	model.addAttribute("event", erepository.findAll());
	        return "saleEvent";
	    }

}

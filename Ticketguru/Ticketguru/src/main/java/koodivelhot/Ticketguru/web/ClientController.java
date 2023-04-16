package koodivelhot.Ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koodivelhot.Ticketguru.Domain.PreSaleTicketRepository;

@Controller //jouduin lisäämään uuden controllerin html-sivujen näyttämistä varten
public class ClientController {
	
	@Autowired
	PreSaleTicketRepository pstrepository;
	
	// Show all presaletickets on ticketlist.html page
		@GetMapping("/ticketlist")
		public String showTickets(Model model) {
			model.addAttribute("tickets", pstrepository.findAll());
			return "ticketlist";
		}

}

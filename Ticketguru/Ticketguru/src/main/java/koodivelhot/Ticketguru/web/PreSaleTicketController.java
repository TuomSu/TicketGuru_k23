package koodivelhot.Ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import koodivelhot.Ticketguru.Domain.PreSaleTicket;
import koodivelhot.Ticketguru.Domain.PreSaleTicketRepository;

@RestController
public class PreSaleTicketController {
	
	@Autowired
	PreSaleTicketRepository pstrepository;
	
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
	
	// Patch presaleticket
	@PatchMapping("/presaletickets")
	public PreSaleTicket usePreSaleTicket(@RequestParam("code") String code) {
		PreSaleTicket presaleticket = pstrepository.findByCode(code);
		
		if (presaleticket == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ennakkolippua ei löytynyt annetulla koodilla");
		} else if (presaleticket.getUsed() == true) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Lippu on jo käytetty");
		}
			presaleticket.setUsed(true);
			pstrepository.save(presaleticket);
			return presaleticket;
	}
	
	// REST, add new presale ticket
	@RequestMapping(value = "presaletickets", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Ennakkolippu luotu")
	public @ResponseBody PreSaleTicket newPreSaleTicket(@Valid @RequestBody PreSaleTicket presaleticket) {
			return pstrepository.save(presaleticket);
	}
	
	

}

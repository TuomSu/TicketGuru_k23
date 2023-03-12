package koodivelhot.Ticketguru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import koodivelhot.Ticketguru.Domain.AcceptableTicketTypes;
import koodivelhot.Ticketguru.Domain.AcceptableTicketTypesRepository;
import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.AreaCode;
import koodivelhot.Ticketguru.Domain.AreaCodeRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;
import koodivelhot.Ticketguru.Domain.PreSaleTicket;
import koodivelhot.Ticketguru.Domain.PreSaleTicketRepository;
import koodivelhot.Ticketguru.Domain.PrintedTicket;
import koodivelhot.Ticketguru.Domain.PrintedTicketRepository;
import koodivelhot.Ticketguru.Domain.SaleEvent;
import koodivelhot.Ticketguru.Domain.SaleEventRepository;
import koodivelhot.Ticketguru.Domain.TicketType;
import koodivelhot.Ticketguru.Domain.TicketTypeRepository;
import koodivelhot.Ticketguru.Domain.UserRole;
import koodivelhot.Ticketguru.Domain.UserRoleRepository;
import koodivelhot.Ticketguru.Domain.Venue;
import koodivelhot.Ticketguru.Domain.VenueRepository;

@SpringBootApplication
public class TicketguruApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TicketguruApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner ticketapplication(EventRepository erepository, VenueRepository vrepository, AreaCodeRepository acrepository, AppUserRepository userrepository, 
			UserRoleRepository rolerepository, SaleEventRepository salerepository, TicketTypeRepository ttrepository, AcceptableTicketTypesRepository attrepository, PreSaleTicketRepository pstrepository, PrintedTicketRepository prrepository) {
		return (args) -> {
			log.info("save an event");
			
			ttrepository.save(new TicketType(0.5, "Student"));
			ttrepository.save(new TicketType(0, "Child under 7"));
			
			acrepository.save(new AreaCode("00000", "Testikaupunki"));
			
			vrepository.save(new Venue("Testipaikka", "Testi", acrepository.findByAreaCode("00000").get(0)));
			
			erepository.save(new Event("Testitapahtuma", 10, "10/10/2023", vrepository.findByVenueName("Testipaikka").get(0)));
			erepository.save(new Event("Demotapahtuma"));
			
			attrepository.save(new AcceptableTicketTypes(ttrepository.findByType("Student").get(0), erepository.findByEventName("Testitapahtuma").get(0)));
			attrepository.save(new AcceptableTicketTypes(ttrepository.findByType("Child under 7").get(0), erepository.findByEventName("Testitapahtuma").get(0)));
				
			UserRole role1 = new UserRole("admin", "all rights");
			rolerepository.save(role1);
			
			AppUser user1 = new AppUser((rolerepository.findByRole("admin").get(0)),"Anna","Anttonen", "usernameAnna", "$2a$10$WDMEAdeX.N/M6oJnNpDyUO5szwepvUl6irlqJ/o5aRcZtth9Yfnom");
			userrepository.save(user1);
			
			SaleEvent sale1 = new SaleEvent(userrepository.findByUsername("usernameAnna").get(0));
			salerepository.save(sale1);
			
			pstrepository.save(new PreSaleTicket(false, 10, salerepository.findBySaleid(Long.valueOf(1)).get(0), erepository.findByEventName("Testitapahtuma").get(0), ttrepository.findByType("Student").get(0)));
			
			prrepository.save(new PrintedTicket(10.99, true, "10/10/2023", erepository.findByEventName("Testitapahtuma").get(0)));
			
			
			log.info("fetch demovent");
			for (Event event : erepository.findAll()) {
				log.info(event.toString());
			}
			for (AppUser appuser : userrepository.findAll()) {
				log.info(appuser.toString());
			}
			for (SaleEvent sale : salerepository.findAll()) {
				log.info(sale.toString());
			}
		};
		
	}

}
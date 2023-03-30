package koodivelhot.Ticketguru;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
			
			vrepository.save(new Venue("Testipaikka", "Testi", "Testikuja 2", acrepository.findByAreaCode("00000").get(0)));
			
			String startDate1 = "11.12.2023 12:00";
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
			LocalDateTime startDate = LocalDateTime.parse(startDate1, df);
			String endDate1 = "11.12.2023 23:00";
			LocalDateTime endDate = LocalDateTime.parse(endDate1, df);
			String preStart1 = "01.10.2023 01:00";
			LocalDateTime preStart = LocalDateTime.parse(preStart1, df);
			String preEnd1 = "10.12.2023 23:00";
			LocalDateTime preEnd = LocalDateTime.parse(preEnd1, df);
			erepository.save(new Event("Testitapahtuma", 10, startDate, endDate, 15.5, "Tapahtuma testaa tapahtuman toimintaa", preStart, preEnd, vrepository.findByVenueName("Testipaikka").get(0)));
			erepository.save(new Event("Demotapahtuma"));
			
			attrepository.save(new AcceptableTicketTypes(ttrepository.findByType("Student").get(0), erepository.findByEventName("Testitapahtuma").get(0)));
			attrepository.save(new AcceptableTicketTypes(ttrepository.findByType("Child under 7").get(0), erepository.findByEventName("Testitapahtuma").get(0)));
				
			UserRole role1 = new UserRole("admin", "all rights");
			rolerepository.save(role1);
			UserRole role2 = new UserRole("basic", "basic user rights");
			rolerepository.save(role2);
			
			AppUser user1 = new AppUser((rolerepository.findByRole("admin").get(0)),"Anna","Anttonen", "usernameAnna", "password");
			userrepository.save(user1);
			AppUser user2 = new AppUser(role2,"Matti","Testaaja", "usernameMatti", "password");
			userrepository.save(user2);

			
			String saledate1 = "13.03.2023 16:02";
			LocalDateTime saleDate = LocalDateTime.parse(saledate1, df); // jostain syystä päivämäärää ei muotoilla oikein?
			SaleEvent sale1 = new SaleEvent(saleDate, user1);
			salerepository.save(sale1);
			
			pstrepository.save(new PreSaleTicket(false, 10, salerepository.findBySaleid(Long.valueOf(1)).get(0), erepository.findByEventName("Testitapahtuma").get(0), ttrepository.findByType("Student").get(0)));
			
			prrepository.save(new PrintedTicket(10.99, true, "10/10/2023", erepository.findByEventName("Testitapahtuma").get(0)));
			
			/*// kommentoin nämä pois koska ei varmaan enää tarvita testausta varten?
			log.info("fetch demovent");
			for (Event event : erepository.findAll()) {
				log.info(event.toString());
			}
			for (AppUser appuser : userrepository.findAll()) {
				log.info(appuser.toString());
			}
			for (SaleEvent sale : salerepository.findAll()) {
				log.info(sale.toString());
			}*/
		};
		
	}

}
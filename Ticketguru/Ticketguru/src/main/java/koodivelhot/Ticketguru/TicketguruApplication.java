package koodivelhot.Ticketguru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import koodivelhot.Ticketguru.Domain.AreaCode;
import koodivelhot.Ticketguru.Domain.AreaCodeRepository;
import koodivelhot.Ticketguru.Domain.Event;
import koodivelhot.Ticketguru.Domain.EventRepository;
import koodivelhot.Ticketguru.Domain.Venue;
import koodivelhot.Ticketguru.Domain.VenueRepository;

@SpringBootApplication
public class TicketguruApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TicketguruApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner ticketapplication(EventRepository erepository, VenueRepository vrepository, AreaCodeRepository acrepository) {
		return (args) -> {
			log.info("save an event");
			
			acrepository.save(new AreaCode("00000"));
			
			vrepository.save(new Venue("Testipaikka", acrepository.findByAreaCode("00000").get(0)));
			
			erepository.save(new Event("Testitapahtuma", 10, vrepository.findByVenueName("Testipaikka").get(0)));
			erepository.save(new Event("Demotapahtuma"));
			
		
			
			
			log.info("fetch demovent");
			for (Event event : erepository.findAll()) {
				log.info(event.toString());
			}
		};
		
	}

}
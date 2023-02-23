package koodivelhot.Ticketguru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import koodivelhot.Ticketguru.Domain.PlaceOfEvent.EventRepository;
import koodivelhot.Ticketguru.Domain.PlaceOfEvent.Event;

@SpringBootApplication
public class TicketguruApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(TicketguruApplication.class);
	
	@Autowired
	EventRepository eventRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Creating demo data");
		log.info("Creating an event...");
		Event demo_event1 = new Event("Testitapahtuma", 1500);
		//eventRepository.save(demo_event1);
		log.info("Printing the demo event in console");
		log.info(demo_event1.toString());
	}

}

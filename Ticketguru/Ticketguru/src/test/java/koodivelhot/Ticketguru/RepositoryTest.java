package koodivelhot.Ticketguru;

import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


import org.junit.jupiter.api.Test;

import koodivelhot.Ticketguru.Domain.EventRepository;
import koodivelhot.Ticketguru.Domain.PreSaleTicket;
import koodivelhot.Ticketguru.Domain.PreSaleTicketRepository;
import koodivelhot.Ticketguru.Domain.PrintedTicket;
import koodivelhot.Ticketguru.Domain.PrintedTicketRepository;
import koodivelhot.Ticketguru.Domain.SaleEventRepository;
import koodivelhot.Ticketguru.Domain.TicketType;
import koodivelhot.Ticketguru.Domain.TicketTypeRepository;
import koodivelhot.Ticketguru.Domain.UserRoleRepository;
import koodivelhot.Ticketguru.Domain.Venue;
import koodivelhot.Ticketguru.Domain.VenueRepository;
import koodivelhot.Ticketguru.Domain.AppUser;
import koodivelhot.Ticketguru.Domain.AppUserRepository;
import koodivelhot.Ticketguru.Domain.AreaCode;
import koodivelhot.Ticketguru.Domain.AreaCodeRepository;
import koodivelhot.Ticketguru.Domain.Event;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RepositoryTest {
	
	@Autowired
	private EventRepository erepository;
	
	@Autowired
	private VenueRepository vrepository;
	
	@Autowired
	private PreSaleTicketRepository pstrepository;
	
	@Autowired
	private TicketTypeRepository ttrepository;
	
	@Autowired
	private AppUserRepository aprepository;
	
	@Autowired
	private UserRoleRepository	urrepository;
	
	@Autowired
	private AreaCodeRepository acrepository;
	
	@Autowired
	private SaleEventRepository salerepository;
	
	@Autowired
	private PrintedTicketRepository ptrepository;
	
	

	
	
						//Spring Boot - Testing
							//JPA Testing on a real database 

	@Test
	void contextLoads() {
	}
	
	
	
	// Event Testaukset
	@Test
	public void findByEventName() {
		List<Event> events = erepository.findByEventName("Testitapahtuma");
		assertThat(events).hasSize(1);
	}
	
	@Test
	public void createNewEvent() {
		
		String startDate1 = "11.12.2023 12:00";
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		LocalDateTime startDate = LocalDateTime.parse(startDate1, df);
		String endDate1 = "11.12.2023 23:00";
		LocalDateTime endDate = LocalDateTime.parse(endDate1, df);
		String preStart1 = "01.10.2023 01:00";
		LocalDateTime preStart = LocalDateTime.parse(preStart1, df);
		String preEnd1 = "10.12.2023 23:00";
		LocalDateTime preEnd = LocalDateTime.parse(preEnd1, df);
		
		Event event = new Event("JunitEvent", 30, startDate , endDate, 10.9,
				"Tapahtuma Junit testiä varten", preStart, preEnd, 
				vrepository.findByVenueName("Testipaikka").get(0));
		erepository.save(event);
		assertThat(event.getEvent_id()).isNotNull();
		
	}
	
	
	 
	@Test
	public void deleteNewEvent() {
		List<Event> events = erepository.findByEventName("JunitEvent");
		Event event = events.get(0);
		erepository.delete(event);
		List<Event> newEvents = erepository.findByEventName("JunitEvent");
		assertThat(newEvents).hasSize(0);
	}
	
	
	
	
	
	
	// Ticket Type testit.
	
	@Test
	public void findByTicketType() {
		List<TicketType> tickettypes = ttrepository.findByType("Student");
		assertThat(tickettypes).hasSize(1);
	}
	
	/*@Test
	public void createNewTicketType() {
		TicketType tickettype = new TicketType(0.5,"Eläkeläinen");
		ttrepository.save(tickettype);
		assertThat(tickettype.getType_id()).isNotNull();
		
	}*/
	
	@Test
	public void deleteTicketType() {
		List<TicketType> tickettypes = ttrepository.findByType("Child under 7");
		TicketType tickettype = tickettypes.get(0);
		ttrepository.delete(tickettype);
		List<TicketType> newTickettypes = ttrepository.findByType("Child under 7");
		assertThat(newTickettypes).hasSize(0);
	}
	
	
	
	
	
	
	
	// Yksikkötesti uuden käyttäjän luomiselle
		// Koska AppUser Repositryssä on List<AppUser> kommentoituna niin pitää uudella tavalla testata
	
	
	@Test
	public void findbyUsername() {
		AppUser appusers = aprepository.findByUsername("usernameMatti");
		assertThat(appusers.getUsername()).contains("usernameMatti");
		
	}
	
	@Test
	public void createNewUser() {
		AppUser appuser = new AppUser(urrepository.findByRole("basic").get(0),"Testi", "Testaaja", "käyttäjänimi", "salasana" );
		aprepository.save(appuser);
		assertThat(appuser.getUserid()).isNotNull();
		
	}
	
	@Test
	public void deleteNewUser() {
		AppUser appusers = aprepository.findByUsername("käyttäjänimi");
		aprepository.delete(appusers);
		AppUser newAppusers = aprepository.findByUsername("käyttäjänimi");
		assertThat(newAppusers).isNull();
		
	}
	
	
	
			//AreaCode Testaukset
	
	@Test
	public void findbyAreaCode() {
		List<AreaCode> areacodes = acrepository.findByAreaCode("00000");
		assertThat(areacodes).hasSize(1);
		
	}
	
	@Test
	public void createNewAreacode() {
		AreaCode areacode = new AreaCode("00700", "JunitKaupunki");
		acrepository.save(areacode);
		assertThat(areacode.getAreaCode()).isNotNull();
	}
	
	
	@Test
	public void deleteNewAreacode() {
		List<AreaCode> areacodes = acrepository.findByAreaCode("00700");
		AreaCode areacode = areacodes.get(0);
		acrepository.delete(areacode);
		List<AreaCode> newAreacodes = acrepository.findByAreaCode("00700");
		assertThat(newAreacodes).hasSize(0);
	}
	
	
				//Venue Testaukset
	
	@Test
	public void findbyvenue() {
		List<Venue> venues = vrepository.findByVenueName("Testipaikka");
		assertThat(venues).hasSize(1);
		}
	
	@Test
	public void createNewVenue() {
		Venue venue = new Venue("Junitpaikka", "Testi", "junitkatu",acrepository.findByAreaCode("00000").get(0) );
		vrepository.save(venue);
		assertThat(venue.getVenue_id()).isNotNull();
	}
	
	
	@Test
	public void deleteNewVeune() {
		List<Venue> venues= vrepository.findByVenueName("Junitpaikka");
		Venue venue = venues.get(0);
		vrepository.delete(venue);
		List<Venue> newVenues = vrepository.findByVenueName("Junitpaikka");
		assertThat(newVenues).hasSize(0);
	}
	
	
				//Presaleticket testaukset
	
	
	@Test
	public void findByPresaleticket() {
		List<PreSaleTicket> presaletickets = pstrepository.findByPresaleticketid(Long.valueOf(1));
		assertThat(presaletickets).hasSize(1);
	}
	
	@Test
	public void createNewPresaleticket() {
		PreSaleTicket presaleticket = new PreSaleTicket(false, 20, salerepository.findBySaleid(Long.valueOf(1)).get(0)
				, erepository.findByEventName("Testitapahtuma").get(0),ttrepository.findByType("Student").get(0) );
		pstrepository.save(presaleticket);
		assertThat(presaleticket.getPresaleticketid()).isNotNull();
	}
	
	
	@Test
	public void deleteNewPresaleticket() {
		List<PreSaleTicket> presaletickets= pstrepository.findByPresaleticketid(Long.valueOf(1));
		PreSaleTicket presaleticket = presaletickets.get(0);
		pstrepository.delete(presaleticket);
		List<PreSaleTicket> newpstickets = pstrepository.findByPresaleticketid(Long.valueOf(1));
		assertThat(newpstickets).hasSize(0);
	}
	
					//Printedticket test
	@Test
	public void findbyprintedTicket() {
		List<PrintedTicket> printedtickets = ptrepository.findBypTicketId(Long.valueOf(1));
		assertThat(printedtickets).hasSize(1);
	}
	
	@Test
	public void createNewPrintedticket() {
		PrintedTicket printedticket = new PrintedTicket(20.99, true,"10/10/2023", erepository.findByEventName("Testitapahtuma").get(0));
		ptrepository.save(printedticket);
		assertThat(printedticket.getpTicketId()).isNotNull();
	}
	
	@Test
	public void deleteNewPrintedticket() {
		List<PrintedTicket> printedtickets = ptrepository.findBypTicketId(Long.valueOf(2));
		PrintedTicket printedticket = printedtickets.get(0);
		ptrepository.delete(printedticket);
		List<PrintedTicket> newPrintedtickets = ptrepository.findBypTicketId(Long.valueOf(2));
		assertThat(newPrintedtickets).hasSize(0);
		
	}
	
	
	
}

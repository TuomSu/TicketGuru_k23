package koodivelhot.Ticketguru;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import koodivelhot.Ticketguru.Domain.EventRepository;
import koodivelhot.Ticketguru.Domain.Event;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventRepositoryTest {
	
	@Autowired
	private EventRepository erepository;
	
	@Test
    public void testFetchData() {	
		List<Event> events = erepository.findByEventName("Testitapahtuma");
		assertThat(events).hasSize(1);
		assertThat(events.get(0).getTicketAmount()).isEqualTo(10);
	}
	
    /*@Test
    public void createNewEvent() {
    	Event event = new Event("Testi2", 20);
    	erepository.save(event);
    	assertThat(event.getEvent_id()).isNotNull();
    }*/   
	
}

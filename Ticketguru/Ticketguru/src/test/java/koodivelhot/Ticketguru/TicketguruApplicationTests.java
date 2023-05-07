package koodivelhot.Ticketguru;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import koodivelhot.Ticketguru.web.ClientController;
import koodivelhot.Ticketguru.web.PreSaleTicketController;
import koodivelhot.Ticketguru.web.SaleEventController;
import koodivelhot.Ticketguru.web.TicketguruController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TicketguruApplicationTests {


	@Autowired
	private SaleEventController scontroller;
	
	@Autowired
	private PreSaleTicketController pscontroller;
	
	@Autowired
	private TicketguruController tcontroller;
	
	@Autowired
	private ClientController ccontroller;
	
	
					//Smoke testing
//testing the major functions of software before carrying out formal testing
		
	/**
	 * Testing that the context is creating your controller
	 */
	
	
	//SaleEventController
	@Test
	void contextLoadsSaleEvent()  throws Exception {
		assertThat(scontroller).isNotNull();
	}
	
	//PresaleticketController
	@Test
	void contextLoadsPreSale()  throws Exception {
		assertThat(pscontroller).isNotNull();
	}
	
	//TicketguruController
	@Test
	void contextLoadsTicketGuru()  throws Exception {
		assertThat(tcontroller).isNotNull();
	}
	

	//TicketguruController
	@Test
	void contextLoadsClient()  throws Exception {
		assertThat(ccontroller).isNotNull();
	}
}

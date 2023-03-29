package koodivelhot.Ticketguru.Domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;





@Entity
@Table (name= "printedticket")
public class PrintedTicket {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pTicketId;
	
	
	@Column (name = "ticketprice")
	@NotNull (message = "Price cannot be null") // hinta on pakollinen tieto, ilmaislipuille syötetään hinnaksi 0
	private Double ticketPrice;
	
	@NotNull
	@Column (name = "ticketsold")
	private Boolean ticketSold;
	
	@NotNull (message = "Printed ticket needs sold date")
	@Column (name = "datesold")
	private String dateSold;
	
	
	@NotNull (message = "Printed ticket needs event ")
	@ManyToOne
    @JoinColumn(name = "event_id")
	private Event event;
	
	
	
	
	public PrintedTicket () {
		super();
	}
	
	public PrintedTicket( Double ticketPrice, Boolean ticketSold, String dateSold, Event event) {
		
		this.ticketPrice = ticketPrice;
		this.ticketSold = ticketSold;
		this.dateSold = dateSold;
		this.event = event;
	}
	
	
	public Long getpTicketId() {
		return pTicketId;
	}
	public void setpTicketId(Long pTicketId) {
		this.pTicketId = pTicketId;
	}
	public Double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public Boolean getTicketSold() {
		return ticketSold;
	}
	public void setTicketSold(Boolean ticketSold) {
		this.ticketSold = ticketSold;
	}
	public String getDateSold() {
		return dateSold;
	}
	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	@Override
	public String toString() {
		return "PrintedTicket [pTicketId=" + pTicketId + ", ticketPrice=" + ticketPrice + ", ticketSold=" + ticketSold
				+ ", dateSold=" + dateSold + "]";
	}
	
}

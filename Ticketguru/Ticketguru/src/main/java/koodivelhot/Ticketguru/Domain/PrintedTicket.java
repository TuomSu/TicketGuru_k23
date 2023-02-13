package koodivelhot.Ticketguru.Domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;





@Entity
@Table (name= "printedticket")
public class PrintedTicket {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pTicketId;
	@Column (name = "ticketprice")
	private Double ticketPrice;
	@Column (name = "ticketsold")
	private Boolean ticketSold;
	@Column (name = "datesold")
	private LocalDate dateSold;
	
	
	public PrintedTicket () {
		super();
	}
	
	public PrintedTicket(Long pTicketId, Double ticketPrice, Boolean ticketSold, LocalDate dateSold) {
		this.pTicketId = pTicketId;
		this.ticketPrice = ticketPrice;
		this.ticketSold = ticketSold;
		this.dateSold = dateSold;
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
	public LocalDate getDateSold() {
		return dateSold;
	}
	public void setDateSold(LocalDate dateSold) {
		this.dateSold = dateSold;
	}
	
	@Override
	public String toString() {
		return "PrintedTicket [pTicketId=" + pTicketId + ", ticketPrice=" + ticketPrice + ", ticketSold=" + ticketSold
				+ ", dateSold=" + dateSold + "]";
	}
	
}

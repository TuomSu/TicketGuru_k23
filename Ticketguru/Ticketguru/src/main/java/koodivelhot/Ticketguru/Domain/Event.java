package koodivelhot.Ticketguru.Domain;


import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long event_id;
	private String eventName;
	
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private String eventStartDate;
	
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private Date eventEndDate;
	
	private int ticketAmount; //kuinka monta lippua myynnissä
	private double ticketPrice;
	private String description;
	
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private Date presaleStarts;
	
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private Date presaleEnds;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venue") // tapahtumapaikka. Kaupunki tulee tämän kautta.
    private Venue venue;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private List<AcceptableTicketTypes> aTicketTypes;
	
	//@JsonIgnore
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	//private List<PreSaleTicket> presaleTickets;
	
	/*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acceptableType")
    private AcceptableTicketTypes acceptableTypes;*/
	
	
	public Event() {}
	
	public Event(String eventName, int ticketAmount, String eventStartDate, Venue venue) {
		this.eventName = eventName;
		this.ticketAmount = ticketAmount;
		this.eventStartDate = eventStartDate;
		this.venue = venue;
	}

	/*public Event(String eventName, Date eventStartDate, Date eventEndDate, int ticketAmount, double ticketPrice, String description, Date presaleStarts, Date presaleEnds, Venue venue) {
		super();
		this.eventName = eventName;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.ticketAmount = ticketAmount;
		this.ticketPrice = ticketPrice;
		this.description = description;
		this.presaleStarts = presaleStarts;
		this.presaleEnds = presaleEnds;
		this.venue = venue;
		
	}*/

	public Event(String eventName) {
		this.eventName = eventName;
		// TODO Auto-generated constructor stub
	}

	public Long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventStartDate() {
		return eventStartDate;
	}
	
	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	
	public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public int getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(int ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPresaleStarts() {
		return presaleStarts;
	}

	public void setPresaleStarts(Date presaleStarts) {
		this.presaleStarts = presaleStarts;
	}

	public Date getPresaleEnds() {
		return presaleEnds;
	}

	public void setPresaleEnds(Date presaleEnds) {
		this.presaleEnds = presaleEnds;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public List<AcceptableTicketTypes> getaTicketTypes() {
		return aTicketTypes;
	}

	public void setaTicketTypes(List<AcceptableTicketTypes> aTicketTypes) {
		this.aTicketTypes = aTicketTypes;
	}
	
	

	/*public List<PrintedTicket> getPrintedTickets() {
		return printedTickets;
	}

	public void setPrintedTickets(List<PrintedTicket> printedTickets) {
		this.printedTickets = printedTickets;
	}

	public List<PreSaleTicket> getPresaleTickets() {
		return presaleTickets;
	}

	public void setPresaleTickets(List<PreSaleTicket> presaleTickets) {
		this.presaleTickets = presaleTickets;
	}

	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", ticketAmount=" + ticketAmount + "]";
	}*/
	
	

}
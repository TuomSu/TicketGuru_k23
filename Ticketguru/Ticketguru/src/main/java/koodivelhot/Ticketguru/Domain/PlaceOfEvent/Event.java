package koodivelhot.Ticketguru.Domain.PlaceOfEvent;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import koodivelhot.Ticketguru.Domain.PrintedTicket;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long event_id;
	private String eventName;
	private Date eventStartDate;
	private Date eventEndDate;
	private int ticketAmount; //kuinka monta lippua myynnissä
	private double ticketPrice;
	private String description;
	private Date presaleStarts;
	private Date presaleEnds;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venue") // tapahtumapaikka. Kaupunki tulee tämän kautta.
    private Venue venue;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private List<PrintedTicket> printedTickets;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acceptableType")
    private AcceptableTicketTypes acceptableTypes;
	
	
	public Event() {}

	public Event(String eventName, Date eventStartDate, Date eventEndDate, int ticketAmount, double ticketPrice, String description, Date presaleStarts, Date presaleEnds, Venue venue) {
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

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
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

	public List<PrintedTicket> getPrintedTickets() {
		return printedTickets;
	}

	public void setPrintedTickets(List<PrintedTicket> printedTickets) {
		this.printedTickets = printedTickets;
	}

	public AcceptableTicketTypes getAcceptableTypes() {
		return acceptableTypes;
	}

	public void setAcceptableTypes(AcceptableTicketTypes acceptableTypes) {
		this.acceptableTypes = acceptableTypes;
	}

}

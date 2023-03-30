package koodivelhot.Ticketguru.Domain;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.websocket.OnMessage;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long event_id;
	@NotBlank(message = "Event must have a name")
	public String eventName;
	
	//@Pattern(regexp = "^[0-31]{2}+.+[0-12]{2}+.+[0-9]{4}+ [0-24]{2}+:+[0-60]{2}+$", message = "not valid")
	@FutureOrPresent(message = "Given date must be in future")
	@JsonFormat(pattern = "dd.MM.yyyy HH:mm")
	//@NotNull(message = "Wrong date")
	private LocalDateTime eventStartDate;
	
	@JsonFormat(pattern = "dd.MM.yyyy HH:mm")
	private LocalDateTime eventEndDate;
	
	private int ticketAmount; //kuinka monta lippua myynnissä
	@NotNull(message = "Ticket must have a price. If ticket is free, price is 0")
	private double ticketPrice;
	private String description;
	
	@JsonFormat(pattern = "dd.MM.yyyy HH:mm")
	private LocalDateTime presaleStarts;
	
	@JsonFormat(pattern = "dd.MM.yyyy HH:mm")
	private LocalDateTime presaleEnds;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venue") // tapahtumapaikka. Kaupunki tulee tämän kautta.
    private Venue venue;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private List<AcceptableTicketTypes> aTicketTypes;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private List<PreSaleTicket> presaleTickets;
	
	
	public Event() {}
	
	public Event(String eventName, int ticketAmount) {
		this.eventName = eventName;
		this.ticketAmount = ticketAmount;
	}
	
	public Event(String eventName, int ticketAmount, LocalDateTime eventStartDate, LocalDateTime eventEndDate, double ticketPrice, String description, 
			LocalDateTime presaleStarts, LocalDateTime presaleEnds, Venue venue) {
		this.eventName = eventName;
		this.ticketAmount = ticketAmount;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.ticketPrice = ticketPrice;
		this.description = description;
		this.presaleStarts = presaleStarts;
		this.presaleEnds = presaleEnds;
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

	public LocalDateTime getEventStartDate() {
		return eventStartDate;
	}
	
	public void setEventStartDate(LocalDateTime eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	
	public LocalDateTime getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(LocalDateTime eventEndDate) {
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

	public LocalDateTime getPresaleStarts() {
		return presaleStarts;
	}

	public void setPresaleStarts(LocalDateTime presaleStarts) {
		this.presaleStarts = presaleStarts;
	}

	public LocalDateTime getPresaleEnds() {
		return presaleEnds;
	}

	public void setPresaleEnds(LocalDateTime presaleEnds) {
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
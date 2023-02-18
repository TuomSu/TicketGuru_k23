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

import koodivelhot.Ticketguru.Domain.TicketType;

@Entity
public class AcceptableTicketTypes {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long line_id;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "acceptableTypes")
	private List<TicketType> ticketTypes;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "acceptableTypes")
	private List<Event> events;
	
	public AcceptableTicketTypes() {}

	public AcceptableTicketTypes(Long line_id, List<TicketType> ticketTypes, List<Event> events) {
		super();
		this.line_id = line_id;
		this.ticketTypes = ticketTypes;
		this.events = events;
	}
	
	public Long getLine_id() {
		return line_id;
	}

	public void setLine_id(Long line_id) {
		this.line_id = line_id;
	}

	public List<TicketType> getTicketTypes() {
		return ticketTypes;
	}

	public void setTicketTypes(List<TicketType> ticketTypes) {
		this.ticketTypes = ticketTypes;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
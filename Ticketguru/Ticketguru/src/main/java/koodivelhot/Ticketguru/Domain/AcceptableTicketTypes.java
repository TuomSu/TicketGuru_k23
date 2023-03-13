package koodivelhot.Ticketguru.Domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class AcceptableTicketTypes {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long line_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticketType")
    private TicketType ticketType;
	
	@JsonIgnore //Tapahtumissa näkyy hyväksytyt lipputyypit, kun tämä tässä. Ilman ei näy.
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event")
    private Event event;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "acceptableTypes")
	private List<Event> events;*/
	
	public AcceptableTicketTypes() {}

	
	public AcceptableTicketTypes(TicketType ticketType, Event event) {
		super();
		this.ticketType = ticketType;
		this.event = event;
	}


	public Long getLine_id() {
		return line_id;
	}

	public void setLine_id(Long line_id) {
		this.line_id = line_id;
	}

	public TicketType getTicketType() {
		return ticketType;
	}


	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}
	
}
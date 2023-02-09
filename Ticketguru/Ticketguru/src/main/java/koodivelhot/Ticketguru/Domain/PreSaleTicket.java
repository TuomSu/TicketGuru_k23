package koodivelhot.Ticketguru.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import koodivelhot.Ticketguru.Domain.PlaceOfEvent.Event;

@Entity
public class PreSaleTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long presaleticketid;
	private Boolean used;
	
	@jakarta.persistence.ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
    @jakarta.persistence.JoinColumn(name = "saleid") // myyntitapahtuma, johon lippu liittyy
    private SaleEvent sale;
	
	@jakarta.persistence.ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
    @jakarta.persistence.JoinColumn(name = "event_id") // tapahtuma, johon lippu liittyy
    private Event event;
	
	// Lipputyyppi täytyy vielä lisätä 

	public PreSaleTicket(Long presaleticketid, Boolean used, SaleEvent sale, Event event) {
		super();
		this.presaleticketid = presaleticketid;
		this.used = used;
		this.sale = sale;
		this.event = event;
	}

	public Long getPresaleticketid() {
		return presaleticketid;
	}

	public void setPresaleticketid(Long presaleticketid) {
		this.presaleticketid = presaleticketid;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	public SaleEvent getSale() {
		return sale;
	}

	public void setSale(SaleEvent sale) {
		this.sale = sale;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
}

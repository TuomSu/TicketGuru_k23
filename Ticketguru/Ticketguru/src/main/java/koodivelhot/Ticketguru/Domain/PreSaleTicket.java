package koodivelhot.Ticketguru.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class PreSaleTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long presaleticketid;
	//private Boolean used;
	

	@ManyToOne
    @JoinColumn(name = "saleid") // myyntitapahtuma, johon lippu liittyy
    private SaleEvent sale;
	
	/*
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "event_id") // tapahtuma, johon lippu liittyy
    private Event event;
	
	/*@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "type_id") // lipputyyppi
	private TicketType type;*/
	
	public PreSaleTicket() {}

	public PreSaleTicket(Long presaleticketid, SaleEvent sale) {
		super();
		this.presaleticketid = presaleticketid;
		this.sale = sale;
	}

	public Long getPresaleticketid() {
		return presaleticketid;
	}

	public void setPresaleticketid(Long presaleticketid) {
		this.presaleticketid = presaleticketid;
	}

	/*public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}*/
	
	public SaleEvent getSale() {
		return sale;
	}

	public void setSale(SaleEvent sale) {
		this.sale = sale;
	}

	/*
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	/*public TicketType getType() {
		return type;
	}
	
	public void setType(TicketType type) {
		this.type = type;
	}*/
	
}

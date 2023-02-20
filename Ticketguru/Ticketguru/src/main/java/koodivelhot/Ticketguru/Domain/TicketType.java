package koodivelhot.Ticketguru.Domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import koodivelhot.Ticketguru.Domain.PlaceOfEvent.AcceptableTicketTypes;

@Entity
public class TicketType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long type_id;
	private double multiplier;
	private String type;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
	private List<PreSaleTicket> presaletickets;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acceptableTicketTypes")
    private AcceptableTicketTypes acceptableTypes;
	
	public TicketType() {
		super();
	}
	
	public TicketType(Long type_id, double multiplier, String type) {
		super();
		this.type_id = type_id;
		this.multiplier = multiplier;
		this.type = type;
	}
	
	public Long getType_id() {
		return type_id;
	}
	
	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
	
	public double getMultiplier() {
		return multiplier;
	}
	
	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	

}

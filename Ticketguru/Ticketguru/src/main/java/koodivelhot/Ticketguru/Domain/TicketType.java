package koodivelhot.Ticketguru.Domain;

import java.util.List;



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
import jakarta.validation.constraints.NotNull;

@Entity
public class TicketType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long type_id;
	@NotNull (message = "Tickettype must have a price")
	private double price;
	@NotNull (message = "Tickettype must have a type name")
	private String type;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tickettype")
	private List<PreSaleTicket> presaletickets;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketType")
	private List<AcceptableTicketTypes> aTicketTypes;
	
	public TicketType() {
		super();
	}
	
	public TicketType(double price, String type) {
		super();
		this.price = price;
		this.type = type;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getType_id() {
		return type_id;
	}
	
	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public List<AcceptableTicketTypes> getaTicketTypes() {
		return aTicketTypes;
	}

	public void setaTicketTypes(List<AcceptableTicketTypes> aTicketTypes) {
		this.aTicketTypes = aTicketTypes;
	}

	public List<PreSaleTicket> getPresaletickets() {
		return presaletickets;
	}

	public void setPresaletickets(List<PreSaleTicket> presaletickets) {
		this.presaletickets = presaletickets;
	}
	
	

}


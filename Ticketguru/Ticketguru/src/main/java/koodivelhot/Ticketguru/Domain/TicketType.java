package koodivelhot.Ticketguru.Domain;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class TicketType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long type_id;
	private double multiplier;
	private String type;
	
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

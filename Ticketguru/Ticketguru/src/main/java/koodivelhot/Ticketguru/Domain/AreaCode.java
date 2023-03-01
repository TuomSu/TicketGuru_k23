package koodivelhot.Ticketguru.Domain;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AreaCode {
	@Id
	private String areaCode; //postinumero. Ilmoitettu String, koska Integer ei salli 0 alkua
	private String city;
	
	/*@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "areaCode")
	private List<Venue> venues;*/
	
	public AreaCode() {}
	
	public AreaCode(String areaCode, String city) {
		super();
		this.areaCode = areaCode;
		this.city = city;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/*public List<Venue> getVenues() {
		return venues;
	}

	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}*/
	
}

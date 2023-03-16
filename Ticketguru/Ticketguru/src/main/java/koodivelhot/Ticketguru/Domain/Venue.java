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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Venue {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long venue_id;
	@NotBlank(message = "Venue must have a name")
	private String venueName;
	private String description;
	@NotBlank(message = "Venue must have an address")
	private String address;
	
	@NotNull(message = "Address must have an city and areacode")
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "areaCode")
    private AreaCode areaCode;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "venue")
	private List<Event> events;

	public Venue() {}
	
	public Venue(String venueName, String description, String address, AreaCode areaCode) {
		super();
		this.venueName = venueName;
		this.description = description;
		this.address = address;
		this.areaCode = areaCode;
	}

	public Long getVenue_id() {
		return venue_id;
	}

	public void setVenue_id(Long venue_id) {
		this.venue_id = venue_id;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AreaCode getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(AreaCode areaCode) {
		this.areaCode = areaCode;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
}

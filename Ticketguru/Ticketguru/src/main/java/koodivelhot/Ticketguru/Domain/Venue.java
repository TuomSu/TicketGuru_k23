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

@Entity
public class Venue {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long venue_id;
	private String venueName;
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "areaCode")
    private AreaCode areaCode;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "venue")
	private List<Event> events;

	public Venue() {}
	
	public Venue(String venueName, String description, AreaCode areaCode) {
		super();
		this.venueName = venueName;
		this.description = description;
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

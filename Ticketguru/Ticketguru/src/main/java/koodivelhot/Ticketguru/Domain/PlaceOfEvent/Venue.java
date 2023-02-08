package koodivelhot.Ticketguru.Domain.PlaceOfEvent;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	public Venue(Long venue_id, String venueName, String description, AreaCode areaCode) {
		super();
		this.venue_id = venue_id;
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

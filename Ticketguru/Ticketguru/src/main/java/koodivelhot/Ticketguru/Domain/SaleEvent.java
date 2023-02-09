package koodivelhot.Ticketguru.Domain;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import koodivelhot.Ticketguru.Domain.PlaceOfEvent.Venue;

@Entity
public class SaleEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long saleid;
	private Date saledate;
	private Time saletime;
	
	@jakarta.persistence.ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
    @jakarta.persistence.JoinColumn(name = "userid") // myyjä joka on tehnyt myyntitapahtuman
    private AppUser user;

	public SaleEvent(Long saleid, Date saledate, Time saletime, AppUser user) {
		super();
		this.saleid = saleid;
		this.saledate = saledate;
		this.saletime = saletime;
		this.user = user;
	}

	public Long getSaleid() {
		return saleid;
	}

	public void setSaleid(Long saleid) {
		this.saleid = saleid;
	}

	public Date getSaledate() {
		return saledate;
	}

	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}

	public Time getSaletime() {
		return saletime;
	}

	public void setSaletime(Time saletime) {
		this.saletime = saletime;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}
	
	
}

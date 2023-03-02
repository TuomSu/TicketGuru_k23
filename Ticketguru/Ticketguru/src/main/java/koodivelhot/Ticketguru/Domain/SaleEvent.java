package koodivelhot.Ticketguru.Domain;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SaleEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long saleid;
	//private Date saledate;
//	private Time saletime;
	
	/*@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "userid") // myyjä joka on tehnyt myyntitapahtuman
    private AppUser user;*/
	
	/*@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "presaleticketid")
	private List<PreSaleTicket> presaletickets;*/
	
	public SaleEvent() {}

	public SaleEvent(Date saledate, Time saletime, AppUser user) {
		super();
		//this.saledate = saledate;
		//this.saletime = saletime;
		//this.user = user;
	}

	public Long getSaleid() {
		return saleid;
	}

	public void setSaleid(Long saleid) {
		this.saleid = saleid;
	}

	/*public Date getSaledate() {
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
	}*/

	/*public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}*/
	
	
}

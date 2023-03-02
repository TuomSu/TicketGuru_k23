package koodivelhot.Ticketguru.Domain;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

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
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sale")
	private List<PreSaleTicket> presaletickets;
	
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

	public SaleEvent(Long saleid, List<PreSaleTicket> presaletickets) {
		super();
		this.saleid = saleid;
		this.presaletickets = presaletickets;
	}

	public void setSaleid(Long saleid) {
		this.saleid = saleid;
	}

	public List<PreSaleTicket> getPresaletickets() {
		return presaletickets;
	}

	public void setPresaletickets(List<PreSaleTicket> presaletickets) {
		this.presaletickets = presaletickets;
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

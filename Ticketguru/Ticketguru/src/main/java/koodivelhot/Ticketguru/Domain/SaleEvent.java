package koodivelhot.Ticketguru.Domain;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class SaleEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long saleid;
	
	@NotNull (message = "Sale event must have a saletime")
	private LocalDateTime saledate;
	
	//@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "userid") // myyjä joka on tehnyt myyntitapahtuman
	@NotNull (message = "Insert user, cannot be null")
	private AppUser user;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sale")
	private List<PreSaleTicket> presaletickets;
	
	public SaleEvent() {}
	
	public SaleEvent(LocalDateTime saledate, @NotNull(message = "Insert user, cannot be null") AppUser user) {
		super();
		this.saledate = saledate;
		this.user = user;
	}
	
	public SaleEvent(AppUser user) {
		super();
		this.user = user;
	}

	public Long getSaleid() {
		return saleid;
	}

	public void setSaleid(Long saleid) {
		this.saleid = saleid;
	}

	public LocalDateTime getSaledate() {
		return saledate;
	}

	public void setSaledate(LocalDateTime saledate) {
		this.saledate = saledate;
	}

	public List<PreSaleTicket> getPresaletickets() {
		return presaletickets;
	}

	public void setPresaletickets(List<PreSaleTicket> presaletickets) {
		this.presaletickets = presaletickets;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SaleEvent [saleid=" + saleid + ", user=" + user + "]";
	}
	
	
}

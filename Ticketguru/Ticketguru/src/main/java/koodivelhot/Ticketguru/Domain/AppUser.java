package koodivelhot.Ticketguru.Domain;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table (name = "appuser")
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	
	@ManyToOne
	@JoinColumn(name = "roleid")
	private UserRole role;
	
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "saleid")
	private List<SaleEvent> saleevents;
	
	public AppUser() {
		super();
	}

	/*
	public AppUser(Long userid, UserRole role, String firstName, String lastName, String username,
			String passwordHash) {
		super();
		this.userid = userid;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.passwordHash = passwordHash;
	}
*/

	
	public AppUser(UserRole role, String firstName, String lastName, String username, String passwordHash) {
		super();
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.passwordHash = passwordHash;
	}
	
	

	public Long getUserid() {
		return userid;
	}




	

	public void setUserid(Long userid) {
		this.userid = userid;
	}




	public UserRole getRole() {
		return role;
	}




	public void setRole(UserRole role) {
		this.role = role;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPasswordHash() {
		return passwordHash;
	}




	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}




	@Override
	public String toString() {
		return "AppUser [userid=" + userid + ", role=" + role + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", passwordHash=" + passwordHash + "]";
	}	
	
	
}

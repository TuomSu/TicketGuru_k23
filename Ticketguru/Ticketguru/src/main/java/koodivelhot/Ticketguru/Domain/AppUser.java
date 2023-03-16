package koodivelhot.Ticketguru.Domain;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table (name = "appuser")
public class AppUser {
	
	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "roleid")
	@NotNull (message = "Choose a role for the user, cannot be null")
	private UserRole role;
	
	@Column(name = "firstname")
	@NotNull (message = "Name cannot be null")
	private String firstName;
	@Column(name = "lastname")
	@NotNull (message = "Name cannot be null")
	private String lastName;
	@Column(name = "username", nullable = false, unique = true)
	@NotNull (message = "username cannot be null")
	private String username;
	
	@JsonIgnore
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
		setPasswordHash(passwordHash);
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
		this.passwordHash = PASSWORD_ENCODER.encode(passwordHash);
	}




	@Override
	public String toString() {
		return "AppUser [userid=" + userid + ", role=" + role + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", passwordHash=" + passwordHash + "]";
	}	
	
	
}

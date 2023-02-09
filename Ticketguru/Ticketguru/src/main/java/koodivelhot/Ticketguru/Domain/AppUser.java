package koodivelhot.Ticketguru.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "appuser")
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private Long roleid;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	
	
	public AppUser() {
		super();
	}


	public AppUser(Long roleid, String firstName, String lastName, String username, String passwordHash) {
		super();
		this.roleid = roleid;
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


	public Long getRoleid() {
		return roleid;
	}


	public void setRoleid(Long roleid) {
		this.roleid = roleid;
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
		return "AppUser [userid=" + userid + ", roleid=" + roleid + ", firstName=" + firstName + ", lastName="
				+ lastName + ", username=" + username + ", passwordHash=" + passwordHash + "]";
	}


	
	
	
	

}

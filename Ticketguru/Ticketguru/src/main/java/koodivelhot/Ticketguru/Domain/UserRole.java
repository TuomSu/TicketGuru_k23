package koodivelhot.Ticketguru.Domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table (name = "userrole")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleid;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	private List<AppUser> appusers;
	
	@Column(name = "role")
	private String role;
	@Column(name= "rights")
	private String rights;
	
	
	public UserRole() {
		super();
	}


	public UserRole(Long roleid, List<AppUser> appusers, String role, String rights) {
		super();
		this.roleid = roleid;
		this.appusers = appusers;
		this.role = role;
		this.rights = rights;
	}


	public Long getRoleid() {
		return roleid;
	}


	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}


	public List<AppUser> getAppusers() {
		return appusers;
	}


	public void setAppusers(List<AppUser> appusers) {
		this.appusers = appusers;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getRights() {
		return rights;
	}


	public void setRights(String rights) {
		this.rights = rights;
	}


	@Override
	public String toString() {
		return "UserRole [roleid=" + roleid + ", appusers=" + appusers + ", role=" + role + ", rights=" + rights + "]";
	}
	
	
	
	
	
	
}
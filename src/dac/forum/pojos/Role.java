package dac.forum.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_roles")
public class Role 
{
	
	@Id
	private String prn;
	private String role;
	
	public Role()
	{
		
	}

	public Role(String prn, String role)
	{
		super();
		this.prn = prn;
		this.role = role;
	}

	public String getPrn() {
		return prn;
	}

	public void setPrn(String prn) {
		this.prn = prn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [prn=" + prn + ", role=" + role + "]";
	}
	
	
	
	
	
}

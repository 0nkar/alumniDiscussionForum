package dac.forum.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class SearchAlumini
{
	private String firstname;
	private String lastname;
	
	public SearchAlumini()
	{
		
	}
	public SearchAlumini(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "SearchAlumini [firstname=" + firstname + ", lastname="
				+ lastname + "]";
	}
	
	
}

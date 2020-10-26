package dac.forum.pojos;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login implements Serializable {
	
	@Id
	@Column(name="USERNAME")
	private String prn;
	
	private String password;
	
	public Login() {
		
	}
	public Login(String user, String pass) {
		this.prn = user;
		this.password = pass;
	}
	public String getPrn() {
		return prn;
	}
	public void setPrn(String user) {
		this.prn = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	@Override
	public String toString() {
		return "Login [user=" + prn + ", pass=" + password + "]";
	}
}

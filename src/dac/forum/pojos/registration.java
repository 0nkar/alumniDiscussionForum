package dac.forum.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import javax.persistence.Transient;

import org.hibernate.annotations.ColumnTransformer;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="registration")
public class registration 
{
	
	@Id
	private String prn;
	private String password;
	private String firstname;
	private String lastname;
	private Date dob ;
	private String gender;
	private String emailID;
	private String mobileno;
	private String course;
	private String  passingYear;
	private String address;
	private String desgination;
	private String currentOrganisation;
	private String photoname;
	
	@Transient
	private MultipartFile file;
	
	
	public registration() 
	{
		
	}


	public registration(String prn, String password, String firstname,
			String lastname, Date dob, String gender, String emailID,
			String mobileno, String course, String passingYear, String address,
			String desgination, String currentOrganisation, String photoname,
			MultipartFile file) {
		super();
		this.prn = prn;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.gender = gender;
		this.emailID = emailID;
		this.mobileno = mobileno;
		this.course = course;
		this.passingYear = passingYear;
		this.address = address;
		this.desgination = desgination;
		this.currentOrganisation = currentOrganisation;
		this.photoname = photoname;
		this.file = file;
	}


	public String getPrn() {
		return prn;
	}


	public void setPrn(String prn) {
		this.prn = prn;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getPassingYear() {
		return passingYear;
	}


	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDesgination() {
		return desgination;
	}


	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}


	public String getCurrentOrganisation() {
		return currentOrganisation;
	}


	public void setCurrentOrganisation(String currentOrganisation) {
		this.currentOrganisation = currentOrganisation;
	}


	public String getPhotoname() {
		return photoname;
	}


	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


	@Override
	public String toString() 
	
	{
		
		return "registration [prn=" + prn + ", password=" + password
				+ ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dob=" + dob + ", gender=" + gender + ", emailID="
				+ emailID + ", mobileno=" + mobileno + ", course=" + course
				+ ", passingYear=" + passingYear + ", address=" + address
				+ ", desgination=" + desgination + ", currentOrganisation="
				+ currentOrganisation + ", Photoname=" + photoname + ", file="
				+ file + "]";
	}
	
	
	
}

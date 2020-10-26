package dac.forum.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="AdminPost")
public class AdminPost 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long postid;
	
	private String  prn;
	
	private String title;
	private String postbody;
	private String topic;
	private Date time;
	
	public AdminPost()
	{
		
	}

	public AdminPost(Long postid, String prn, String title, String postbody,
			String topic, Date time) 
	{
		super();
		this.postid = postid;
		this.prn = prn;
		this.title = title;
		this.postbody = postbody;
		this.topic = topic;
		this.time = time;
	}

	public Long getPostid() {
		return postid;
	}

	public void setPostid(Long postid) {
		this.postid = postid;
	}

	public String getPrn() {
		return prn;
	}

	public void setPrn(String prn) {
		this.prn = prn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostbody() {
		return postbody;
	}

	public void setPostbody(String postbody) {
		this.postbody = postbody;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "AdminPost [postid=" + postid + ", prn=" + prn + ", title="
				+ title + ", postbody=" + postbody + ", topic=" + topic
				+ ", time=" + time + "]";
	}
	
	
	
	
	
}

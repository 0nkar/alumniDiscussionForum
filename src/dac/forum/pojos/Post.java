package dac.forum.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="generaltalks")
public class Post 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long postid;
	
	private String  prn;
	
	private String title;
	private String postbody;
	private String topic;
	private Date time;
	
	public Post()
	{
		
	}

	public Post(Long postid, String prn, String title, String postbody,
			Date time) {
		super();
		this.postid = postid;
		this.prn = prn;
		this.title = title;
		this.postbody = postbody;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	
	@Override
	public String toString() {
		return "Post [postid=" + postid + ", prn=" + prn + ", title=" + title
				+ ", postbody=" + postbody + ", topic=" + topic + ", time="
				+ time + "]";
	}

	

	
	
}

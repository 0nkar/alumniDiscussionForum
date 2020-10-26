package dac.forum.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name="replygeneraltalks")
public class Reply 
{
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long replyid;
	    
		private String postid;
		
		private String message;
		
		
		public Reply()
		{
			
		}
		
		public Reply(Long replyid, String postid, String message) {
			super();
			this.replyid = replyid;
			this.postid = postid;
			this.message = message;
		}
		public Long getReplyid() {
			return replyid;
		}
		public void setReplyid(Long replyid) {
			this.replyid = replyid;
		}
		public String getPostid() {
			return postid;
		}
		public void setPostid(String postid) {
			this.postid = postid;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			return "Reply [replyid=" + replyid + ", postid=" + postid
					+ ", message=" + message + "]";
		}
		
		
		
}

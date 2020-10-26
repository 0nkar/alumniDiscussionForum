package dac.forum.daos;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;








import dac.forum.pojos.AdminPost;
import dac.forum.pojos.Post;
import dac.forum.pojos.Reply;
import dac.forum.pojos.registration;
@Transactional
@Repository
public class PostDao
{

	@Autowired
	private SessionFactory factory;
	private Session session;
	List list;;
	// open connection
	@PostConstruct
	public void open() throws Exception {
		session = factory.openSession();
	}
	// close connection
	@PreDestroy
	public void close() {
		if(session!=null)
			session.close();		
	}
	
	
	public List<Post> getPost(String topic)
	{
		Query query =  session.createQuery(" from dac.forum.pojos.Post p where p.topic=:p_topic");
			query.setString("p_topic", topic);
			List<Post> list =  query.list();	
			
		//System.out.println(""+list.get(0));
		//System.out.println(""+list.get(0).toString());
		
		//List<Post> list1=null;;
		return list;
	}
	
	
	public void replysave(Reply reply) throws Exception
	{	
		
				System.out.println(""+reply.toString());
			System.out.println("*********In Dao****************");
			session.save(reply);
			session.flush();
			
	}
	
	
	public List<Reply> getReply(String postid)
	{
		Query query =  session.createQuery(" from dac.forum.pojos.Reply r where r.postid=:p_postid");
		
				
			query.setString("p_postid", postid);
		
			List<Reply> list =  query.list();
		return list;
	}
	
	
	//add post to database
	
	
	public void savegeneralTalksPost(Post post) throws Exception
	{	
		System.out.println(""+post.toString());
			
			System.out.println("*********In Dao****************");
			session.save(post);
			session.flush();
			
	}
	
	
	
}

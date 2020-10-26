package dac.forum.daos;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dac.forum.pojos.SearchAlumini;
import dac.forum.pojos.registration;

@Transactional
@Repository
public class SearchDao
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
	
	
	public List<registration> getalumini(SearchAlumini alumini)
	{
		Query query =  session.createQuery(" from dac.forum.pojos.registration r where r.firstname=:p_fname and r.lastname=:p_lname ");
		
		System.out.println("In Dao");
		query.setString("p_fname", alumini.getFirstname());
		query.setString("p_lname", alumini.getLastname());
			List<registration> list =  query.list();	
			System.out.println("After Dao");
		//System.out.println(""+list.get(0));
		//System.out.println(""+list.get(0).toString());
			for (registration registration : list)
			{
				System.out.println(""+registration.toString());
			}
			
		//List<Post> list1=null;;
		return list;
	}
	
	public List<registration> fetchprofile(String Userprn)
	{
		Query query =  session.createQuery(" from dac.forum.pojos.registration r where r.prn=:p_prn ");
		
		System.out.println("In Dao");
		query.setString("p_prn", Userprn);
		
			List<registration> list =  query.list();	
			System.out.println("After Dao");
		//System.out.println(""+list.get(0));
		//System.out.println(""+list.get(0).toString());
			for (registration registration : list)
			{
				System.out.println(""+registration.toString());
			}
			
		//List<Post> list1=null;;
		return list;
	}
	
	public List<registration> fetchclass(String Userprn)
	{
		
		registration res = (registration) session.get(registration.class,Userprn );
		
		Query query =  session.createQuery(" from dac.forum.pojos.registration r where r.passingYear=:p_year ");
		
		System.out.println("In Dao");
		query.setString("p_year", res.getPassingYear());
		
			List<registration> list =  query.list();	
			System.out.println("After Dao");
		//System.out.println(""+list.get(0));
		//System.out.println(""+list.get(0).toString());
			for (registration registration : list)
			{
				System.out.println(""+registration.toString());
			}
			
		//List<Post> list1=null;;
		return list;
	}
	
	
}

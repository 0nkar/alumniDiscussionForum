package dac.forum.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dac.forum.daos.PostDao;
import dac.forum.daos.SearchDao;
import dac.forum.pojos.Post;
import dac.forum.pojos.SearchAlumini;
import dac.forum.pojos.registration;

@Service
public class SearchService 
{

	@Autowired
	private SearchDao dao;
	public List<registration> fetchalumini(SearchAlumini alumini) {
		try
		{
			System.out.println("In service");
			return dao.getalumini(alumini);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ArrayList<registration>();
	}
	
	
	public List<registration> fetchprofile(String fetchprofile) {
		try
		{
			System.out.println("In service");
			return dao.fetchprofile(fetchprofile);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ArrayList<registration>();
	}
	
	public List<registration> fetchclass(String fetchprofile) {
		try
		{
			System.out.println("In service");
			return dao.fetchclass(fetchprofile);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ArrayList<registration>();
	}
	
}

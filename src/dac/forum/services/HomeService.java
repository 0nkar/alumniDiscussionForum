package dac.forum.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService 
{
	@Autowired
	//private HomeDeo dao;
	
	
	public List<String> fetchPost() {
		try {
	//		return dao.getSubjects();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}

}

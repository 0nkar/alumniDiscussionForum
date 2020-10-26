package dac.forum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dac.forum.daos.LoginDao;
import dac.forum.pojos.Role;
import dac.forum.pojos. registration;
import dac.forum.pojos.Login;

@Service
public class LoginService {
	@Autowired
	private LoginDao dao;
	
	public void registration(registration registerUser) 
	{
		try
		{
			
			dao.registration(registerUser);
			
		} catch (Exception e) 
		{
			
			e.printStackTrace();
			
		}
	}
	
	public boolean validate(Login login) {
		boolean success = false;
		try {
			Login dbLogin = dao.find(login.getPrn());
			if(dbLogin!=null && dbLogin.getPassword().equals(login.getPassword()))
				success = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	
	public boolean getrole(String prn) {
		 Role role= dao.getrole( prn);
		 
		 if("admin".equals(role.getRole()))
		 {
			 return true;
		 }
		
			 return false;
		 
			
	}
}

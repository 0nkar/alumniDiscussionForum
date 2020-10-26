package dac.forum.daos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dac.forum.pojos.Login;
import dac.forum.pojos.Role;
import dac.forum.pojos.registration;

@Transactional
@Repository
public class LoginDao {
	@Autowired
	private SessionFactory factory;
	private Session session;
	// open connection
	@PostConstruct
	public void open() throws Exception
	{
		session = factory.openSession();
	}
	// close connection
	@PreDestroy
	public void close() 
	{
		if(session!=null)
		session.close();		
	}

	public Login find(String prn) throws Exception
	{
		Login login = (Login) session.get(Login.class, prn);
		//System.out.println(""+login.toString());
		return login;
	}
	
	public void registration(registration registerUser) throws Exception
	{	
		
				Login login = new Login(registerUser.getPrn(),registerUser.getPassword());
				Role role = new Role(registerUser.getPrn(), "ROLE_USER");
				
				
			System.out.println("*********In Dao****************");
			session.save(role);
			session.flush();
			
			session.save(registerUser);
			session.flush();
			
			session.save(login);
			session.flush();
			
	}
	
	public Role getrole(String prn)
	{
		Role role =(Role) session.get(Role.class, prn);
		
		return role;
		
	}
	
}



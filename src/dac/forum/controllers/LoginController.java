package dac.forum.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dac.forum.pojos.Login;
import dac.forum.pojos.registration;
import dac.forum.services.LoginService;

@Controller
public class LoginController 
{
	@Autowired
	private LoginService service;

	
	//private HomeService init_service;
	
	
	@RequestMapping("/showHome")
	public ModelAndView showHome(HttpSession session) {
		
	//	init_service();
		String Userprn= (String) session.getAttribute("prn") ;
		ModelAndView mav;
		 registration command = new  registration();
		 
		 if (Userprn!=null)
		 {
		mav = new ModelAndView("t_homel", "command", command);
		return mav;
		 }
		 else
		 {
			 mav = new ModelAndView("t_home", "command", command);
				return mav;
		 }
		
	}
	
	
	
	@RequestMapping("/register")
	public ModelAndView showRegister() {
		ModelAndView mav;
		registration command = new  registration();
		mav = new ModelAndView("t_register", "command", command);
		return mav;
	}

	@RequestMapping(value="/registrationUser", method = RequestMethod.POST )
					  
	public String registration(@ModelAttribute("registration") registration registerUser)
	{
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
	    String fileName=null;
	    
	   // MultipartFile filea = file;
	    //System.out.println(""+file.getOriginalFilename());
	    MultipartFile filea = registerUser.getFile();
			System.out.println(""+filea);
	    
	    if(null != filea ) 
		{
	    	//System.out.println("hi");
			fileName = filea.getOriginalFilename();
			//Handle file content - multipartFile.getInputStream()
			try {
				if (filea.getSize() > 0) {
					inputStream = filea.getInputStream();
					// File realUpload = new File("C:/");//Forum2/WebContent/WEB-INF/images
					outputStream = new FileOutputStream("C:\\Users\\Nil\\Desktop\\Forum\\WebContent\\resources\\theme\\images\\"
					+ filea.getOriginalFilename());
					System.out.println("====22=========");
					System.out.println(filea.getOriginalFilename());
					System.out.println("=============");
					int readBytes = 0;
					byte[] buffer = new byte[8192];
					while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
					System.out.println("===ddd=======");
					outputStream.write(buffer, 0, readBytes);
					}
					outputStream.close();
					inputStream.close();
					
}
			} catch (FileNotFoundException e)
			{
			
				e.printStackTrace();
			} catch (IOException e) 
			{
			
				e.printStackTrace();
			}		
		
			
			registerUser.setPhotoname(filea.getOriginalFilename());
				
}	
			
	    System.out.println(registerUser.toString());
		System.out.println(""+registerUser.getPhotoname());
		service.registration(registerUser);
		return "t_auth";
		
	}
	
	
	@RequestMapping("/showLogin")
	public ModelAndView showLogin() {
		ModelAndView mav;
		Login command = new Login();
		
		mav = new ModelAndView("t_login", "command", command);
		return mav;
	}
	
	
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "t_logout";
	}
	
	
	@RequestMapping("/validateLogin")
	public String validateLogin(Login login, HttpSession session,HttpServletRequest req) 
	{
		
		/*if(req.isUserInRole("ROLE_ADMIN"))
		{
			System.out.println("Admin is login");
	        	return "t_failed";
	        	
		}   	
		else
			System.out.println("User is login");
		return "t_home";*/
		
		
			
			session.setAttribute("prn", login.getPrn());
	
			if(service.validate(login))
			{
				session.setAttribute("prn", login.getPrn());
				if(service.getrole(login.getPrn()))
				{
					return"redirect:AdminshowHome";
				}
				
		
				return "t_validate"; 
			} else
			{
				return "t_failed";
			}
			
		
}

}


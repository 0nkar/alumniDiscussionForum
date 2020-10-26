package dac.forum.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dac.forum.pojos.postid;
import dac.forum.pojos.registration;
import dac.forum.services.SearchService;

@Controller
public class StaticPageController

{
	
	@Autowired
	SearchService service;
	
	@RequestMapping("/auth")
	public ModelAndView showAuth() {
		
	//	init_service();
		
		ModelAndView mav;
		 registration command = new  registration();
		 
		mav = new ModelAndView("t_auth", "command", command);
		return mav;
		
	}
	
	@RequestMapping("/siit")
	public ModelAndView showAbout(HttpSession session) {
		
	//	init_service();
		String Userprn= (String) session.getAttribute("prn") ;
		
		ModelAndView mav;
		 registration command = new  registration();
		 if (Userprn!=null)
		 {
		mav = new ModelAndView("t_siitl", "command", command);
		return mav;
		 }
		 else
		 {
			 mav = new ModelAndView("t_siit", "command", command);
				return mav;
		 }
		
	}
	
	@RequestMapping("/profile")
	public String showProfile(HttpSession session,Model model) {
		
		String Userprn= (String) session.getAttribute("prn") ;
		//System.out.println(""+Userprn);
		if( Userprn != null )
		{
			System.out.println(""+Userprn);
			
			List<registration> profile	= service.fetchprofile(Userprn);
			
			model.addAttribute("profile", profile);
			model.addAttribute("command", new registration());
			 
			return "t_profile";
		}
		else
		{
			return "t_auth";
		}	
	}
	
	@RequestMapping("/class")
	public String showClass(HttpSession session,Model model) 
	{
		String Userprn= (String) session.getAttribute("prn") ;
		//System.out.println(""+Userprn);
		if( Userprn != null )
		{
			System.out.println(""+Userprn);
			
			List<registration> profileclass	= service.fetchclass(Userprn);
			
			model.addAttribute("profileclass", profileclass);
			model.addAttribute("command", new registration());
			 
			return "t_class";
		}
		else
		{
			return "t_auth";
		}
			
	}

	@RequestMapping("/aim")
	public ModelAndView showAim(HttpSession session) {
		
	//	init_service();
		String Userprn= (String) session.getAttribute("prn") ;
		ModelAndView mav;
		 registration command = new  registration();
		 if (Userprn!=null)
		 {
		mav = new ModelAndView("t_aiml", "command", command);
		return mav;
		 }
		 else
		 {
			 mav = new ModelAndView("t_aim", "command", command);
				return mav;
		 }
		
	}
	
	@RequestMapping("/contact")
	public ModelAndView showContact(HttpSession session) {
		
	//	init_service();
		
		ModelAndView mav;
		 registration command = new  registration();
		 String Userprn= (String) session.getAttribute("prn") ;
		 if (Userprn!=null)
		 {
		mav = new ModelAndView("t_contactl", "command", command);
		return mav;
		 }
		 else
		 {
			 mav = new ModelAndView("t_contact", "command", command);
				return mav;
		 }
		
	}
	
	@RequestMapping("/rules")
	public ModelAndView showRules(HttpSession session) {
		
	//	init_service();
		String Userprn= (String) session.getAttribute("prn") ;
		ModelAndView mav;
		 registration command = new  registration();
		 
		 if (Userprn!=null)
		 {
		mav = new ModelAndView("t_rulesl", "command", command);
		return mav;
		 }
		 else
		 {
			 mav = new ModelAndView("t_rules", "command", command);
				return mav;
		 }
		
	}
	
	@RequestMapping("/searchAlumni")
	public ModelAndView showAlumni(HttpSession session) {
		
	//	init_service();
		String Userprn= (String) session.getAttribute("prn") ;
		ModelAndView mav;
		 registration command = new  registration();
		 
		 if (Userprn!=null)
		 {
		mav = new ModelAndView("t_searchAlumnil", "command", command);
		return mav;
		 }
		 else
		 {
			 mav = new ModelAndView("t_searchAlumni", "command", command);
				return mav;
		 }
		
	}
	
}

package dac.forum.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dac.forum.pojos.Post;
import dac.forum.pojos.SearchAlumini;
import dac.forum.pojos.postid;
import dac.forum.pojos.registration;
import dac.forum.services.SearchService;

@Controller
public class SearchController
{
	@Autowired
	SearchService service;
	
	@RequestMapping("/searchAlumini")
	public ModelAndView generalTalksPost(HttpSession session)
	{
		String Userprn= (String) session.getAttribute("prn") ;
		
		ModelAndView mav;
		 SearchAlumini command = new  SearchAlumini();
		 
		 if (Userprn!=null)
		 {
		mav = new ModelAndView("t_searchl", "command", command);
		return mav;
		 }
		 else
		 {
			 mav = new ModelAndView("t_search", "command", command);
				return mav;
		 }
		
						
	}
	
	
	@RequestMapping("/search")
	public String searchalumini(Model model,SearchAlumini alumini,HttpSession session)
	{
		String Userprn= (String) session.getAttribute("prn") ;
		System.out.println("hi");
		System.out.println(""+alumini.toString());
		 if (Userprn!=null)
		 {
		List<registration> aluminilist = service.fetchalumini(alumini);

		
		
	    //image proccessing
		
			
		model.addAttribute("aluminiList", aluminilist);
			model.addAttribute("command", new registration());
			
		
			return "t_showsearchl";

		
						
		 }
	
	else
		return "t_showsearch";
	}

}

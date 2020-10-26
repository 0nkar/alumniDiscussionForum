package dac.forum.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dac.forum.pojos.AdminPost;
import dac.forum.pojos.Login;
import dac.forum.pojos.Post;
import dac.forum.pojos.Reply;
import dac.forum.pojos.postid;
import dac.forum.pojos.registration;
import dac.forum.services.AdminService;
import dac.forum.services.LoginService;
import dac.forum.services.PostService;

@Controller
public class AdminController 
{
		
	
	@Autowired
	private AdminService service;
	final int QUEUE_CAPACITY = 100;
	ArrayList<AdminPost> list =  new ArrayList<AdminPost>(200) ;

	
	//private HomeService init_service;
	
	
		@RequestMapping("/AdminshowHome")
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
		
		
		
		@RequestMapping("/event")
		public String showPosts(Model model, AdminPost post)
		{
			
			System.out.println("@@@@@@@@@@@admin@@@@@@@@@@@@@@@");
		
			 list = (ArrayList<AdminPost>) service.fetchPosts("events");

	      for (AdminPost post1 : list)
	      {
			System.out.println(""+post1);
		  }					
	      
	      
			model.addAttribute("postList", list);
			model.addAttribute("command", new postid());
			
			
		
			return "t_adminevent";
		}
		
		
		@RequestMapping("/announcement")
		public String showjob(Model model, AdminPost post)
		{
			 list = (ArrayList<AdminPost>) service.fetchPosts("announcement");

	      for (AdminPost post1 : list) {
			System.out.println(""+post1);
		}					
			model.addAttribute("postList", list);
			model.addAttribute("command", new postid());
			
			
		
			return "t_adminevent";
		}
		
		
		
		@RequestMapping("/addevent")
		public ModelAndView generalTalksPost()
		{
			
			
			ModelAndView mav;
			 Post command = new  Post();
			 
			mav = new ModelAndView("t_adminpost", "command", command);
			return mav;
			
							
		}
		
		
		@RequestMapping("/postevents")
		public ModelAndView AddPosttodatabase(Model model,AdminPost post,HttpSession session)
		{
			
				
				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();
				
				
				
			post.setPrn((String)session.getAttribute("prn"));
			post.setTime(dateobj);	
			
			System.out.println(""+post.toString());
			
			service.savegeneralTalksPost(post);
			
			ModelAndView mav;
			 registration command = new  registration();
			 
			mav = new ModelAndView("t_home", "command", command);
			return mav;
			
		}
		
		
		
		@RequestMapping("/posteventsbody" )
		public String show(Model model, HttpServletRequest res,HttpSession session,AdminPost post)
		{
								
			AdminPost post1	= (AdminPost) session.getAttribute("sessionpost");
			System.out.println(""+post1);
			
			String id = res.getParameter("id");
				//String id=(String) res.getAttribute("id");
				
				System.out.println(""+id);
				
				
				
				
				//Vector<Post> v  = new Vector<Post>(list); 
				
			System.out.println(""+list.size());	
			
			int pid=(Integer.parseInt(id));
			int i=0;
			int k=0;
			for (AdminPost post11 : list) {
				//System.out.println(""+post1);
				
				if(post11.getPostid()==pid)
				{
					pid=i;
					System.out.println(""+pid);

					break;
				}
				i++;
				//System.out.println(""+i);
			}	
			
			AdminPost p = list.get(pid);
				//Post p = v.elementAt((Integer.parseInt(id)-1));
			
			System.out.println("hi");
			List<Reply> replylist = service.fetchReply(id);			
			model.addAttribute("replylist", replylist);
		
				
				
			model.addAttribute("post", p);	
			model.addAttribute("command", new Reply());	
			session.setAttribute("postid", id);
			//System.out.println(""+id);
			return "t_postbody";

		}
		
	
}

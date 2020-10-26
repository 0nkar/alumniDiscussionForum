package dac.forum.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.servlet.ModelAndView;

import dac.forum.daos.AdminDao;
import dac.forum.pojos.AdminPost;
import dac.forum.pojos.Post;
import dac.forum.pojos.Reply;
import dac.forum.pojos.postid;
import dac.forum.pojos.registration;
import dac.forum.services.AdminService;
import dac.forum.services.PostService;


@Controller

public class PostController {
	@Autowired
	private PostService service;
	
	@Autowired
	private AdminService adminservice;
	
	final int QUEUE_CAPACITY = 100;
	ArrayList<Post> list =  new ArrayList<Post>(200) ;
	ArrayList<AdminPost> list1 =  new ArrayList<AdminPost>(200) ;

	
	@RequestMapping("/generalTalks")
	public String showPosts(Model model, Post post)
	{
		
		 list = (ArrayList<Post>) service.fetchPosts("GeneralTalks");

      for (Post post1 : list) {
		System.out.println(""+post1);
	}					
		model.addAttribute("postList", list);
		model.addAttribute("command", new postid());
		
		
	
		return "t_generalTalks";
	}
	
	
	@RequestMapping("/job")
	public String showjob(Model model, Post post)
	{
		 list = (ArrayList<Post>) service.fetchPosts("Jobs");

      for (Post post1 : list) {
		System.out.println(""+post1);
	}					
		model.addAttribute("postList", list);
		model.addAttribute("command", new postid());
		
		
	
		return "t_generalTalks";
	}
	
	
	@RequestMapping("/science")
	public String showscience(Model model, Post post)
	{
		 list = (ArrayList<Post>) service.fetchPosts("Science");

      for (Post post1 : list) {
		System.out.println(""+post1);
	}					
		model.addAttribute("postList", list);
		model.addAttribute("command", new postid());
			
		return "t_generalTalks";
	}
	
	
	@RequestMapping("/uevent")
	public String showevent(Model model, AdminPost post)
	{
		 list1 = (ArrayList<AdminPost>) adminservice.fetchPosts("events");

      for (AdminPost post1 : list1) {
		System.out.println(""+post1);
	}					
		model.addAttribute("postList", list1);
		model.addAttribute("command", new postid());
			
		return "t_userTalks";
	}
	
	@RequestMapping("/uannouncement")
	public String showsannouncement(Model model, AdminPost post,HttpSession session)
	{
		
		String Userprn= (String) session.getAttribute("prn") ;
		if(Userprn!=null)
		{
		 list1 = (ArrayList<AdminPost>) adminservice.fetchPosts("announcement");

      for (AdminPost post1 : list1) {
		System.out.println(""+post1);
	}					
		model.addAttribute("postList", list1);
		model.addAttribute("command", new postid());
			
		return "t_userTalks";
	}
		else
		{
			return "t_logout";
		}
	}
	
	

	@RequestMapping("/generalTalksbody" )
	public String show(Model model, HttpServletRequest res,HttpSession session,Post post)
	{
		String Userprn= (String) session.getAttribute("prn") ;
		if(Userprn!=null)
		{
		Post post1	= (Post) session.getAttribute("sessionpost");
		System.out.println(""+post1);
		
		String id = res.getParameter("id");
			//String id=(String) res.getAttribute("id");
			
			System.out.println(""+id);
			
			
			
			
			//Vector<Post> v  = new Vector<Post>(list); 
			
		System.out.println(""+list.size());	
		
		int pid=(Integer.parseInt(id));
		int i=0;
		int k=0;
		for (Post post11 : list) {
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
		
		Post p = list.get(pid);
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
		else
		{
			return "t_logout";
		}
	}
	
	@RequestMapping("/reply")
	public ModelAndView reply(Reply reply,HttpSession session)
	{

		reply.setPostid((String)session.getAttribute("postid"));
			
		service.savereply(reply);
		
		ModelAndView mav;
		 registration command = new  registration();
		 
		mav = new ModelAndView("t_home", "command", command);
		return mav;
		
	}

		
	
	@RequestMapping("/viewPost")
	public ModelAndView generalTalksPost()
	{
		
		
		ModelAndView mav;
		 Post command = new  Post();
		 
		mav = new ModelAndView("t_post", "command", command);
		return mav;
		
						
	}
	
	
	
	//to add post to database
	
	@RequestMapping("/postgeneralTalks")
	public ModelAndView AddPosttodatabase(Model model,Post post,HttpSession session)
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
	
}


package dac.forum.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dac.forum.daos.AdminDao;
import dac.forum.daos.PostDao;
import dac.forum.pojos.AdminPost;
import dac.forum.pojos.Post;
import dac.forum.pojos.Reply;


@Service
public class AdminService 
{
	@Autowired
	private AdminDao dao;
	public List<AdminPost> fetchPosts(String topic) {
		try
		{
			return dao.getPost(topic);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ArrayList<AdminPost>();
	}
	
	
	public void savereply(Reply reply) {
		try
		{
			dao.replysave(reply);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	//add post to database
	public void savegeneralTalksPost(AdminPost post) {
		try
		{
			dao.savegeneralTalksPost(post);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public List<Reply> fetchReply(String postid) {
		try
		{
			return dao.getReply(postid);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ArrayList<Reply>();
	}
	
}

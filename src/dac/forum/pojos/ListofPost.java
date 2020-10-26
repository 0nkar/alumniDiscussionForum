package dac.forum.pojos;

import java.util.Arrays;

public class ListofPost
{
	private String[] posts;
	
		public ListofPost()
		{
			this.posts= new String[0];
		}
	

	public String[] getPosts() {
		return posts;
	}

	public void setPosts(String[] posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "ListofPost [posts=" + Arrays.toString(posts) + "]";
	}

		
	
	
}

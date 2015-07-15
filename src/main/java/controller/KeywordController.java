package controller;


import java.util.Set;

import model.twitter.entities.Keyword;
import model.twitter.entities.Tweet;

public class KeywordController {
	
	 
	public KeywordController()
	{
		
	}
	
		public  Keyword createKeyword(String key_name,Set<Tweet> tweets)
		{
	      Keyword keyword=new Keyword();
	      keyword.setKeyName(key_name);
	      
	      keyword.setTweet(tweets);
	   	   
	   return keyword;
		}
		
		


	   
}

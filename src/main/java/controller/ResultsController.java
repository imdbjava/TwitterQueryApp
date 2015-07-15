package controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import javafx.util.Pair;
import main.RunQuery;
import model.service.QueryResultService;
import model.twitter.entities.Hashtag;
import model.twitter.entities.Tweet;
import model.twitter.entities.Url;
import model.twitter.entities.User;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class ResultsController {

	private Twitter twitter;
	
	private QueryResultService queryResultsService;

	private User user;
	private Set<Hashtag> hashtags;
	private Set<Url> urls;
	private Tweet tweet;
	private Set<Tweet> tweets;

	private UrlController urlController;
	private UserController userController;
	private HashtagController hashtagController;
	private KeywordController keywordController;
	private TweetController tweetController;
		
	private final Logger logger = Logger.getLogger(this.getClass());

	
	// give authentication information for twitter API
	public  ResultsController() 
	{
		
		twitter = RunQuery.tcb.getTwitter();	
	
       hashtags=new HashSet<Hashtag>(0);
       tweets=new HashSet<Tweet>();
	   keywordController=new KeywordController();
	   urlController=new UrlController();
	   userController=new UserController(); 
	   tweetController=new TweetController();
	   hashtagController=new HashtagController();
	  
	   queryResultsService= new QueryResultService();
	   

	}


	
	
	public void parse(Pair<String, QueryResult> pair)
	{
        List<Status> tweets = pair.getValue().getTweets();
        
            this.save(pair.getKey(),tweets);

	}

	
	public  void save(String key, List<Status> statuses)
	{

		for(Status status:statuses)
		{
	    
		tweet=tweetController.createTweet(status);	
		
	    if(status.getURLEntities().length>0)
	    {
	    urls=urlController.createUrls(status.getURLEntities());
	    tweet.setUrls(urls);
	    }
	    
	    if(status.getHashtagEntities().length>0)
	    {
	    hashtags=hashtagController.createHashtags(status.getHashtagEntities());
	    tweet.setHashtags(hashtags);
	    }

	   user=userController.createUser(status);
	   tweet.setUser(user);
	   
	   tweets.add(tweet);
	   

		}
		
		   queryResultsService.insertResults(keywordController.createKeyword(key, tweets));

	   

	}
// This is a method to search in twitter, the number of return tweets is set to 10 ; 
	public QueryResult search(String key)
	{
		
		Query query;
        QueryResult result=null;
	try {
             query = new Query(key);
             query.setCount(10);
            result = twitter.search(query);
        } 
	catch (TwitterException te) {
            logger.info("Fehler1 beim Abfrage: " + te.getMessage());
        }
	catch (NullPointerException e)
	{
		logger.info("NullPointerException beim Abfrage: " + e.getMessage());

	}
	
    return result;

	}
	


	
	//////////////
	

}

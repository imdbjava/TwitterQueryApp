package controller;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import twitter4j.Status;
import main.RunQuery;
import model.twitter.entities.Tweet;

public class TweetController {

	
	private EntityManager em;
	
	public Tweet findTweet(Long tweetId)
	{
		em=RunQuery.emf.createEntityManager();
		Tweet tweet=null;
		try{
			 tweet = (Tweet) em.createQuery("SELECT t FROM Tweet t where t.tweetId = :value1")
	                .setParameter("value1", tweetId).getSingleResult();
		}
		catch(NoResultException nr)
		{
		}
		em.close();
		return tweet;
	}

	public Tweet createTweet(Status status) {
		
		Tweet tweet=new Tweet();
	    tweet.setTweetId(status.getId());
	    tweet.setCreatedAt(status.getCreatedAt());
	    tweet.setTweetText(status.getText());
	    tweet.setLanguageCode(status.getLang());

	    return tweet;
	}

	
}

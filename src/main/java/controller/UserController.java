package controller;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import twitter4j.Status;
import main.RunQuery;
import model.twitter.entities.User;

public class UserController {

	
	
	private User newUser;
	private EntityManager em;
	
	public UserController() {

	}
	public  User createUser(Status tweet)
	{

		   newUser=new User();
		   newUser.setUserId(tweet.getUser().getId());
		   newUser.setScreenName(tweet.getUser().getScreenName() );
		   newUser.setStatusesCount(tweet.getUser().getStatusesCount() );
		   newUser.setProfileImageUrl(tweet.getUser().getProfileImageURL() );
		   
		   return newUser;

	}
	
	public  User findUser(Long userID)
	{
		User user=null;
		em=RunQuery.emf.createEntityManager();

		try{
			 user = (User) em.createQuery("SELECT u FROM User u where u.userId = :value1")
	                .setParameter("value1", userID).getSingleResult();
		}
		catch(NoResultException nr)
		{
		}
		em.close();
		return user;
	}


	
	
	
}

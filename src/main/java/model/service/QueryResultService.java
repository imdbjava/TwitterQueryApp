package model.service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import main.RunQuery;
import model.twitter.entities.Keyword;

public class QueryResultService{
	

	private final Logger logger = Logger.getLogger(this.getClass());

	private EntityManager em;
	

	public QueryResultService()
	{
	}

	public  void insertResults(Keyword result) throws HibernateException {
		
		// check if key exists
		 try{
		em=RunQuery.emf.createEntityManager();
		
		em.getTransaction().begin();
				
		em.persist(result);

        em.getTransaction().commit();
	       
		 }
		 catch(PersistenceException ce)
		 {
			 logger.info("Exception was caugth at "+ce.toString());
		 }
	}
	


	
}

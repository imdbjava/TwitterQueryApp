package main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import config.TwitterConfigurationBuilder;
import javafx.util.Pair;
import twitter4j.QueryResult;

public class RunQuery {

    public final static EntityManagerFactory emf=Persistence.createEntityManagerFactory("mypu");
    
    public static  TwitterConfigurationBuilder tcb;
	
	public static void main(String[] args) throws Exception
	
	{
		
        
		
		// LinkedBlockingQueue is selected because it is unbounded and therefore 
		// producer should not wait for the consumer.
		BlockingQueue<Pair<String, QueryResult>> tweetBuffer=new LinkedBlockingQueue<Pair<String,QueryResult>>();
		
		// authentication information
		tcb = new TwitterConfigurationBuilder("",
				"",
				"",
				"");
		
		String[] keywords = new String[]{"Adidas", "Asics","Converse", "Erima","Jako","Nike","Puma", "Reebok"};
		
	    // Creating Producer and Consumer Thread

	    Runnable producerThread = new TwitterStreamProducer("producer",tweetBuffer,keywords);
	    Runnable consumerThread = new TwitterStreamConsumer("consumer",tweetBuffer);
	    
	   Thread producer=new Thread(producerThread);
	   Thread consumer=new Thread(consumerThread);
	   
	   producer.start();  

	    consumer.start();
	    

	}
	
}


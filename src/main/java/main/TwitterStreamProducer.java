package main;

import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import controller.ResultsController;
import javafx.util.Pair;
import twitter4j.QueryResult;

public class TwitterStreamProducer implements Runnable{

	private final BlockingQueue<Pair<String, QueryResult>> tweetBuffer;
	private final ResultsController resultsController;
	private String[] keywords;
	private String name;
	private boolean stopped;

	private final Logger logger = Logger.getLogger(this.getClass());

	
	public TwitterStreamProducer(String name,
			BlockingQueue<Pair<String, QueryResult>> tweetBuffer, String[] keywords) {
					
		this.tweetBuffer=tweetBuffer;
		this.resultsController=new ResultsController();
		this.keywords=keywords;
		this.name=name;
		this.stopped=false;
		

		
	}

    public void stop() {
        stopped = true;
    }

    
	public void run() {
		
	// Of course we can implement this method with while(true) condition, if we want to get streams forever!
		// in this case the logic of method could be much more easier.
		
		if (stopped)
			Thread.currentThread().interrupt();
		
		
		for(String key:keywords)
		{
		try {
			QueryResult result=resultsController.search(key);

			this.tweetBuffer.put( new Pair<String,QueryResult>(key,result) );
			
            Thread.sleep(200);

			   
            logger.info("Producer added one item to  queue");
			
			// end of streaming, pulsing the consumer to also stop the thread!
			if(key.equals(keywords[keywords.length-1]) )
			{
				this.tweetBuffer.put(new Pair<String, QueryResult>("EXIT!",result));
				logger.info("Finished producing tweets");
				this.stop();
				
			}
		}
		
		catch (InterruptedException e) {
			   logger.info( this.name+ " Interrupted "+e.toString() );
		        Thread.currentThread().interrupt();
			}


		}
		
		
	}

	
}

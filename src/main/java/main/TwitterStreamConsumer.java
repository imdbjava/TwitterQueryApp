package main;

import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import controller.ResultsController;
import javafx.util.Pair;
import twitter4j.QueryResult;

public class TwitterStreamConsumer  implements Runnable{

    private final BlockingQueue<Pair<String, QueryResult>> tweetBuffer;
    private final ResultsController resultsController;
    private Pair<String,QueryResult> result;
    private String name=null;
    private boolean stopped;
    
	private final Logger logger = Logger.getLogger(this.getClass());

	

    public TwitterStreamConsumer(String name, BlockingQueue<Pair<String, QueryResult>> tweetBuffer) {
    	
        this.name=name;
        this.tweetBuffer=tweetBuffer;
        this.resultsController=new ResultsController();

        
    }

    public void stop() {
        stopped = true;
    }

    public void run() {
        stopped = false;


        while(! stopped) {
            try {
            	
            	
            	result=this.tweetBuffer.take();
            	
            	// it the queue is not empty 
            	if(! result.getKey().toString().equalsIgnoreCase("EXIT!"))
            	{
                resultsController.parse(result);
                    logger.info("consumer consummed one item");
				
            	}
            	else
            	{
            		logger.info("consumer consumed all the tweets");
            		this.stop();
            	}
          
            }           
         catch(NullPointerException e)
            {
        	 logger.info(this.name+ " Null pointer exception in Consumer class "+e.getMessage());

            }
            catch (InterruptedException e) {
            	logger.info(this.name+ " interrupted "+e.getMessage());
            }
        }
    }
}
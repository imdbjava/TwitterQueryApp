package config;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LoggerFactory {

	private  Logger logger;
	
	public LoggerFactory()
	{

	}
	public  Logger getLogger(Class className)
	{
		logger=Logger.getLogger(className);
	    BasicConfigurator.configure();
		return logger;
	}

}

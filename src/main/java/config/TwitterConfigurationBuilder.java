package config;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfigurationBuilder {
	
    private ConfigurationBuilder cb; 
    private static TwitterFactory tf; 

    public TwitterConfigurationBuilder(String ConsumerKey,String ConsumerSecret,
    		String AccessToken,	String TokenSecret) {
      cb = new ConfigurationBuilder();
      cb.setDebugEnabled(true)
        .setOAuthConsumerKey(ConsumerKey)
        .setOAuthConsumerSecret(ConsumerSecret)
        .setOAuthAccessToken(AccessToken)
        .setOAuthAccessTokenSecret(TokenSecret);
       tf = new TwitterFactory(cb.build());
       
    }

	public  Twitter getTwitter() {
		return tf.getInstance();
		}
}
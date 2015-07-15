package controller;

import java.util.HashSet;
import java.util.Set;

import twitter4j.URLEntity;
import model.twitter.entities.Url;

public class UrlController {

	private Set<Url> urls;
	
	public UrlController()
	{

	}
	
	public Set<Url> createUrls(URLEntity[] allUrls)
	{
	    urls=new HashSet<Url>(0);

	    for(URLEntity urlEntity:allUrls)
	    {
	    Url url=new Url();
	    url.setUrl(urlEntity.getExpandedURL());
	    urls.add(url);
	    }
	    
	    return urls;
		
	}
}

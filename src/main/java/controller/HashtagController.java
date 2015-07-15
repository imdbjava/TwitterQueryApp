package controller;

import java.util.HashSet;
import java.util.Set;

import model.twitter.entities.Hashtag;
import twitter4j.HashtagEntity;

public class HashtagController {

	public HashtagController()
	{
		
	}
	public Set<Hashtag> createHashtags(HashtagEntity[] hashtags)
	{
    Set<Hashtag> newHashtags=new HashSet<Hashtag>(0);
    for(HashtagEntity hashtag:hashtags)
    {
    Hashtag newHashtag=new Hashtag();
    newHashtag.setHashtag(hashtag.getText());
    newHashtags.add(newHashtag);
    }
    return newHashtags;

	}
}

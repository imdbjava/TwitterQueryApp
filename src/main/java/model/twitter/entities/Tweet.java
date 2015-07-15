package model.twitter.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="tweet")

public class Tweet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1041037108182045708L;
	@Id
	@Column(name="tweet_id")
	private Long tweetId;

	@Column(name="tweet_text")
	private String tweetText;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, length = 19)
	private Date createdAt;

	@Column(name="lang_code")
	private String languageCode;

    @ManyToOne(cascade=CascadeType.ALL)  
	@JoinColumn(name = "user_id")
	private User user;
	

    @ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="tweet_hashtag", joinColumns=@JoinColumn(name="tweet_id"), inverseJoinColumns=@JoinColumn(name="hashtag_id"))  
	private Set<Hashtag> hashtags;

	
    @ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="tweet_url", joinColumns=@JoinColumn(name="tweet_id"), inverseJoinColumns=@JoinColumn(name="url_id"))  
	private Set<Url> urls;


    public Tweet()
    {
    	
    }
	public Set<Url> getUrls() {
		return urls;
	}

	public void setUrls(Set<Url> urls) {
		this.urls = urls;
	}

	public Long getTweetId() {
		return tweetId;
	}

	public void setTweetId(Long l) {
		this.tweetId = l;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Hashtag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(Set<Hashtag> hashtags) {
		this.hashtags = hashtags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tweetId == null) ? 0 : tweetId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		if (tweetId == null) {
			if (other.tweetId != null)
				return false;
		} else if (!tweetId.equals(other.tweetId))
			return false;
		return true;
	}


	
}

package model.twitter.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="keyword")

public class Keyword implements Serializable {


	private static final long serialVersionUID = -1429681347817644570L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="key_id")
	private Long keyId;   

	@Column(name="key_name")
	private String keyName;   


    @ManyToMany(cascade=CascadeType.PERSIST)  
    @JoinTable(name="tweet_keyword", joinColumns=@JoinColumn(name="key_id"), inverseJoinColumns=@JoinColumn(name="tweet_id"))  
	 private Set<Tweet> tweet;
	 

    
    public Keyword()
    {
    	
    }
    
	public Long getKeyId() {
		return this.keyId;
	}

	public void setKeyId(Long keyId) {
		this.keyId = keyId;
	}   
	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String key) {
		this.keyName = key;
	}


	public Set<Tweet> getTweet() {
		return tweet;
	}

	public void setTweet(Set<Tweet> tweet) {
		this.tweet = tweet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyId == null) ? 0 : keyId.hashCode());
		result = prime * result + ((keyName == null) ? 0 : keyName.hashCode());
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
		Keyword other = (Keyword) obj;
		if (keyId == null) {
			if (other.keyId != null)
				return false;
		} else if (!keyId.equals(other.keyId))
			return false;
		if (keyName == null) {
			if (other.keyName != null)
				return false;
		} else if (!keyName.equals(other.keyName))
			return false;
		return true;
	}



   
}

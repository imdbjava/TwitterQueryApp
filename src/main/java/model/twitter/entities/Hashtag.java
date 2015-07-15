package model.twitter.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hashtag")
public class Hashtag implements Serializable{


	private static final long serialVersionUID = 6302465277669302540L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hashtag_id")
	private Integer hashtagId;

	
	@Column(name="hashtag")
	private String hashtag;
	
	public Hashtag()
	{
		
	}


	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}


	public Integer getHashtagId() {
		return hashtagId;
	}

	public void setHashtagId(Integer hashtagId) {
		this.hashtagId = hashtagId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hashtag == null) ? 0 : hashtag.hashCode());
		result = prime * result
				+ ((hashtagId == null) ? 0 : hashtagId.hashCode());
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
		Hashtag other = (Hashtag) obj;
		if (hashtag == null) {
			if (other.hashtag != null)
				return false;
		} else if (!hashtag.equals(other.hashtag))
			return false;
		if (hashtagId == null) {
			if (other.hashtagId != null)
				return false;
		} else if (!hashtagId.equals(other.hashtagId))
			return false;
		return true;
	}



	
}

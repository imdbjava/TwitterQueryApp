package model.twitter.entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="url")
public class Url implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -606690240421717136L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="url_id")
	private Integer urlId;


	@Column(name="url")
	private String url;
	

	public Url()
	{
		
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUrlId() {
		return urlId;
	}

	public void setUrlId(Integer urlId) {
		this.urlId = urlId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((urlId == null) ? 0 : urlId.hashCode());
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
		Url other = (Url) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (urlId == null) {
			if (other.urlId != null)
				return false;
		} else if (!urlId.equals(other.urlId))
			return false;
		return true;
	}



	
	
	
	
}

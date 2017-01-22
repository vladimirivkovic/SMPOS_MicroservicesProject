package rs.uns.acs.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document
public class Registry implements Serializable{
	
	@Id
	private String id;
	private int broj;
	private Date datumOtvaranja;
	
	public Registry() {
		// TODO Auto-generated constructor stub
	}
	
	public Registry(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	@Override
	public String toString() {
		return "Registry [id=" + id + ", broj=" + broj + ", datumOtvaranja=" + datumOtvaranja + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + broj;
		result = prime * result + ((datumOtvaranja == null) ? 0 : datumOtvaranja.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Registry other = (Registry) obj;
		if (broj != other.broj)
			return false;
		if (datumOtvaranja == null) {
			if (other.datumOtvaranja != null)
				return false;
		} else if (!datumOtvaranja.equals(other.datumOtvaranja))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
}

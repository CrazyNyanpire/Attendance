package com.acetecsemi.attendance.attendance.core;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;
@Entity
@Table(name="Attence_timestamp")
public class Timestamp extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6707602985483498720L;
	private String timestamp;
	private String lastTimestamp;
	private int type ;
	private String description;
	private int doNext;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getLastTimestamp() {
		return lastTimestamp;
	}

	public void setLastTimestamp(String lastTimestamp) {
		this.lastTimestamp = lastTimestamp;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDoNext() {
		return doNext;
	}

	public void setDoNext(int doNext) {
		this.doNext = doNext;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + doNext;
		result = prime * result
				+ ((lastTimestamp == null) ? 0 : lastTimestamp.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + type;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Timestamp other = (Timestamp) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (doNext != other.doNext)
			return false;
		if (lastTimestamp == null) {
			if (other.lastTimestamp != null)
				return false;
		} else if (!lastTimestamp.equals(other.lastTimestamp))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}

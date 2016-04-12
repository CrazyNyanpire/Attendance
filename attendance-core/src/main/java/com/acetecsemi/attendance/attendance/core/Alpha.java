package com.acetecsemi.attendance.attendance.core;

import java.util.Date;

import javax.persistence.Entity;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;
@Entity
public class Alpha extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3590044064594547732L;
	private String fileName;
	private Date importTime;
	private long record;
	private long trueRecord;
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getImportTime() {
		return importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public long getRecord() {
		return record;
	}

	public void setRecord(long record) {
		this.record = record;
	}

	public long getTrueRecord() {
		return trueRecord;
	}

	public void setTrueRecord(long trueRecord) {
		this.trueRecord = trueRecord;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((importTime == null) ? 0 : importTime.hashCode());
		result = prime * result + (int) (record ^ (record >>> 32));
		result = prime * result + (int) (trueRecord ^ (trueRecord >>> 32));
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
		Alpha other = (Alpha) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (importTime == null) {
			if (other.importTime != null)
				return false;
		} else if (!importTime.equals(other.importTime))
			return false;
		if (record != other.record)
			return false;
		if (trueRecord != other.trueRecord)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alpha [fileName=" + fileName + ", importTime=" + importTime
				+ ", record=" + record + ", trueRecord=" + trueRecord + "]";
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}

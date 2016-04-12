package com.acetecsemi.attendance.attendance.core;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;
@Entity
@Table(name="Attence_AttenceRecordFile")
public class AttenceRecordFile extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5909554912580756869L;
	private String fileName;
	private Date importTime;
	private long record;
	private long recordSuccess;
	private String path;
	
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
	public long getRecordSuccess() {
		return recordSuccess;
	}
	public void setRecordSuccess(long recordSuccess) {
		this.recordSuccess = recordSuccess;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((importTime == null) ? 0 : importTime.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + (int) (record ^ (record >>> 32));
		result = prime * result
				+ (int) (recordSuccess ^ (recordSuccess >>> 32));
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
		AttenceRecordFile other = (AttenceRecordFile) obj;
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
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (record != other.record)
			return false;
		if (recordSuccess != other.recordSuccess)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AttenceRecordFile [fileName=" + fileName + ", importTime="
				+ importTime + ", record=" + record + ", recordSuccess="
				+ recordSuccess + ", path=" + path + "]";
	}
	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}

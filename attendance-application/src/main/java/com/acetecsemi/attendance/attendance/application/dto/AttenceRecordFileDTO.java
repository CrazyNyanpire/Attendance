package com.acetecsemi.attendance.attendance.application.dto;

import java.util.Date;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.openkoala.koala.springmvc.JsonDateSerializer;


public class AttenceRecordFileDTO implements Serializable {

	private Long id;

						
	private Long record;
	
		
	private String path;
	
		
	private String fileName;
	
						
	private Long recordSuccess;
	
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date importTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date importTimeEnd;
								
		

	public void setRecord(Long record) { 
		this.record = record;
	}

	public Long getRecord() {
		return this.record;
	}
	
			
		

	public void setPath(String path) { 
		this.path = path;
	}

	public String getPath() {
		return this.path;
	}
	
			
		

	public void setFileName(String fileName) { 
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}
	
								
		

	public void setRecordSuccess(Long recordSuccess) { 
		this.recordSuccess = recordSuccess;
	}

	public Long getRecordSuccess() {
		return this.recordSuccess;
	}
	
			
		

	public void setImportTime(Date importTime) { 
		this.importTime = importTime;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getImportTime() {
		return this.importTime;
	}
	
	public void setImportTimeEnd(Date importTimeEnd) { 
		this.importTimeEnd = importTimeEnd;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getImportTimeEnd() {
		return this.importTimeEnd;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		AttenceRecordFileDTO other = (AttenceRecordFileDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
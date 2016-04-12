package com.acetecsemi.attendance.attendance.application.dto;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.openkoala.koala.springmvc.JsonDateSerializer;


public class ScheduleDTO implements Serializable {

	private Long id;

						
	private Integer scheduleType;
	
						
	private Integer scheduleDate;
	
						
	private Integer dutyType;
	
								
		

	public void setScheduleType(Integer scheduleType) { 
		this.scheduleType = scheduleType;
	}

	public Integer getScheduleType() {
		return this.scheduleType;
	}
	
								
		

	public void setScheduleDate(Integer scheduleDate) { 
		this.scheduleDate = scheduleDate;
	}

	public Integer getScheduleDate() {
		return this.scheduleDate;
	}
	
								
		

	public void setDutyType(Integer dutyType) { 
		this.dutyType = dutyType;
	}

	public Integer getDutyType() {
		return this.dutyType;
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
		ScheduleDTO other = (ScheduleDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
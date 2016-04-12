package com.acetecsemi.attendance.attendance.application.dto;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.openkoala.koala.springmvc.JsonDateSerializer;


public class BusinessTravelDTO implements Serializable {

	private Long id;

		
	private String attenceDays;
	
		
	private String runName;
	
		
	private String detail;
	
		
	private String endDay;
	
		
	private String reason;
	
		
	private String formArea;
	
		
	private String runId;
	
		
	private String endTime;
	
		
	private String departmentName;
	
		
	private String creator;
	
		
	private String employeeName;
	
		
	private String toArea;
	
		
	private String startTime;
	
		
	private String employeeNo;
	
		
	private String days;
	
		
	private String event;
	
		
	private String startDay;
	
			
		

	public void setAttenceDays(String attenceDays) { 
		this.attenceDays = attenceDays;
	}

	public String getAttenceDays() {
		return this.attenceDays;
	}
	
			
		

	public void setRunName(String runName) { 
		this.runName = runName;
	}

	public String getRunName() {
		return this.runName;
	}
	
			
		

	public void setDetail(String detail) { 
		this.detail = detail;
	}

	public String getDetail() {
		return this.detail;
	}
	
			
		

	public void setEndDay(String endDay) { 
		this.endDay = endDay;
	}

	public String getEndDay() {
		return this.endDay;
	}
	
			
		

	public void setReason(String reason) { 
		this.reason = reason;
	}

	public String getReason() {
		return this.reason;
	}
	
			
		

	public void setFormArea(String formArea) { 
		this.formArea = formArea;
	}

	public String getFormArea() {
		return this.formArea;
	}
	
			
		

	public void setRunId(String runId) { 
		this.runId = runId;
	}

	public String getRunId() {
		return this.runId;
	}
	
			
		

	public void setEndTime(String endTime) { 
		this.endTime = endTime;
	}

	public String getEndTime() {
		return this.endTime;
	}
	
			
		

	public void setDepartmentName(String departmentName) { 
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}
	
			
		

	public void setCreator(String creator) { 
		this.creator = creator;
	}

	public String getCreator() {
		return this.creator;
	}
	
			
		

	public void setEmployeeName(String employeeName) { 
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}
	
			
		

	public void setToArea(String toArea) { 
		this.toArea = toArea;
	}

	public String getToArea() {
		return this.toArea;
	}
	
			
		

	public void setStartTime(String startTime) { 
		this.startTime = startTime;
	}

	public String getStartTime() {
		return this.startTime;
	}
	
			
		

	public void setEmployeeNo(String employeeNo) { 
		this.employeeNo = employeeNo;
	}

	public String getEmployeeNo() {
		return this.employeeNo;
	}
	
			
		

	public void setDays(String days) { 
		this.days = days;
	}

	public String getDays() {
		return this.days;
	}
	
			
		

	public void setEvent(String event) { 
		this.event = event;
	}

	public String getEvent() {
		return this.event;
	}
	
			
		

	public void setStartDay(String startDay) { 
		this.startDay = startDay;
	}

	public String getStartDay() {
		return this.startDay;
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
		BusinessTravelDTO other = (BusinessTravelDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
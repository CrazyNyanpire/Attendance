package com.acetecsemi.attendance.attendance.application.dto;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.openkoala.koala.springmvc.JsonDateSerializer;


public class AskLeaveDTO extends TableListAbstractDTO implements Serializable {

	private Long id;

		
	private String runName;
	
		
	private String askLeaveDescription;
	
		
	private String endDay;
	
		
	private String sickLeave;
	
		
	private String runId;
	
		
	private String endTime;
	
		
	private String leaveType;
	
		
	private String creator;
	
		
	private String employeeName;
	
		
	private String startTime;
	
		
	private String employeeNo;
	
		
	private String yearHolidays;
	
		
	private String days;
	
		
	private String startDay;
	
		
	private String delayRest;
	
			
		

	public void setRunName(String runName) { 
		this.runName = runName;
	}

	public String getRunName() {
		return this.runName;
	}
	
			
		

	public void setAskLeaveDescription(String askLeaveDescription) { 
		this.askLeaveDescription = askLeaveDescription;
	}

	public String getAskLeaveDescription() {
		return this.askLeaveDescription;
	}
	
			
		

	public void setEndDay(String endDay) { 
		this.endDay = endDay;
	}

	public String getEndDay() {
		return this.endDay;
	}
	
			
		

	public void setSickLeave(String sickLeave) { 
		this.sickLeave = sickLeave;
	}

	public String getSickLeave() {
		return this.sickLeave;
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
	
			
		

	public void setLeaveType(String leaveType) { 
		this.leaveType = leaveType;
	}

	public String getLeaveType() {
		return this.leaveType;
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
	
			
		

	public void setYearHolidays(String yearHolidays) { 
		this.yearHolidays = yearHolidays;
	}

	public String getYearHolidays() {
		return this.yearHolidays;
	}
	
			
		

	public void setDays(String days) { 
		this.days = days;
	}

	public String getDays() {
		return this.days;
	}
	
			
		

	public void setStartDay(String startDay) { 
		this.startDay = startDay;
	}

	public String getStartDay() {
		return this.startDay;
	}
	
			
		

	public void setDelayRest(String delayRest) { 
		this.delayRest = delayRest;
	}

	public String getDelayRest() {
		return this.delayRest;
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
		AskLeaveDTO other = (AskLeaveDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
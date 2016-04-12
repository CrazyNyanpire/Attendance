package com.acetecsemi.attendance.attendance.application.dto;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.openkoala.koala.springmvc.JsonDateSerializer;


public class WorkOvertimeDTO extends TableListAbstractDTO  implements Serializable {

	private Long id;

		
	private String runName;
	
		
	private String hours;
	
		
	private String mealSupplementTime;
	
		
	private String runId;
	
		
	private String date;
	
		
	private String endTime;
	
		
	private String departmentName;
	
		
	private String restOrMoney;
	
		
	private String employeeName;
	
		
	private String creator;
	
		
	private String startTime;
	
		
	private String mealSupplementType;
	
		
	private String employeeNo;
	
		
	private String workOvertimeType;
	
		
	private String workOvertimeDescription;
	
			
		

	public void setRunName(String runName) { 
		this.runName = runName;
	}

	public String getRunName() {
		return this.runName;
	}
	
			
		

	public void setHours(String hours) { 
		this.hours = hours;
	}

	public String getHours() {
		return this.hours;
	}
	
			
		

	public void setMealSupplementTime(String mealSupplementTime) { 
		this.mealSupplementTime = mealSupplementTime;
	}

	public String getMealSupplementTime() {
		return this.mealSupplementTime;
	}
	
			
		

	public void setRunId(String runId) { 
		this.runId = runId;
	}

	public String getRunId() {
		return this.runId;
	}
	
			
		

	public void setDate(String date) { 
		this.date = date;
	}

	public String getDate() {
		return this.date;
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
	
			
		

	public void setRestOrMoney(String restOrMoney) { 
		this.restOrMoney = restOrMoney;
	}

	public String getRestOrMoney() {
		return this.restOrMoney;
	}
	
			
		

	public void setEmployeeName(String employeeName) { 
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}
	
			
		

	public void setCreator(String creator) { 
		this.creator = creator;
	}

	public String getCreator() {
		return this.creator;
	}
	
			
		

	public void setStartTime(String startTime) { 
		this.startTime = startTime;
	}

	public String getStartTime() {
		return this.startTime;
	}
	
			
		

	public void setMealSupplementType(String mealSupplementType) { 
		this.mealSupplementType = mealSupplementType;
	}

	public String getMealSupplementType() {
		return this.mealSupplementType;
	}
	
			
		

	public void setEmployeeNo(String employeeNo) { 
		this.employeeNo = employeeNo;
	}

	public String getEmployeeNo() {
		return this.employeeNo;
	}
	
			
		

	public void setWorkOvertimeType(String workOvertimeType) { 
		this.workOvertimeType = workOvertimeType;
	}

	public String getWorkOvertimeType() {
		return this.workOvertimeType;
	}
	
			
		

	public void setWorkOvertimeDescription(String workOvertimeDescription) { 
		this.workOvertimeDescription = workOvertimeDescription;
	}

	public String getWorkOvertimeDescription() {
		return this.workOvertimeDescription;
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
		WorkOvertimeDTO other = (WorkOvertimeDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
package com.acetecsemi.attendance.attendance.application.dto;

import java.util.Date;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.openkoala.koala.springmvc.JsonDateSerializer;


public class ClockDetailDTO implements Serializable {

	private Long id;

		
	private String attendenceOutType;
	
		
	private String employeeNo;
	
		
	private String clockOut;
	
		
	private String attendenceInType;
	
		
	private String name;
	
		
	private String attendenceType;
	
		
	private String clockIn;
	
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date attenceTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date attenceTimeEnd;
			
		

	public void setAttendenceOutType(String attendenceOutType) { 
		this.attendenceOutType = attendenceOutType;
	}

	public String getAttendenceOutType() {
		return this.attendenceOutType;
	}
	
			
		

	public void setEmployeeNo(String employeeNo) { 
		this.employeeNo = employeeNo;
	}

	public String getEmployeeNo() {
		return this.employeeNo;
	}
	
			
		

	public void setClockOut(String clockOut) { 
		this.clockOut = clockOut;
	}

	public String getClockOut() {
		return this.clockOut;
	}
	
			
		

	public void setAttendenceInType(String attendenceInType) { 
		this.attendenceInType = attendenceInType;
	}

	public String getAttendenceInType() {
		return this.attendenceInType;
	}
	
			
		

	public void setName(String name) { 
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
			
		

	public void setAttendenceType(String attendenceType) { 
		this.attendenceType = attendenceType;
	}

	public String getAttendenceType() {
		return this.attendenceType;
	}
	
			
		

	public void setClockIn(String clockIn) { 
		this.clockIn = clockIn;
	}

	public String getClockIn() {
		return this.clockIn;
	}
	
			
		

	public void setAttenceTime(Date attenceTime) { 
		this.attenceTime = attenceTime;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getAttenceTime() {
		return this.attenceTime;
	}
	
	public void setAttenceTimeEnd(Date attenceTimeEnd) { 
		this.attenceTimeEnd = attenceTimeEnd;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getAttenceTimeEnd() {
		return this.attenceTimeEnd;
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
		ClockDetailDTO other = (ClockDetailDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
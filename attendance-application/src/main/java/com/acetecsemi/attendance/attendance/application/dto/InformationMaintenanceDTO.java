package com.acetecsemi.attendance.attendance.application.dto;

import java.util.Date;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.openkoala.koala.springmvc.JsonDateSerializer;


public class InformationMaintenanceDTO extends TableListAbstractDTO implements Serializable {

	private Long id;

		
	private String employeeNo;
	
	private String annualVacationBalance;
	
		
	private String annualVacation;
	
		
	private String sickLeave;
	
		
	private String name;
	
		
	private String lastMounthRest;
	
		
	private String sickLeaveBalance;
	
		
	private String thisMounthRest;
	
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entryDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entryDateEnd;
			
		

	public void setEmployeeNo(String employeeNo) { 
		this.employeeNo = employeeNo;
	}

	public String getEmployeeNo() {
		return this.employeeNo;
	}
	
			
		

	public void setAnnualVacationBalance(String annualVacationBalance) { 
		this.annualVacationBalance = annualVacationBalance;
	}

	public String getAnnualVacationBalance() {
		return this.annualVacationBalance;
	}
	
			
		

	public void setAnnualVacation(String annualVacation) { 
		this.annualVacation = annualVacation;
	}

	public String getAnnualVacation() {
		return this.annualVacation;
	}
	
			
		

	public void setSickLeave(String sickLeave) { 
		this.sickLeave = sickLeave;
	}

	public String getSickLeave() {
		return this.sickLeave;
	}
	
			
		

	public void setName(String name) { 
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
			
		

	public void setLastMounthRest(String lastMounthRest) { 
		this.lastMounthRest = lastMounthRest;
	}

	public String getLastMounthRest() {
		return this.lastMounthRest;
	}
	
			
		

	public void setSickLeaveBalance(String sickLeaveBalance) { 
		this.sickLeaveBalance = sickLeaveBalance;
	}

	public String getSickLeaveBalance() {
		return this.sickLeaveBalance;
	}
	
			
		

	public void setThisMounthRest(String thisMounthRest) { 
		this.thisMounthRest = thisMounthRest;
	}

	public String getThisMounthRest() {
		return this.thisMounthRest;
	}
	
			
		

	public void setEntryDate(Date entryDate) { 
		this.entryDate = entryDate;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getEntryDate() {
		return this.entryDate;
	}
	
	public void setEntryDateEnd(Date entryDateEnd) { 
		this.entryDateEnd = entryDateEnd;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getEntryDateEnd() {
		return this.entryDateEnd;
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
		InformationMaintenanceDTO other = (InformationMaintenanceDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
package com.acetecsemi.attendance.attendance.core;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;

@Entity
@Table(name = "attence_workovertime")
public class WorkOvertime extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6736460079474817875L;

	private String employeeNo;

	private String employeeName;

	private String runName;

	private String runId;

	private String creator;

	private String departmentName;

	private String date;

	private String startTime;

	private String endTime;

	private String workOvertimeType;

	private String workOvertimeDescription;

	private String restOrMoney;
	
	private String hours;
	
	private String mealSupplementType;
	
	private String mealSupplementTime;

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getRunName() {
		return runName;
	}

	public void setRunName(String runName) {
		this.runName = runName;
	}

	public String getRunId() {
		return runId;
	}

	public void setRunId(String runId) {
		this.runId = runId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getWorkOvertimeType() {
		return workOvertimeType;
	}

	public void setWorkOvertimeType(String workOvertimeType) {
		this.workOvertimeType = workOvertimeType;
	}

	public String getWorkOvertimeDescription() {
		return workOvertimeDescription;
	}

	public void setWorkOvertimeDescription(String workOvertimeDescription) {
		this.workOvertimeDescription = workOvertimeDescription;
	}

	public String getRestOrMoney() {
		return restOrMoney;
	}

	public void setRestOrMoney(String restOrMoney) {
		this.restOrMoney = restOrMoney;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getMealSupplementType() {
		return mealSupplementType;
	}

	public void setMealSupplementType(String mealSupplementType) {
		this.mealSupplementType = mealSupplementType;
	}

	public String getMealSupplementTime() {
		return mealSupplementTime;
	}

	public void setMealSupplementTime(String mealSupplementTime) {
		this.mealSupplementTime = mealSupplementTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result
				+ ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result
				+ ((employeeNo == null) ? 0 : employeeNo.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((hours == null) ? 0 : hours.hashCode());
		result = prime
				* result
				+ ((mealSupplementTime == null) ? 0 : mealSupplementTime
						.hashCode());
		result = prime
				* result
				+ ((mealSupplementType == null) ? 0 : mealSupplementType
						.hashCode());
		result = prime * result
				+ ((restOrMoney == null) ? 0 : restOrMoney.hashCode());
		result = prime * result + ((runId == null) ? 0 : runId.hashCode());
		result = prime * result + ((runName == null) ? 0 : runName.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime
				* result
				+ ((workOvertimeDescription == null) ? 0
						: workOvertimeDescription.hashCode());
		result = prime
				* result
				+ ((workOvertimeType == null) ? 0 : workOvertimeType.hashCode());
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
		WorkOvertime other = (WorkOvertime) obj;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeeNo == null) {
			if (other.employeeNo != null)
				return false;
		} else if (!employeeNo.equals(other.employeeNo))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (hours == null) {
			if (other.hours != null)
				return false;
		} else if (!hours.equals(other.hours))
			return false;
		if (mealSupplementTime == null) {
			if (other.mealSupplementTime != null)
				return false;
		} else if (!mealSupplementTime.equals(other.mealSupplementTime))
			return false;
		if (mealSupplementType == null) {
			if (other.mealSupplementType != null)
				return false;
		} else if (!mealSupplementType.equals(other.mealSupplementType))
			return false;
		if (restOrMoney == null) {
			if (other.restOrMoney != null)
				return false;
		} else if (!restOrMoney.equals(other.restOrMoney))
			return false;
		if (runId == null) {
			if (other.runId != null)
				return false;
		} else if (!runId.equals(other.runId))
			return false;
		if (runName == null) {
			if (other.runName != null)
				return false;
		} else if (!runName.equals(other.runName))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (workOvertimeDescription == null) {
			if (other.workOvertimeDescription != null)
				return false;
		} else if (!workOvertimeDescription
				.equals(other.workOvertimeDescription))
			return false;
		if (workOvertimeType == null) {
			if (other.workOvertimeType != null)
				return false;
		} else if (!workOvertimeType.equals(other.workOvertimeType))
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}

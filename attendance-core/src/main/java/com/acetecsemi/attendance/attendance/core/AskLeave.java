package com.acetecsemi.attendance.attendance.core;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;

@Entity
@Table(name = "attence_askleave")
public class AskLeave extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6736460079474817875L;

	private String employeeNo;

	private String employeeName;

	private String runName;

	private String runId;

	private String creator;

	private String yearHolidays;

	private String delayRest;

	private String sickLeave;

	private String startDay;

	private String startTime;

	private String endDay;

	private String endTime;

	private String days;

	private String leaveType;

	private String askLeaveDescription;

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

	public String getYearHolidays() {
		return yearHolidays;
	}

	public void setYearHolidays(String yearHolidays) {
		this.yearHolidays = yearHolidays;
	}

	public String getDelayRest() {
		return delayRest;
	}

	public void setDelayRest(String delayRest) {
		this.delayRest = delayRest;
	}

	public String getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(String sickLeave) {
		this.sickLeave = sickLeave;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getAskLeaveDescription() {
		return askLeaveDescription;
	}

	public void setAskLeaveDescription(String askLeaveDescription) {
		this.askLeaveDescription = askLeaveDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((askLeaveDescription == null) ? 0 : askLeaveDescription
						.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result
				+ ((delayRest == null) ? 0 : delayRest.hashCode());
		result = prime * result
				+ ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result
				+ ((employeeNo == null) ? 0 : employeeNo.hashCode());
		result = prime * result + ((endDay == null) ? 0 : endDay.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((leaveType == null) ? 0 : leaveType.hashCode());
		result = prime * result + ((runId == null) ? 0 : runId.hashCode());
		result = prime * result + ((runName == null) ? 0 : runName.hashCode());
		result = prime * result
				+ ((sickLeave == null) ? 0 : sickLeave.hashCode());
		result = prime * result
				+ ((startDay == null) ? 0 : startDay.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result
				+ ((yearHolidays == null) ? 0 : yearHolidays.hashCode());
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
		AskLeave other = (AskLeave) obj;
		if (askLeaveDescription == null) {
			if (other.askLeaveDescription != null)
				return false;
		} else if (!askLeaveDescription.equals(other.askLeaveDescription))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (days == null) {
			if (other.days != null)
				return false;
		} else if (!days.equals(other.days))
			return false;
		if (delayRest == null) {
			if (other.delayRest != null)
				return false;
		} else if (!delayRest.equals(other.delayRest))
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
		if (endDay == null) {
			if (other.endDay != null)
				return false;
		} else if (!endDay.equals(other.endDay))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (leaveType == null) {
			if (other.leaveType != null)
				return false;
		} else if (!leaveType.equals(other.leaveType))
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
		if (sickLeave == null) {
			if (other.sickLeave != null)
				return false;
		} else if (!sickLeave.equals(other.sickLeave))
			return false;
		if (startDay == null) {
			if (other.startDay != null)
				return false;
		} else if (!startDay.equals(other.startDay))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (yearHolidays == null) {
			if (other.yearHolidays != null)
				return false;
		} else if (!yearHolidays.equals(other.yearHolidays))
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}

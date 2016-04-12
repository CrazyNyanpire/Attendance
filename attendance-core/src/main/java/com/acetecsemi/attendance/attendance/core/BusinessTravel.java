package com.acetecsemi.attendance.attendance.core;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;

@Entity
@Table(name = "attence_businesstravel")
public class BusinessTravel extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4078945338164302715L;

	private String employeeNo;

	private String employeeName;

	private String runName;

	private String runId;

	private String creator;

	private String departmentName;

	private String reason;

	private String formArea;

	private String toArea;

	private String startDay;

	private String startTime;

	private String endDay;

	private String endTime;

	private String days;

	private String detail;

	private String event;
	
	private String attenceDays;

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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getFormArea() {
		return formArea;
	}

	public void setFormArea(String formArea) {
		this.formArea = formArea;
	}

	public String getToArea() {
		return toArea;
	}

	public void setToArea(String toArea) {
		this.toArea = toArea;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}


	public String getAttenceDays() {
		return attenceDays;
	}

	public void setAttenceDays(String attenceDays) {
		this.attenceDays = attenceDays;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((attenceDays == null) ? 0 : attenceDays.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result
				+ ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result
				+ ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result
				+ ((employeeNo == null) ? 0 : employeeNo.hashCode());
		result = prime * result + ((endDay == null) ? 0 : endDay.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result
				+ ((formArea == null) ? 0 : formArea.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((runId == null) ? 0 : runId.hashCode());
		result = prime * result + ((runName == null) ? 0 : runName.hashCode());
		result = prime * result
				+ ((startDay == null) ? 0 : startDay.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((toArea == null) ? 0 : toArea.hashCode());
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
		BusinessTravel other = (BusinessTravel) obj;
		if (attenceDays == null) {
			if (other.attenceDays != null)
				return false;
		} else if (!attenceDays.equals(other.attenceDays))
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
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
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
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (formArea == null) {
			if (other.formArea != null)
				return false;
		} else if (!formArea.equals(other.formArea))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
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
		if (toArea == null) {
			if (other.toArea != null)
				return false;
		} else if (!toArea.equals(other.toArea))
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}

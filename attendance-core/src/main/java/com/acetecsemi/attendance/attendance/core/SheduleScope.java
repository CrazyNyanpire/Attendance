package com.acetecsemi.attendance.attendance.core;


public class SheduleScope {

	private String employeeNo;
	private String employeeName;
	private String dutyType;
	private String scheduleDate;
	private String scheduleType;
	private String startDate;
	private String endDate;
	private String timeArea;
	private String workStartStart;
	private String workStartEnd;
	private String workEndStart;
	private String workEndEnd;

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

	public String getDutyType() {
		return dutyType;
	}

	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTimeArea() {
		return timeArea;
	}

	public void setTimeArea(String timeArea) {
		this.timeArea = timeArea;
	}

	public String getWorkStartStart() {
		return workStartStart;
	}

	public void setWorkStartStart(String workStartStart) {
		this.workStartStart = workStartStart;
	}

	public String getWorkStartEnd() {
		return workStartEnd;
	}

	public void setWorkStartEnd(String workStartEnd) {
		this.workStartEnd = workStartEnd;
	}

	public String getWorkEndStart() {
		return workEndStart;
	}

	public void setWorkEndStart(String workEndStart) {
		this.workEndStart = workEndStart;
	}

	public String getWorkEndEnd() {
		return workEndEnd;
	}

	public void setWorkEndEnd(String workEndEnd) {
		this.workEndEnd = workEndEnd;
	}

	@Override
	public String toString() {
		return "SheduleScope [employeeNo=" + employeeNo + ", employeeName="
				+ employeeName + ", dutyType=" + dutyType + ", scheduleDate="
				+ scheduleDate + ", scheduleType=" + scheduleType
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", timeArea=" + timeArea + ", workStartStart="
				+ workStartStart + ", workStartEnd=" + workStartEnd
				+ ", workEndStart=" + workEndStart + ", workEndEnd="
				+ workEndEnd + "]";
	}

}

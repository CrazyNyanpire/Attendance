package com.acetecsemi.attendance.attendance.application.dto;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.openkoala.koala.springmvc.JsonDateSerializer;


public class MonthlyAttendanceConfirmationDTO implements Serializable {

	private Long id;

		
	private String stakeclass_n;
	
		
	private String sickLeave;
	
		
	private String sickLeaveBalance;
	
		
	private String rest_annual;
	
		
	private String stakeclass_nor;
	
		
	private String stakeclass_d;
	
		
	private String overtime_week;
	
		
	private String notakeclass;
	
		
	private String rest_sickness;
	
		
	private String annualVacation;
	
		
	private String atakeclass_d;
	
		
	private String travelAllowance;
	
	
	private String installationAllowance;

	
	private String rest_marry;
	
		
	private String name;
	
		
	private String overtime_work;
	
		
	private String rest_maternity;
	
		
	private String rest_plan_maternity;
	
		
	private String atakeclass_nor;
	
		
	private String atakeclass_n;
	
		
	private String rest_bruise;
	
		
	private String nocredit_card;
	
		
	private String rest_funeral;
	
		
	private String annualVacationBalance;
	
		
	private String overtime_holiday;
	
		
	private String rest_personal;
	
		
	private String mealAllowanced_nor;
	
		
	private String overtime_Rest;
	
		
	private String thisMounthRest;
	
		
	private String entryDate;
	
		
	private String leave_early;
	
		
	private String rest_rest;
	
		
	private String mealAllowanced_d;
	
		
	private String employeeNo;
	
		
	private String late;
	
		
	private String lastMounthRest;
	
		
	private String mealAllowanced_n;
	
		
	private String is_full_hours;
	
		
	private String attendancetype;
	
	private String attendancemonth;	
		

	public void setStakeclass_n(String stakeclass_n) { 
		this.stakeclass_n = stakeclass_n;
	}

	public String getStakeclass_n() {
		return this.stakeclass_n;
	}
	
			
		

	public void setSickLeave(String sickLeave) { 
		this.sickLeave = sickLeave;
	}

	public String getSickLeave() {
		return this.sickLeave;
	}
	
			
		

	public void setSickLeaveBalance(String sickLeaveBalance) { 
		this.sickLeaveBalance = sickLeaveBalance;
	}

	public String getSickLeaveBalance() {
		return this.sickLeaveBalance;
	}
	
			
		

	public void setRest_annual(String rest_annual) { 
		this.rest_annual = rest_annual;
	}

	public String getRest_annual() {
		return this.rest_annual;
	}
	
			
		

	public void setStakeclass_nor(String stakeclass_nor) { 
		this.stakeclass_nor = stakeclass_nor;
	}

	public String getStakeclass_nor() {
		return this.stakeclass_nor;
	}
	
			
		

	public void setStakeclass_d(String stakeclass_d) { 
		this.stakeclass_d = stakeclass_d;
	}

	public String getStakeclass_d() {
		return this.stakeclass_d;
	}
	
			
		

	public void setOvertime_week(String overtime_week) { 
		this.overtime_week = overtime_week;
	}

	public String getOvertime_week() {
		return this.overtime_week;
	}
	
			
		

	public void setNotakeclass(String notakeclass) { 
		this.notakeclass = notakeclass;
	}

	public String getNotakeclass() {
		return this.notakeclass;
	}
	
			
		

	public void setRest_sickness(String rest_sickness) { 
		this.rest_sickness = rest_sickness;
	}

	public String getRest_sickness() {
		return this.rest_sickness;
	}
	
			
		

	public void setAnnualVacation(String annualVacation) { 
		this.annualVacation = annualVacation;
	}

	public String getAnnualVacation() {
		return this.annualVacation;
	}
	
			
		

	public void setAtakeclass_d(String atakeclass_d) { 
		this.atakeclass_d = atakeclass_d;
	}

	public String getAtakeclass_d() {
		return this.atakeclass_d;
	}
	
			
		

	public void setTravelAllowance(String travelAllowance) { 
		this.travelAllowance = travelAllowance;
	}

	public String getTravelAllowance() {
		return this.travelAllowance;
	}

	
	public String getInstallationAllowance() {
		return installationAllowance;
	}

	public void setInstallationAllowance(String installationAllowance) {
		this.installationAllowance = installationAllowance;
	}		
		

	public void setRest_marry(String rest_marry) { 
		this.rest_marry = rest_marry;
	}

	public String getRest_marry() {
		return this.rest_marry;
	}
	

	public void setName(String name) { 
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
			
		

	public void setOvertime_work(String overtime_work) { 
		this.overtime_work = overtime_work;
	}

	public String getOvertime_work() {
		return this.overtime_work;
	}
	
			
		

	public void setRest_maternity(String rest_maternity) { 
		this.rest_maternity = rest_maternity;
	}

	public String getRest_maternity() {
		return this.rest_maternity;
	}
	
			
		

	public void setRest_plan_maternity(String rest_plan_maternity) { 
		this.rest_plan_maternity = rest_plan_maternity;
	}

	public String getRest_plan_maternity() {
		return this.rest_plan_maternity;
	}
	
			
		

	public void setAtakeclass_nor(String atakeclass_nor) { 
		this.atakeclass_nor = atakeclass_nor;
	}

	public String getAtakeclass_nor() {
		return this.atakeclass_nor;
	}
	
			
		

	public void setAtakeclass_n(String atakeclass_n) { 
		this.atakeclass_n = atakeclass_n;
	}

	public String getAtakeclass_n() {
		return this.atakeclass_n;
	}
	
			
		

	public void setRest_bruise(String rest_bruise) { 
		this.rest_bruise = rest_bruise;
	}

	public String getRest_bruise() {
		return this.rest_bruise;
	}
	
			
		

	public void setNocredit_card(String nocredit_card) { 
		this.nocredit_card = nocredit_card;
	}

	public String getNocredit_card() {
		return this.nocredit_card;
	}
	
			
		

	public void setRest_funeral(String rest_funeral) { 
		this.rest_funeral = rest_funeral;
	}

	public String getRest_funeral() {
		return this.rest_funeral;
	}
	
			
		

	public void setAnnualVacationBalance(String annualVacationBalance) { 
		this.annualVacationBalance = annualVacationBalance;
	}

	public String getAnnualVacationBalance() {
		return this.annualVacationBalance;
	}
	
			
		

	public void setOvertime_holiday(String overtime_holiday) { 
		this.overtime_holiday = overtime_holiday;
	}

	public String getOvertime_holiday() {
		return this.overtime_holiday;
	}
	
			
		

	public void setRest_personal(String rest_personal) { 
		this.rest_personal = rest_personal;
	}

	public String getRest_personal() {
		return this.rest_personal;
	}
	
			
		

	public void setMealAllowanced_nor(String mealAllowanced_nor) { 
		this.mealAllowanced_nor = mealAllowanced_nor;
	}

	public String getMealAllowanced_nor() {
		return this.mealAllowanced_nor;
	}
	
			
		

	public void setOvertime_Rest(String overtime_Rest) { 
		this.overtime_Rest = overtime_Rest;
	}

	public String getOvertime_Rest() {
		return this.overtime_Rest;
	}
	
			
		

	public void setThisMounthRest(String thisMounthRest) { 
		this.thisMounthRest = thisMounthRest;
	}

	public String getThisMounthRest() {
		return this.thisMounthRest;
	}
	
			
		

	public void setEntryDate(String entryDate) { 
		this.entryDate = entryDate;
	}

	public String getEntryDate() {
		return this.entryDate;
	}
	
			
		

	public void setLeave_early(String leave_early) { 
		this.leave_early = leave_early;
	}

	public String getLeave_early() {
		return this.leave_early;
	}
	
			
		

	public void setRest_rest(String rest_rest) { 
		this.rest_rest = rest_rest;
	}

	public String getRest_rest() {
		return this.rest_rest;
	}
	
			
		

	public void setMealAllowanced_d(String mealAllowanced_d) { 
		this.mealAllowanced_d = mealAllowanced_d;
	}

	public String getMealAllowanced_d() {
		return this.mealAllowanced_d;
	}
	
			
		

	public void setEmployeeNo(String employeeNo) { 
		this.employeeNo = employeeNo;
	}

	public String getEmployeeNo() {
		return this.employeeNo;
	}
	
			
		

	public void setLate(String late) { 
		this.late = late;
	}

	public String getLate() {
		return this.late;
	}
	
			
		

	public void setLastMounthRest(String lastMounthRest) { 
		this.lastMounthRest = lastMounthRest;
	}

	public String getLastMounthRest() {
		return this.lastMounthRest;
	}
	
			
		

	public void setMealAllowanced_n(String mealAllowanced_n) { 
		this.mealAllowanced_n = mealAllowanced_n;
	}

	public String getMealAllowanced_n() {
		return this.mealAllowanced_n;
	}
	
			
		

	public void setIs_full_hours(String is_full_hours) { 
		this.is_full_hours = is_full_hours;
	}

	public String getIs_full_hours() {
		return this.is_full_hours;
	}
	
			
		

	public void setAttendancetype(String attendancetype) { 
		this.attendancetype = attendancetype;
	}

	public String getAttendancetype() {
		return this.attendancetype;
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
		MonthlyAttendanceConfirmationDTO other = (MonthlyAttendanceConfirmationDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getAttendancemonth() {
		return attendancemonth;
	}

	public void setAttendancemonth(String attendancemonth) {
		this.attendancemonth = attendancemonth;
	}

	public String toJSONString() {
		return "{'name':'" + name + "', 'employeeNo':'"
				+ employeeNo + "', 'stakeclass_d':'" + stakeclass_d
				+ "', 'atakeclass_d':'" + atakeclass_d + "', 'mealAllowanced_d':'"
				+ mealAllowanced_d + "', 'stakeclass_n':'" + stakeclass_n
				+ "', 'atakeclass_n':'" + atakeclass_n + "', 'mealAllowanced_n':'"
				+ mealAllowanced_n + "', 'stakeclass_nor':'" + stakeclass_nor
				+ "', 'atakeclass_nor':'" + atakeclass_nor
				+ "', 'mealAllowanced_nor':'" + mealAllowanced_nor
				+ "', 'travelAllowance':'" + travelAllowance + "','installationAllowance':'"
				+ installationAllowance+"', 'overtime_work':'"
				+ overtime_work + "', 'overtime_week':'" + overtime_week
				+ "', 'overtime_holiday':'" + overtime_holiday + "', 'overtime_Rest':'"
				+ overtime_Rest + "', 'rest_personal':'" + rest_personal
				+ "', 'rest_sickness':'" + rest_sickness + "', 'rest_marry':'"
				+ rest_marry + "', 'rest_maternity':'" + rest_maternity
				+ "', 'rest_funeral':'" + rest_funeral + "', 'rest_plan_maternity':'"
				+ rest_plan_maternity + "', 'rest_bruise':'" + rest_bruise
				+ "', 'rest_rest':'" + rest_rest + "', 'rest_annual':'" + rest_annual
				+ "', 'notakeclass':'" + notakeclass + "', 'late':'" + late
				+ "', 'leave_early':'" + leave_early + "', 'nocredit_card':'"
				+ nocredit_card + "', 'lastMounthRest':'" + lastMounthRest
				+ "', 'thisMounthRest':'" + thisMounthRest + "', 'entryDate':'"
				+ entryDate + "', 'annualVacation':'" + annualVacation
				+ "', 'annualVacationBalance':'" + annualVacationBalance
				+ "', 'sickLeave':'" + sickLeave + "', 'sickLeaveBalance':'"
				+ sickLeaveBalance + "', 'is_full_hours':'" + is_full_hours
				+ "', 'attendancetype':'" + attendancetype + "', 'attendancemonth':'"
				+ attendancemonth+"'}";
	}

}
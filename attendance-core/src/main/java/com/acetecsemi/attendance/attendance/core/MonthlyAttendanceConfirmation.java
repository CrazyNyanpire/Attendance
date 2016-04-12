package com.acetecsemi.attendance.attendance.core;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;
@Entity
@Table(name="Attence_MonthlyAttendanceConfirmation")
public class MonthlyAttendanceConfirmation extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6264393878325967998L;
	
	private String name;
	private String employeeNo;
	private String stakeclass_d;
	private String atakeclass_d;
	private String mealAllowanced_d;
	private String stakeclass_n;
	private String atakeclass_n;
	private String mealAllowanced_n;
	private String stakeclass_nor;
	private String atakeclass_nor;
	private String mealAllowanced_nor;
	private String travelAllowance;
	private String installationAllowance;
	private String overtime_work;
	private String overtime_week;
	private String overtime_holiday;
	private String overtime_Rest;
	private String rest_personal;
	private String rest_sickness;
	private String rest_marry;
	private String rest_maternity;
	private String rest_funeral;
	private String rest_plan_maternity;
	private String rest_bruise;
	private String rest_rest;
	private String rest_annual;
	private String notakeclass;
	private String late;
	private String leave_early;
	private String nocredit_card;
	private String lastMounthRest;
	private String thisMounthRest;
	private String entryDate;
	private String annualVacation;
	private String annualVacationBalance;
	private String sickLeave;
	private String sickLeaveBalance;
	private String is_full_hours;
	private String attendancetype;
	private String attendancemonth;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmployeeNo() {
		return employeeNo;
	}


	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}


	public String getStakeclass_d() {
		return stakeclass_d;
	}


	public void setStakeclass_d(String stakeclass_d) {
		this.stakeclass_d = stakeclass_d;
	}


	public String getAtakeclass_d() {
		return atakeclass_d;
	}


	public void setAtakeclass_d(String atakeclass_d) {
		this.atakeclass_d = atakeclass_d;
	}


	public String getMealAllowanced_d() {
		return mealAllowanced_d;
	}


	public void setMealAllowanced_d(String mealAllowanced_d) {
		this.mealAllowanced_d = mealAllowanced_d;
	}


	public String getStakeclass_n() {
		return stakeclass_n;
	}


	public void setStakeclass_n(String stakeclass_n) {
		this.stakeclass_n = stakeclass_n;
	}


	public String getAtakeclass_n() {
		return atakeclass_n;
	}


	public void setAtakeclass_n(String atakeclass_n) {
		this.atakeclass_n = atakeclass_n;
	}


	public String getMealAllowanced_n() {
		return mealAllowanced_n;
	}


	public void setMealAllowanced_n(String mealAllowanced_n) {
		this.mealAllowanced_n = mealAllowanced_n;
	}


	public String getStakeclass_nor() {
		return stakeclass_nor;
	}


	public void setStakeclass_nor(String stakeclass_nor) {
		this.stakeclass_nor = stakeclass_nor;
	}


	public String getAtakeclass_nor() {
		return atakeclass_nor;
	}


	public void setAtakeclass_nor(String atakeclass_nor) {
		this.atakeclass_nor = atakeclass_nor;
	}


	public String getMealAllowanced_nor() {
		return mealAllowanced_nor;
	}


	public void setMealAllowanced_nor(String mealAllowanced_nor) {
		this.mealAllowanced_nor = mealAllowanced_nor;
	}


	public String getTravelAllowance() {
		return travelAllowance;
	}


	public void setTravelAllowance(String travelAllowance) {
		this.travelAllowance = travelAllowance;
	}
	
	public String getInstallationAllowance() {
		return installationAllowance;
	}


	public void setInstallationAllowance(String installationAllowance) {
		this.installationAllowance = installationAllowance;
	}
	

	public String getOvertime_work() {
		return overtime_work;
	}


	public void setOvertime_work(String overtime_work) {
		this.overtime_work = overtime_work;
	}


	public String getOvertime_week() {
		return overtime_week;
	}


	public void setOvertime_week(String overtime_week) {
		this.overtime_week = overtime_week;
	}


	public String getOvertime_holiday() {
		return overtime_holiday;
	}


	public void setOvertime_holiday(String overtime_holiday) {
		this.overtime_holiday = overtime_holiday;
	}


	public String getOvertime_Rest() {
		return overtime_Rest;
	}


	public void setOvertime_Rest(String overtime_Rest) {
		this.overtime_Rest = overtime_Rest;
	}


	public String getRest_personal() {
		return rest_personal;
	}


	public void setRest_personal(String rest_personal) {
		this.rest_personal = rest_personal;
	}


	public String getRest_sickness() {
		return rest_sickness;
	}


	public void setRest_sickness(String rest_sickness) {
		this.rest_sickness = rest_sickness;
	}


	public String getRest_marry() {
		return rest_marry;
	}


	public void setRest_marry(String rest_marry) {
		this.rest_marry = rest_marry;
	}


	public String getRest_maternity() {
		return rest_maternity;
	}


	public void setRest_maternity(String rest_maternity) {
		this.rest_maternity = rest_maternity;
	}


	public String getRest_funeral() {
		return rest_funeral;
	}


	public void setRest_funeral(String rest_funeral) {
		this.rest_funeral = rest_funeral;
	}


	public String getRest_plan_maternity() {
		return rest_plan_maternity;
	}


	public void setRest_plan_maternity(String rest_plan_maternity) {
		this.rest_plan_maternity = rest_plan_maternity;
	}


	public String getRest_bruise() {
		return rest_bruise;
	}


	public void setRest_bruise(String rest_bruise) {
		this.rest_bruise = rest_bruise;
	}


	public String getRest_rest() {
		return rest_rest;
	}


	public void setRest_rest(String rest_rest) {
		this.rest_rest = rest_rest;
	}


	public String getRest_annual() {
		return rest_annual;
	}


	public void setRest_annual(String rest_annual) {
		this.rest_annual = rest_annual;
	}


	public String getNotakeclass() {
		return notakeclass;
	}


	public void setNotakeclass(String notakeclass) {
		this.notakeclass = notakeclass;
	}


	public String getLate() {
		return late;
	}


	public void setLate(String late) {
		this.late = late;
	}


	public String getLeave_early() {
		return leave_early;
	}


	public void setLeave_early(String leave_early) {
		this.leave_early = leave_early;
	}


	public String getNocredit_card() {
		return nocredit_card;
	}


	public void setNocredit_card(String nocredit_card) {
		this.nocredit_card = nocredit_card;
	}


	public String getLastMounthRest() {
		return lastMounthRest;
	}


	public void setLastMounthRest(String lastMounthRest) {
		this.lastMounthRest = lastMounthRest;
	}


	public String getThisMounthRest() {
		return thisMounthRest;
	}


	public void setThisMounthRest(String thisMounthRest) {
		this.thisMounthRest = thisMounthRest;
	}


	public String getEntryDate() {
		return entryDate;
	}


	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}


	public String getAnnualVacation() {
		return annualVacation;
	}


	public void setAnnualVacation(String annualVacation) {
		this.annualVacation = annualVacation;
	}


	public String getAnnualVacationBalance() {
		return annualVacationBalance;
	}


	public void setAnnualVacationBalance(String annualVacationBalance) {
		this.annualVacationBalance = annualVacationBalance;
	}


	public String getSickLeave() {
		return sickLeave;
	}


	public void setSickLeave(String sickLeave) {
		this.sickLeave = sickLeave;
	}


	public String getSickLeaveBalance() {
		return sickLeaveBalance;
	}


	public void setSickLeaveBalance(String sickLeaveBalance) {
		this.sickLeaveBalance = sickLeaveBalance;
	}


	public String getIs_full_hours() {
		return is_full_hours;
	}


	public void setIs_full_hours(String is_full_hours) {
		this.is_full_hours = is_full_hours;
	}


	public String getAttendancetype() {
		return attendancetype;
	}


	public void setAttendancetype(String attendancetype) {
		this.attendancetype = attendancetype;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getAttendancemonth() {
		return attendancemonth;
	}


	public void setAttendancemonth(String attendancemonth) {
		this.attendancemonth = attendancemonth;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((annualVacation == null) ? 0 : annualVacation.hashCode());
		result = prime
				* result
				+ ((annualVacationBalance == null) ? 0 : annualVacationBalance
						.hashCode());
		result = prime * result
				+ ((atakeclass_d == null) ? 0 : atakeclass_d.hashCode());
		result = prime * result
				+ ((atakeclass_n == null) ? 0 : atakeclass_n.hashCode());
		result = prime * result
				+ ((atakeclass_nor == null) ? 0 : atakeclass_nor.hashCode());
		result = prime * result
				+ ((attendancemonth == null) ? 0 : attendancemonth.hashCode());
		result = prime * result
				+ ((attendancetype == null) ? 0 : attendancetype.hashCode());
		result = prime * result
				+ ((employeeNo == null) ? 0 : employeeNo.hashCode());
		result = prime * result
				+ ((entryDate == null) ? 0 : entryDate.hashCode());
		result = prime
				* result
				+ ((installationAllowance == null) ? 0 : installationAllowance
						.hashCode());
		result = prime * result
				+ ((is_full_hours == null) ? 0 : is_full_hours.hashCode());
		result = prime * result
				+ ((lastMounthRest == null) ? 0 : lastMounthRest.hashCode());
		result = prime * result + ((late == null) ? 0 : late.hashCode());
		result = prime * result
				+ ((leave_early == null) ? 0 : leave_early.hashCode());
		result = prime
				* result
				+ ((mealAllowanced_d == null) ? 0 : mealAllowanced_d.hashCode());
		result = prime
				* result
				+ ((mealAllowanced_n == null) ? 0 : mealAllowanced_n.hashCode());
		result = prime
				* result
				+ ((mealAllowanced_nor == null) ? 0 : mealAllowanced_nor
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nocredit_card == null) ? 0 : nocredit_card.hashCode());
		result = prime * result
				+ ((notakeclass == null) ? 0 : notakeclass.hashCode());
		result = prime * result
				+ ((overtime_Rest == null) ? 0 : overtime_Rest.hashCode());
		result = prime
				* result
				+ ((overtime_holiday == null) ? 0 : overtime_holiday.hashCode());
		result = prime * result
				+ ((overtime_week == null) ? 0 : overtime_week.hashCode());
		result = prime * result
				+ ((overtime_work == null) ? 0 : overtime_work.hashCode());
		result = prime * result
				+ ((rest_annual == null) ? 0 : rest_annual.hashCode());
		result = prime * result
				+ ((rest_bruise == null) ? 0 : rest_bruise.hashCode());
		result = prime * result
				+ ((rest_funeral == null) ? 0 : rest_funeral.hashCode());
		result = prime * result
				+ ((rest_marry == null) ? 0 : rest_marry.hashCode());
		result = prime * result
				+ ((rest_maternity == null) ? 0 : rest_maternity.hashCode());
		result = prime * result
				+ ((rest_personal == null) ? 0 : rest_personal.hashCode());
		result = prime
				* result
				+ ((rest_plan_maternity == null) ? 0 : rest_plan_maternity
						.hashCode());
		result = prime * result
				+ ((rest_rest == null) ? 0 : rest_rest.hashCode());
		result = prime * result
				+ ((rest_sickness == null) ? 0 : rest_sickness.hashCode());
		result = prime * result
				+ ((sickLeave == null) ? 0 : sickLeave.hashCode());
		result = prime
				* result
				+ ((sickLeaveBalance == null) ? 0 : sickLeaveBalance.hashCode());
		result = prime * result
				+ ((stakeclass_d == null) ? 0 : stakeclass_d.hashCode());
		result = prime * result
				+ ((stakeclass_n == null) ? 0 : stakeclass_n.hashCode());
		result = prime * result
				+ ((stakeclass_nor == null) ? 0 : stakeclass_nor.hashCode());
		result = prime * result
				+ ((thisMounthRest == null) ? 0 : thisMounthRest.hashCode());
		result = prime * result
				+ ((travelAllowance == null) ? 0 : travelAllowance.hashCode());
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
		MonthlyAttendanceConfirmation other = (MonthlyAttendanceConfirmation) obj;
		if (annualVacation == null) {
			if (other.annualVacation != null)
				return false;
		} else if (!annualVacation.equals(other.annualVacation))
			return false;
		if (annualVacationBalance == null) {
			if (other.annualVacationBalance != null)
				return false;
		} else if (!annualVacationBalance.equals(other.annualVacationBalance))
			return false;
		if (atakeclass_d == null) {
			if (other.atakeclass_d != null)
				return false;
		} else if (!atakeclass_d.equals(other.atakeclass_d))
			return false;
		if (atakeclass_n == null) {
			if (other.atakeclass_n != null)
				return false;
		} else if (!atakeclass_n.equals(other.atakeclass_n))
			return false;
		if (atakeclass_nor == null) {
			if (other.atakeclass_nor != null)
				return false;
		} else if (!atakeclass_nor.equals(other.atakeclass_nor))
			return false;
		if (attendancemonth == null) {
			if (other.attendancemonth != null)
				return false;
		} else if (!attendancemonth.equals(other.attendancemonth))
			return false;
		if (attendancetype == null) {
			if (other.attendancetype != null)
				return false;
		} else if (!attendancetype.equals(other.attendancetype))
			return false;
		if (employeeNo == null) {
			if (other.employeeNo != null)
				return false;
		} else if (!employeeNo.equals(other.employeeNo))
			return false;
		if (entryDate == null) {
			if (other.entryDate != null)
				return false;
		} else if (!entryDate.equals(other.entryDate))
			return false;
		if (installationAllowance == null) {
			if (other.installationAllowance != null)
				return false;
		} else if (!installationAllowance.equals(other.installationAllowance))
			return false;
		if (is_full_hours == null) {
			if (other.is_full_hours != null)
				return false;
		} else if (!is_full_hours.equals(other.is_full_hours))
			return false;
		if (lastMounthRest == null) {
			if (other.lastMounthRest != null)
				return false;
		} else if (!lastMounthRest.equals(other.lastMounthRest))
			return false;
		if (late == null) {
			if (other.late != null)
				return false;
		} else if (!late.equals(other.late))
			return false;
		if (leave_early == null) {
			if (other.leave_early != null)
				return false;
		} else if (!leave_early.equals(other.leave_early))
			return false;
		if (mealAllowanced_d == null) {
			if (other.mealAllowanced_d != null)
				return false;
		} else if (!mealAllowanced_d.equals(other.mealAllowanced_d))
			return false;
		if (mealAllowanced_n == null) {
			if (other.mealAllowanced_n != null)
				return false;
		} else if (!mealAllowanced_n.equals(other.mealAllowanced_n))
			return false;
		if (mealAllowanced_nor == null) {
			if (other.mealAllowanced_nor != null)
				return false;
		} else if (!mealAllowanced_nor.equals(other.mealAllowanced_nor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nocredit_card == null) {
			if (other.nocredit_card != null)
				return false;
		} else if (!nocredit_card.equals(other.nocredit_card))
			return false;
		if (notakeclass == null) {
			if (other.notakeclass != null)
				return false;
		} else if (!notakeclass.equals(other.notakeclass))
			return false;
		if (overtime_Rest == null) {
			if (other.overtime_Rest != null)
				return false;
		} else if (!overtime_Rest.equals(other.overtime_Rest))
			return false;
		if (overtime_holiday == null) {
			if (other.overtime_holiday != null)
				return false;
		} else if (!overtime_holiday.equals(other.overtime_holiday))
			return false;
		if (overtime_week == null) {
			if (other.overtime_week != null)
				return false;
		} else if (!overtime_week.equals(other.overtime_week))
			return false;
		if (overtime_work == null) {
			if (other.overtime_work != null)
				return false;
		} else if (!overtime_work.equals(other.overtime_work))
			return false;
		if (rest_annual == null) {
			if (other.rest_annual != null)
				return false;
		} else if (!rest_annual.equals(other.rest_annual))
			return false;
		if (rest_bruise == null) {
			if (other.rest_bruise != null)
				return false;
		} else if (!rest_bruise.equals(other.rest_bruise))
			return false;
		if (rest_funeral == null) {
			if (other.rest_funeral != null)
				return false;
		} else if (!rest_funeral.equals(other.rest_funeral))
			return false;
		if (rest_marry == null) {
			if (other.rest_marry != null)
				return false;
		} else if (!rest_marry.equals(other.rest_marry))
			return false;
		if (rest_maternity == null) {
			if (other.rest_maternity != null)
				return false;
		} else if (!rest_maternity.equals(other.rest_maternity))
			return false;
		if (rest_personal == null) {
			if (other.rest_personal != null)
				return false;
		} else if (!rest_personal.equals(other.rest_personal))
			return false;
		if (rest_plan_maternity == null) {
			if (other.rest_plan_maternity != null)
				return false;
		} else if (!rest_plan_maternity.equals(other.rest_plan_maternity))
			return false;
		if (rest_rest == null) {
			if (other.rest_rest != null)
				return false;
		} else if (!rest_rest.equals(other.rest_rest))
			return false;
		if (rest_sickness == null) {
			if (other.rest_sickness != null)
				return false;
		} else if (!rest_sickness.equals(other.rest_sickness))
			return false;
		if (sickLeave == null) {
			if (other.sickLeave != null)
				return false;
		} else if (!sickLeave.equals(other.sickLeave))
			return false;
		if (sickLeaveBalance == null) {
			if (other.sickLeaveBalance != null)
				return false;
		} else if (!sickLeaveBalance.equals(other.sickLeaveBalance))
			return false;
		if (stakeclass_d == null) {
			if (other.stakeclass_d != null)
				return false;
		} else if (!stakeclass_d.equals(other.stakeclass_d))
			return false;
		if (stakeclass_n == null) {
			if (other.stakeclass_n != null)
				return false;
		} else if (!stakeclass_n.equals(other.stakeclass_n))
			return false;
		if (stakeclass_nor == null) {
			if (other.stakeclass_nor != null)
				return false;
		} else if (!stakeclass_nor.equals(other.stakeclass_nor))
			return false;
		if (thisMounthRest == null) {
			if (other.thisMounthRest != null)
				return false;
		} else if (!thisMounthRest.equals(other.thisMounthRest))
			return false;
		if (travelAllowance == null) {
			if (other.travelAllowance != null)
				return false;
		} else if (!travelAllowance.equals(other.travelAllowance))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MonthlyAttendanceConfirmation [name=" + name + ", employeeNo="
				+ employeeNo + ", stakeclass_d=" + stakeclass_d
				+ ", atakeclass_d=" + atakeclass_d + ", mealAllowanced_d="
				+ mealAllowanced_d + ", stakeclass_n=" + stakeclass_n
				+ ", atakeclass_n=" + atakeclass_n + ", mealAllowanced_n="
				+ mealAllowanced_n + ", stakeclass_nor=" + stakeclass_nor
				+ ", atakeclass_nor=" + atakeclass_nor
				+ ", mealAllowanced_nor=" + mealAllowanced_nor
				+ ", travelAllowance=" + travelAllowance
				+ ", installationAllowance=" + installationAllowance
				+ ", overtime_work=" + overtime_work + ", overtime_week="
				+ overtime_week + ", overtime_holiday=" + overtime_holiday
				+ ", overtime_Rest=" + overtime_Rest + ", rest_personal="
				+ rest_personal + ", rest_sickness=" + rest_sickness
				+ ", rest_marry=" + rest_marry + ", rest_maternity="
				+ rest_maternity + ", rest_funeral=" + rest_funeral
				+ ", rest_plan_maternity=" + rest_plan_maternity
				+ ", rest_bruise=" + rest_bruise + ", rest_rest=" + rest_rest
				+ ", rest_annual=" + rest_annual + ", notakeclass="
				+ notakeclass + ", late=" + late + ", leave_early="
				+ leave_early + ", nocredit_card=" + nocredit_card
				+ ", lastMounthRest=" + lastMounthRest + ", thisMounthRest="
				+ thisMounthRest + ", entryDate=" + entryDate
				+ ", annualVacation=" + annualVacation
				+ ", annualVacationBalance=" + annualVacationBalance
				+ ", sickLeave=" + sickLeave + ", sickLeaveBalance="
				+ sickLeaveBalance + ", is_full_hours=" + is_full_hours
				+ ", attendancetype=" + attendancetype + ", attendancemonth="
				+ attendancemonth + "]";
	}


	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}

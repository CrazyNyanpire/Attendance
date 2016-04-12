package com.acetecsemi.attendance.attendance.core;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;
@Entity
@Table(name="Attence_informationMaintenance")
public class InformationMaintenance extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 949164153998049627L;
	private String name;
	private String employeeNo;
	private String lastMounthRest;
	private String thisMounthRest;
	private String nowThisMounthRest;
	private Date entryDate;
	private String annualVacation;
	private String annualVacationBalance;
	private String nowAnnualVacationBalance;
	private String sickLeave;
	private String sickLeaveBalance;
	private String nowSickLeaveBalance;
	
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

	public String getNowThisMounthRest() {
		return nowThisMounthRest;
	}

	public void setNowThisMounthRest(String nowThisMounthRest) {
		this.nowThisMounthRest = nowThisMounthRest;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
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

	public String getNowAnnualVacationBalance() {
		return nowAnnualVacationBalance;
	}

	public void setNowAnnualVacationBalance(String nowAnnualVacationBalance) {
		this.nowAnnualVacationBalance = nowAnnualVacationBalance;
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

	public String getNowSickLeaveBalance() {
		return nowSickLeaveBalance;
	}

	public void setNowSickLeaveBalance(String nowSickLeaveBalance) {
		this.nowSickLeaveBalance = nowSickLeaveBalance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
				+ ((employeeNo == null) ? 0 : employeeNo.hashCode());
		result = prime * result
				+ ((entryDate == null) ? 0 : entryDate.hashCode());
		result = prime * result
				+ ((lastMounthRest == null) ? 0 : lastMounthRest.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((nowAnnualVacationBalance == null) ? 0
						: nowAnnualVacationBalance.hashCode());
		result = prime
				* result
				+ ((nowSickLeaveBalance == null) ? 0 : nowSickLeaveBalance
						.hashCode());
		result = prime
				* result
				+ ((nowThisMounthRest == null) ? 0 : nowThisMounthRest
						.hashCode());
		result = prime * result
				+ ((sickLeave == null) ? 0 : sickLeave.hashCode());
		result = prime
				* result
				+ ((sickLeaveBalance == null) ? 0 : sickLeaveBalance.hashCode());
		result = prime * result
				+ ((thisMounthRest == null) ? 0 : thisMounthRest.hashCode());
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
		InformationMaintenance other = (InformationMaintenance) obj;
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
		if (lastMounthRest == null) {
			if (other.lastMounthRest != null)
				return false;
		} else if (!lastMounthRest.equals(other.lastMounthRest))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nowAnnualVacationBalance == null) {
			if (other.nowAnnualVacationBalance != null)
				return false;
		} else if (!nowAnnualVacationBalance
				.equals(other.nowAnnualVacationBalance))
			return false;
		if (nowSickLeaveBalance == null) {
			if (other.nowSickLeaveBalance != null)
				return false;
		} else if (!nowSickLeaveBalance.equals(other.nowSickLeaveBalance))
			return false;
		if (nowThisMounthRest == null) {
			if (other.nowThisMounthRest != null)
				return false;
		} else if (!nowThisMounthRest.equals(other.nowThisMounthRest))
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
		if (thisMounthRest == null) {
			if (other.thisMounthRest != null)
				return false;
		} else if (!thisMounthRest.equals(other.thisMounthRest))
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}
}

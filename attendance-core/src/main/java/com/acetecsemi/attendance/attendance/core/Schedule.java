package com.acetecsemi.attendance.attendance.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;

@Entity
@Table(name = "am_Schedule")
public class Schedule extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6144963794740693492L;

	private Date scheduleDate;

	private int scheduleType;

	private int dutyType;

	@Column(name = "schedule_date")
	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	@Column(name = "schedule_type")
	public int getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(int scheduleType) {
		this.scheduleType = scheduleType;
	}

	@Column(name = "duty_type")
	public int getDutyType() {
		return dutyType;
	}

	public void setDutyType(int dutyType) {
		this.dutyType = dutyType;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dutyType;
		result = prime * result
				+ ((scheduleDate == null) ? 0 : scheduleDate.hashCode());
		result = prime * result + scheduleType;
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
		Schedule other = (Schedule) obj;
		if (dutyType != other.dutyType)
			return false;
		if (scheduleDate == null) {
			if (other.scheduleDate != null)
				return false;
		} else if (!scheduleDate.equals(other.scheduleDate))
			return false;
		if (scheduleType != other.scheduleType)
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}

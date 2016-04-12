package com.acetecsemi.attendance.attendance.core;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;
@Entity
@Table(name="Attence_ClockView")
public class ClockView extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2645636443425592318L;
	private Date attendenceTime;
	private String headcount;
	private String normalInClock;
	private String lateClock;
	private String normalOutClock;
	private String earlyClock;
	private String noNeedInClock;
	private String noNeedOutClock;
	public Date getAttendenceTime() {
		return attendenceTime;
	}


	public void setAttendenceTime(Date attendenceTime) {
		this.attendenceTime = attendenceTime;
	}


	public String getHeadcount() {
		return headcount;
	}


	public void setHeadcount(String headcount) {
		this.headcount = headcount;
	}


	public String getNormalInClock() {
		return normalInClock;
	}


	public void setNormalInClock(String normalInClock) {
		this.normalInClock = normalInClock;
	}


	public String getLateClock() {
		return lateClock;
	}


	public void setLateClock(String lateClock) {
		this.lateClock = lateClock;
	}


	public String getNormalOutClock() {
		return normalOutClock;
	}


	public void setNormalOutClock(String normalOutClock) {
		this.normalOutClock = normalOutClock;
	}


	public String getEarlyClock() {
		return earlyClock;
	}


	public void setEarlyClock(String earlyClock) {
		this.earlyClock = earlyClock;
	}


	public String getNoNeedInClock() {
		return noNeedInClock;
	}


	public void setNoNeedInClock(String noNeedInClock) {
		this.noNeedInClock = noNeedInClock;
	}


	public String getNoNeedOutClock() {
		return noNeedOutClock;
	}


	public void setNoNeedOutClock(String noNeedOutClock) {
		this.noNeedOutClock = noNeedOutClock;
	}


	public String getErroClock() {
		return erroClock;
	}


	public void setErroClock(String erroClock) {
		this.erroClock = erroClock;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private String erroClock;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((attendenceTime == null) ? 0 : attendenceTime.hashCode());
		result = prime * result
				+ ((earlyClock == null) ? 0 : earlyClock.hashCode());
		result = prime * result
				+ ((erroClock == null) ? 0 : erroClock.hashCode());
		result = prime * result
				+ ((headcount == null) ? 0 : headcount.hashCode());
		result = prime * result
				+ ((lateClock == null) ? 0 : lateClock.hashCode());
		result = prime * result
				+ ((noNeedInClock == null) ? 0 : noNeedInClock.hashCode());
		result = prime * result
				+ ((noNeedOutClock == null) ? 0 : noNeedOutClock.hashCode());
		result = prime * result
				+ ((normalInClock == null) ? 0 : normalInClock.hashCode());
		result = prime * result
				+ ((normalOutClock == null) ? 0 : normalOutClock.hashCode());
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
		ClockView other = (ClockView) obj;
		if (attendenceTime == null) {
			if (other.attendenceTime != null)
				return false;
		} else if (!attendenceTime.equals(other.attendenceTime))
			return false;
		if (earlyClock == null) {
			if (other.earlyClock != null)
				return false;
		} else if (!earlyClock.equals(other.earlyClock))
			return false;
		if (erroClock == null) {
			if (other.erroClock != null)
				return false;
		} else if (!erroClock.equals(other.erroClock))
			return false;
		if (headcount == null) {
			if (other.headcount != null)
				return false;
		} else if (!headcount.equals(other.headcount))
			return false;
		if (lateClock == null) {
			if (other.lateClock != null)
				return false;
		} else if (!lateClock.equals(other.lateClock))
			return false;
		if (noNeedInClock == null) {
			if (other.noNeedInClock != null)
				return false;
		} else if (!noNeedInClock.equals(other.noNeedInClock))
			return false;
		if (noNeedOutClock == null) {
			if (other.noNeedOutClock != null)
				return false;
		} else if (!noNeedOutClock.equals(other.noNeedOutClock))
			return false;
		if (normalInClock == null) {
			if (other.normalInClock != null)
				return false;
		} else if (!normalInClock.equals(other.normalInClock))
			return false;
		if (normalOutClock == null) {
			if (other.normalOutClock != null)
				return false;
		} else if (!normalOutClock.equals(other.normalOutClock))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ClockView [attendenceTime=" + attendenceTime + ", headcount="
				+ headcount + ", normalInClock=" + normalInClock
				+ ", lateClock=" + lateClock + ", normalOutClock="
				+ normalOutClock + ", earlyClock=" + earlyClock
				+ ", noNeedInClock=" + noNeedInClock + ", noNeedOutClock="
				+ noNeedOutClock + ", erroClock=" + erroClock + "]";
	}


	@Override
	public String[] businessKeys() {
		return null;
	}

}

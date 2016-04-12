package com.acetecsemi.attendance.attendance.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;

import com.acetecsemi.attendance.attendance.util.MyDateUtils;

@Entity
@Table(name="Attence_ClockDetail")
public class ClockDetail extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6707602985483498720L;
	private Date attenceTime;
	private String employeeNo;
	private String name;
	private String clockIn;
	private String attendenceInType;
	private String clockOut;
	private String attendenceOutType;
	private String attendenceType;


	public Date getAttenceTime() {
		return attenceTime;
	}


	public void setAttenceTime(Date attenceTime) {
		this.attenceTime = attenceTime;
	}


	public String getEmployeeNo() {
		return employeeNo;
	}


	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getClockIn() {
		return clockIn;
	}


	public void setClockIn(String clockIn) {
		this.clockIn = clockIn;
	}


	public String getAttendenceInType() {
		return attendenceInType;
	}


	public void setAttendenceInType(String attendenceInType) {
		this.attendenceInType = attendenceInType;
	}


	public String getClockOut() {
		return clockOut;
	}


	public void setClockOut(String clockOut) {
		this.clockOut = clockOut;
	}


	public String getAttendenceOutType() {
		return attendenceOutType;
	}


	public void setAttendenceOutType(String attendenceOutType) {
		this.attendenceOutType = attendenceOutType;
	}


	public String getAttendenceType() {
		return attendenceType;
	}


	public void setAttendenceType(String attendenceType) {
		this.attendenceType = attendenceType;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((attenceTime == null) ? 0 : attenceTime.hashCode());
		result = prime
				* result
				+ ((attendenceInType == null) ? 0 : attendenceInType.hashCode());
		result = prime
				* result
				+ ((attendenceOutType == null) ? 0 : attendenceOutType
						.hashCode());
		result = prime * result
				+ ((attendenceType == null) ? 0 : attendenceType.hashCode());
		result = prime * result + ((clockIn == null) ? 0 : clockIn.hashCode());
		result = prime * result
				+ ((clockOut == null) ? 0 : clockOut.hashCode());
		result = prime * result
				+ ((employeeNo == null) ? 0 : employeeNo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ClockDetail other = (ClockDetail) obj;
		if (attenceTime == null) {
			if (other.attenceTime != null)
				return false;
		} else if (!attenceTime.equals(other.attenceTime))
			return false;
		if (attendenceInType == null) {
			if (other.attendenceInType != null)
				return false;
		} else if (!attendenceInType.equals(other.attendenceInType))
			return false;
		if (attendenceOutType == null) {
			if (other.attendenceOutType != null)
				return false;
		} else if (!attendenceOutType.equals(other.attendenceOutType))
			return false;
		if (attendenceType == null) {
			if (other.attendenceType != null)
				return false;
		} else if (!attendenceType.equals(other.attendenceType))
			return false;
		if (clockIn == null) {
			if (other.clockIn != null)
				return false;
		} else if (!clockIn.equals(other.clockIn))
			return false;
		if (clockOut == null) {
			if (other.clockOut != null)
				return false;
		} else if (!clockOut.equals(other.clockOut))
			return false;
		if (employeeNo == null) {
			if (other.employeeNo != null)
				return false;
		} else if (!employeeNo.equals(other.employeeNo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ClockDetail [attenceTime=" + attenceTime + ", employeeNo="
				+ employeeNo + ", name=" + name + ", clockIn=" + clockIn
				+ ", attendenceInType=" + attendenceInType + ", clockOut="
				+ clockOut + ", attendenceOutType=" + attendenceOutType
				+ ", attendenceType=" + attendenceType + "]";
	}


	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ClockDetail> queryAttenceRecordDetailList(String startDate ,String endDate){
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _clockDetail from ClockDetail _clockDetail   where 1=1 ");
   		jpql.append(" and _clockDetail.attenceTime between ? and ? ");
   		conditionVals.add(MyDateUtils.str2Date(startDate, MyDateUtils.DefFormatString));
   		conditionVals.add(MyDateUtils.str2Date(endDate, MyDateUtils.DefFormatString));
	   	jpql.append(" order by _clockDetail.attenceTime DESC");
        List<ClockDetail> list = getRepository().createJpqlQuery(jpql.toString()).setParameters(conditionVals).list();
		return list;
	}

}

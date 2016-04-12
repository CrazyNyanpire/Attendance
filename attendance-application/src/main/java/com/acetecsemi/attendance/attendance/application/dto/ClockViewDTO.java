package com.acetecsemi.attendance.attendance.application.dto;

import java.util.Date;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.openkoala.koala.springmvc.JsonDateSerializer;


public class ClockViewDTO implements Serializable {

	private Long id;

		
	private String noNeedInClock;
	
		
	private String erroClock;
	
		
	private String normalOutClock;
	
		
	private String noNeedOutClock;
	
		
	private String headcount;
	
		
	private String earlyClock;
	
		
	private String lateClock;
	
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date attendenceTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date attendenceTimeEnd;
		
	private String normalInClock;
	
			
		

	public void setNoNeedInClock(String noNeedInClock) { 
		this.noNeedInClock = noNeedInClock;
	}

	public String getNoNeedInClock() {
		return this.noNeedInClock;
	}
	
			
		

	public void setErroClock(String erroClock) { 
		this.erroClock = erroClock;
	}

	public String getErroClock() {
		return this.erroClock;
	}
	
			
		

	public void setNormalOutClock(String normalOutClock) { 
		this.normalOutClock = normalOutClock;
	}

	public String getNormalOutClock() {
		return this.normalOutClock;
	}
	
			
		

	public void setNoNeedOutClock(String noNeedOutClock) { 
		this.noNeedOutClock = noNeedOutClock;
	}

	public String getNoNeedOutClock() {
		return this.noNeedOutClock;
	}
	
			
		

	public void setHeadcount(String headcount) { 
		this.headcount = headcount;
	}

	public String getHeadcount() {
		return this.headcount;
	}
	
			
		

	public void setEarlyClock(String earlyClock) { 
		this.earlyClock = earlyClock;
	}

	public String getEarlyClock() {
		return this.earlyClock;
	}
	
			
		

	public void setLateClock(String lateClock) { 
		this.lateClock = lateClock;
	}

	public String getLateClock() {
		return this.lateClock;
	}
	
			
		

	public void setAttendenceTime(Date attendenceTime) { 
		this.attendenceTime = attendenceTime;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getAttendenceTime() {
		return this.attendenceTime;
	}
	
	public void setAttendenceTimeEnd(Date attendenceTimeEnd) { 
		this.attendenceTimeEnd = attendenceTimeEnd;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getAttendenceTimeEnd() {
		return this.attendenceTimeEnd;
	}
			
		

	public void setNormalInClock(String normalInClock) { 
		this.normalInClock = normalInClock;
	}

	public String getNormalInClock() {
		return this.normalInClock;
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
		ClockViewDTO other = (ClockViewDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
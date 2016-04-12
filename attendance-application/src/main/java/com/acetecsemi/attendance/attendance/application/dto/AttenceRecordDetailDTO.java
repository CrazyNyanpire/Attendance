package com.acetecsemi.attendance.attendance.application.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.openkoala.koala.springmvc.JsonDateSerializer;

import com.acetecsemi.attendance.attendance.application.util.JsonDateSerializerDefDate;


public class AttenceRecordDetailDTO extends CopyTableListAbstractDTO implements Serializable {

	private Long id;

						
	private Long attenceRecordFileId;
	
		
	private String employeeNo;
	
		
	private String attenceType;
	
		
	private String empolyeeName;
	
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date attenceTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date attenceTimeEnd;
								
	private Date optDate;
		

	public void setAttenceRecordFileId(Long attenceRecordFileId) { 
		this.attenceRecordFileId = attenceRecordFileId;
	}

	public Long getAttenceRecordFileId() {
		return this.attenceRecordFileId;
	}
	
			
		

	public void setEmployeeNo(String employeeNo) { 
		this.employeeNo = employeeNo;
	}

	public String getEmployeeNo() {
		return this.employeeNo;
	}
	
			
		

	public void setAttenceType(String attenceType) { 
		this.attenceType = attenceType;
	}

	public String getAttenceType() {
		return this.attenceType;
	}
	
			
		

	public void setEmpolyeeName(String empolyeeName) { 
		this.empolyeeName = empolyeeName;
	}

	public String getEmpolyeeName() {
		return this.empolyeeName;
	}
	
			
		

	public void setAttenceTime(Date attenceTime) { 
		this.attenceTime = attenceTime;
	}

	@JsonSerialize(using = JsonDateSerializerDefDate.class)
	public Date getAttenceTime() {
		return this.attenceTime;
	}
	
	public void setAttenceTimeEnd(Date attenceTimeEnd) { 
		this.attenceTimeEnd = attenceTimeEnd;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getAttenceTimeEnd() {
		return this.attenceTimeEnd;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	@JsonSerialize(using = JsonDateSerializerDefDate.class)
    public Date getOptDate() {
		return optDate;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
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
		AttenceRecordDetailDTO other = (AttenceRecordDetailDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toJSONString() {
		DateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");        
		String strattenceTime=null;
		strattenceTime=format.format(attenceTime);
		return "{'attenceTime':'" + strattenceTime
				+ "', 'attenceType':'" + attenceType + "', 'employeeNo':'" + employeeNo
				+ "', 'empolyeeName':'" + empolyeeName + "', 'attenceRecordFileId':'"
				+ attenceRecordFileId + "'}";
	}
}
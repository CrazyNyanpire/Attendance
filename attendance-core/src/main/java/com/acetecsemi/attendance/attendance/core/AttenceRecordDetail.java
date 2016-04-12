package com.acetecsemi.attendance.attendance.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.dayatang.domain.SqlQuery;
import org.dayatang.utils.DateUtils;
import org.openkoala.koala.commons.domain.KoalaAbstractEntity;

import com.acetecsemi.attendance.attendance.core.AttenceRecordDetail;
import com.acetecsemi.attendance.attendance.core.SheduleScope;
import com.acetecsemi.attendance.attendance.util.MyDateUtils;

@Entity
@Table(name="Attence_attenceRecordDetail")
public class AttenceRecordDetail extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6369349236573335211L;
	private Date attenceTime;
	private String attenceType;
	private String employeeNo;
	private String empolyeeName;
	private long attenceRecordFileId;
	private Date optDate;

	public Date getAttenceTime() {
		return attenceTime;
	}

	public void setAttenceTime(Date attenceTime) {
		this.attenceTime = attenceTime;
	}

	public String getAttenceType() {
		return attenceType;
	}

	public void setAttenceType(String attenceType) {
		this.attenceType = attenceType;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmpolyeeName() {
		return empolyeeName;
	}

	public void setEmpolyeeName(String empolyeeName) {
		this.empolyeeName = empolyeeName;
	}

	public long getAttenceRecordFileId() {
		return attenceRecordFileId;
	}

	public void setAttenceRecordFileId(long attenceRecordFileId) {
		this.attenceRecordFileId = attenceRecordFileId;
	}

	public Date getOptDate() {
		return optDate;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ (int) (attenceRecordFileId ^ (attenceRecordFileId >>> 32));
		result = prime * result
				+ ((attenceTime == null) ? 0 : attenceTime.hashCode());
		result = prime * result
				+ ((attenceType == null) ? 0 : attenceType.hashCode());
		result = prime * result
				+ ((employeeNo == null) ? 0 : employeeNo.hashCode());
		result = prime * result
				+ ((empolyeeName == null) ? 0 : empolyeeName.hashCode());
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
		AttenceRecordDetail other = (AttenceRecordDetail) obj;
		if (attenceRecordFileId != other.attenceRecordFileId)
			return false;
		if (attenceTime == null) {
			if (other.attenceTime != null)
				return false;
		} else if (!attenceTime.equals(other.attenceTime))
			return false;
		if (attenceType == null) {
			if (other.attenceType != null)
				return false;
		} else if (!attenceType.equals(other.attenceType))
			return false;
		if (employeeNo == null) {
			if (other.employeeNo != null)
				return false;
		} else if (!employeeNo.equals(other.employeeNo))
			return false;
		if (empolyeeName == null) {
			if (other.empolyeeName != null)
				return false;
		} else if (!empolyeeName.equals(other.empolyeeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AttenceRecordDetail [attenceTime=" + attenceTime
				+ ", attenceType=" + attenceType + ", employeeNo=" + employeeNo
				+ ", empolyeeName=" + empolyeeName + ", attenceRecordFileId="
				+ attenceRecordFileId + "]";
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
	
	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SheduleScope> querySheduleScopeList(String startDate ,String endDate){
		StringBuilder jpql = new StringBuilder();
		jpql.append("select b.user_accounts,b.user_name,b.duty_type,CASE WHEN a.schedule_type = '2 '  THEN date_sub(a.schedule_date,INTERVAL 0 DAY)  ELSE  a.schedule_date END,a.schedule_type,"
				//+ "DATE_SUB(DATE_ADD(a.schedule_date,INTERVAL c.start_date HOUR_SECOND),INTERVAL 6 HOUR) work_start_start,"
				//+ "DATE_ADD(a.schedule_date,INTERVAL c.start_date HOUR_SECOND) work_start_end ,"
				//+ "DATE_ADD(DATE_ADD(a.schedule_date,INTERVAL c.start_date HOUR_SECOND),INTERVAL 12 HOUR) work_end_start,"
				//+ "DATE_ADD(DATE_ADD(a.schedule_date,INTERVAL c.start_date HOUR_SECOND),INTERVAL 24-6 HOUR) work_end_end,"
				+ "c.start_date,c.end_date,c.time_area,c.scope,c.work_hours "
				+ "from (select * from am_schedule where duty_type <> 0) a "
				+ "inner join user b on a.duty_type = b.duty_type "
				+ "inner join attence_schedule c on a.schedule_type = c.schedule_type "
				+ "where a.schedule_date between '" + startDate +"' and '" + endDate + "' ");
		SqlQuery query = getRepository().createSqlQuery(jpql.toString());
		// 执行查询，返回的是查询属性值数组的集合
		
		List objecArraytList = query.list();
		List <SheduleScope> sheduleScopeList = new ArrayList<SheduleScope>();
		for (int i = 0; i < objecArraytList.size(); i++) {
			Object[] obj = (Object[]) objecArraytList.get(i);
			SheduleScope ss = new SheduleScope();
			if(obj[0] == null)
				continue ;
			String formater = MyDateUtils.formater;
			ss.setEmployeeNo(obj[0].toString());
			ss.setEmployeeName(obj[1].toString());
			ss.setDutyType(obj[2].toString());
			ss.setScheduleDate(MyDateUtils.formaterDate((Date)obj[3],MyDateUtils.DefFormatString));
			ss.setScheduleType(obj[4].toString());
			ss.setStartDate(obj[5].toString());
			ss.setEndDate(obj[6].toString());
			ss.setTimeArea(obj[7].toString());
			Date workStartEnd = MyDateUtils.str2Date(ss.getScheduleDate() + " " + ss.getStartDate(), formater);
			ss.setWorkStartStart(MyDateUtils.formaterDate(MyDateUtils.addHours(workStartEnd,-Integer.parseInt(obj[8].toString())), formater));
			ss.setWorkStartEnd(ss.getScheduleDate() + " " + ss.getStartDate());
			String workEndStart = MyDateUtils.formaterDate(MyDateUtils.addHours(workStartEnd,Integer.parseInt(obj[9].toString())), formater);
			//ss.setWorkEndStart(MyDateUtils.formaterDate(MyDateUtils.addHours(workStartEnd,Integer.parseInt(obj[9].toString())), formater));
			ss.setWorkEndStart(workEndStart.split(" ")[0]+ " " + ss.getEndDate());
			ss.setWorkEndEnd(MyDateUtils.formaterDate(MyDateUtils.addHours(workStartEnd,24-Integer.parseInt(obj[8].toString())), formater));
			sheduleScopeList.add(ss);
		}
		return sheduleScopeList;
	}
	
	public List<AttenceRecordDetail> queryAttenceRecordDetailList(String employeeNo ,String startDate ,String endDate ,String conditions){
		StringBuilder jpql = new StringBuilder();

		jpql.append("select employeeNo,empolyeeName,attenceTime,id,attenceRecordFileId,version from attence_attencerecorddetail "
				+ "where employeeNo = '" + employeeNo + "' and attenceTime between '" + startDate +"' and '" + endDate + "' ");
		if(conditions != null){
			jpql.append(conditions);
		}
		SqlQuery query = getRepository().createSqlQuery(jpql.toString());
		// 执行查询，返回的是查询属性值数组的集合
		List objecArraytList = query.list();
		List<AttenceRecordDetail> attenceRecordDetailDTOList = new ArrayList<AttenceRecordDetail>();
		for (int i = 0; i < objecArraytList.size(); i++) {
			Object[] obj = (Object[]) objecArraytList.get(i);
			AttenceRecordDetail ard = new AttenceRecordDetail();
			ard.setEmployeeNo(obj[0].toString());
			ard.setEmpolyeeName(obj[1].toString());
			ard.setAttenceTime((Date)obj[2]);
			ard.setId(Long.parseLong(obj[3].toString()));
			ard.setAttenceRecordFileId(Long.parseLong(obj[4].toString()));
			ard.setVersion(Integer.parseInt(obj[5].toString()));
			attenceRecordDetailDTOList.add(ard);
		}
		return attenceRecordDetailDTOList;
	}
	
	public List<AttenceRecordDetail> queryAttenceRecordDetailList(String startDate ,String endDate ,String conditions){
		StringBuilder jpql = new StringBuilder();

		jpql.append("select employeeNo,empolyeeName,attenceTime,id,attenceRecordFileId,version,optDate,attenceType from attence_attencerecorddetail "
				+ "where attenceTime between '" + startDate +"' and '" + endDate + "' order by attenceTime");
		if(conditions != null){
			jpql.append(conditions);
		}
		SqlQuery query = getRepository().createSqlQuery(jpql.toString());
		// 执行查询，返回的是查询属性值数组的集合
		List objecArraytList = query.list();
		List<AttenceRecordDetail> attenceRecordDetailDTOList = new ArrayList<AttenceRecordDetail>();
		for (int i = 0; i < objecArraytList.size(); i++) {
			Object[] obj = (Object[]) objecArraytList.get(i);
			AttenceRecordDetail ard = new AttenceRecordDetail();
			ard.setEmployeeNo(obj[0].toString());
			ard.setEmpolyeeName(obj[1].toString());
			ard.setAttenceTime((Date)obj[2]);
			ard.setId(Long.parseLong(obj[3].toString()));
			ard.setAttenceRecordFileId(Long.parseLong(obj[4].toString()));
			ard.setVersion(Integer.parseInt(obj[5].toString()));
			ard.setOptDate((Date)obj[6]);
			if(obj[7] != null)
				ard.setAttenceType(obj[7].toString());
			attenceRecordDetailDTOList.add(ard);
		}
		return attenceRecordDetailDTOList;
	}
	
	public Object[] queryDateScope(String startDate ,String endDate ,String conditions){
		StringBuilder jpql = new StringBuilder();

		jpql.append("select min(attenceTime),max(attenceTime) from attence_attencerecorddetail " 
				+ "where optDate between '" + startDate +"' and '" + endDate + "' ");
		if(conditions != null){
			jpql.append(conditions);
		}
		SqlQuery query = getRepository().createSqlQuery(jpql.toString());
		// 执行查询，返回的是查询属性值数组的集合
		List objecArraytList = query.list();
		for (int i = 0; i < objecArraytList.size(); i++) {
			Object[] obj = (Object[]) objecArraytList.get(i);
			return obj;
		}
		return null;
	}
	
	public List<Object[]> queryUserList(){
		StringBuilder jpql = new StringBuilder();
		//jpql.append("select user_accounts,user_name,duty_type from user where user_accounts ='0385'");
		jpql.append("select user_accounts,user_name,duty_type from user a INNER JOIN department b on a.DEPT_ID = b.DEPT_ID where user_accounts is not null and user_accounts != 'admin' and b.FLAG = '1'");
		SqlQuery query = getRepository().createSqlQuery(jpql.toString());
		// 执行查询，返回的是查询属性值数组的集合
		List <Object[]> objecArraytList = query.list();
		return objecArraytList;
	}
	
	public List<Object[]> queryUserList(String startDate,String endDate,int fileOrDB){
		StringBuilder jpql = new StringBuilder();
		//jpql.append("select user_accounts,user_name,duty_type from user where user_accounts ='0385'"
		jpql.append("select distinct employeeNo,empolyeeName,duty_type from attence_attencerecorddetail where optdate between '" 
		+ startDate +"' and '" + endDate + "' and fileOrDB = " + fileOrDB);
		SqlQuery query = getRepository().createSqlQuery(jpql.toString());
		// 执行查询，返回的是查询属性值数组的集合
		List <Object[]> objecArraytList = query.list();
		return objecArraytList;
	}
}

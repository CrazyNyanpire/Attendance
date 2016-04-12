package com.acetecsemi.attendance.attendance.application.impl.core;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.text.ParseException;

import javax.inject.Named;
import javax.persistence.OptimisticLockException;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.acetecsemi.attendance.attendance.application.core.AttenceRecordJobApplication;
import com.acetecsemi.attendance.attendance.core.*;
import com.acetecsemi.attendance.attendance.util.MyDateUtils;

/**
 * 用于定时任务处理刷卡数据
 * @author harlow
 * 
 */
@Named
@Transactional(readOnly = true)
public class AttenceRecordJobApplicationImpl implements
		AttenceRecordJobApplication {

	Logger log = Logger.getLogger(AttenceRecordJobApplicationImpl.class);

	private List<ClockDetail> clockDetailList;
	
	private List <String> typeList;
	
    public List<ClockDetail> getClockDetailList() {
		return clockDetailList;
	}

	public void setClockDetailList(List<ClockDetail> clockDetailList) {
		this.clockDetailList = clockDetailList;
	}

	/**
     * 用于测试webService
     *
     * @return 测试字符串
     */
	public String doTest(){
		log.info("doTest");
		return "doTest";
	}
	
    /**
     * 处理考勤日刷卡记录
     *
     * @return 是否成功处理
     */
	@Transactional(propagation = Propagation.REQUIRED, timeout=3000)
	public String doAttenceRecordDetailTypeDuty(String type) {
		Timestamp timestamp = this.findTimestamp(type);
		String startDate = timestamp.getLastTimestamp();
		String endDate = timestamp.getTimestamp();
		List<String> dateList = null;

		AttenceRecordDetail attenceRecordDetail = new AttenceRecordDetail();
		Object[] dateScope = attenceRecordDetail.queryDateScope(startDate, endDate, " and fileOrDB = " + Integer.parseInt(type));
		String beforeStartDateOneDay = "";
		String afterEndDateOneDay = "";
		if(dateScope == null || dateScope[0] == null){
			timestamp.setDoNext(1);
			timestamp.save();
			return "no data!";
		}else{
			startDate = dateScope[0].toString().split(" ")[0];
			beforeStartDateOneDay = MyDateUtils.getNewDayNumDate(startDate, -1);
			endDate = dateScope[1].toString().split(" ")[0];
			afterEndDateOneDay = MyDateUtils.getNewDayNumDate(endDate, 1);;
		}
		List<Object[]> userList = null;
		if(Integer.parseInt(type) == 1 ){
			userList = attenceRecordDetail.queryUserList();
		}else{
			userList = attenceRecordDetail.queryUserList(startDate, endDate,Integer.parseInt(type));
		}
		try {
			dateList = MyDateUtils.getDateList(dateScope[0].toString(), dateScope[1].toString());
		} catch (ParseException e) {
			e.printStackTrace();
			log.error("startDate : " + startDate + "  endDate : " + endDate);
			return "error!";
		}
		//List<Object[]> userList = attenceRecordDetail.queryUserList();
		
		List<SheduleScope> sheduleScopeList = attenceRecordDetail
				.querySheduleScopeList(startDate, afterEndDateOneDay);
		List<AttenceRecordDetail> attenceRecordDetailList = attenceRecordDetail.queryAttenceRecordDetailList(beforeStartDateOneDay, afterEndDateOneDay,"");
		ClockDetail clockDetail = new ClockDetail();
		this.setClockDetailList(clockDetail.queryAttenceRecordDetailList(beforeStartDateOneDay, afterEndDateOneDay));
		
		// 员工遍历
		for (Object[] user : userList) {			
			this.doAttenceRecordDetailTypByUserDuty(user,sheduleScopeList,attenceRecordDetailList,dateList);
		}
		timestamp.setDoNext(1);
		timestamp.save();
		return "successful!";
	}
	
    /**
     * 处理非考勤日刷卡记录
     *
     * @return 是否成功处理
     */
	@Transactional(propagation = Propagation.REQUIRED, timeout=3000)
	public String doAttenceRecordDetailTypeNoDuty(String type) {
		Timestamp timestamp = this.findTimestamp(type);
		String startDate = timestamp.getLastTimestamp();
		String endDate = timestamp.getTimestamp();
		Timestamp timestampMonth = this.findTimestamp("6");
		List<String> dateList = null;
		AttenceRecordDetail attenceRecordDetail = new AttenceRecordDetail();
		Object[] dateScope = attenceRecordDetail.queryDateScope(startDate, endDate, " and fileOrDB = " + Integer.parseInt(type));
		List<Object[]> userList = null;
		if(Integer.parseInt(type) == 1 ){
			userList = attenceRecordDetail.queryUserList();
		}else{
			userList = attenceRecordDetail.queryUserList(startDate, endDate,Integer.parseInt(type));
		}
		String beforeStartDateOneDay = "";
		String afterEndDateOneDay = "";
		if(dateScope == null || dateScope[0] == null){
			return "no data!";
		}else{
			if(dateScope[0].toString().split(" ")[0].compareTo(timestampMonth.getTimestamp()) <= 0){
				startDate = dateScope[0].toString().split(" ")[0];
			}else{
				startDate = timestampMonth.getTimestamp();
			}
			beforeStartDateOneDay = MyDateUtils.getNewDayNumDate(startDate, -1);
			endDate = dateScope[1].toString().split(" ")[0];
			afterEndDateOneDay = MyDateUtils.getNewDayNumDate(endDate, 1);;
		}
		try {
			dateList = MyDateUtils.getDateList(startDate,endDate);
		} catch (ParseException e) {
			e.printStackTrace();
			log.error("startDate : " + startDate + "  endDate : " + endDate);
			return "error!";
		}
		
		List<SheduleScope> sheduleScopeList = attenceRecordDetail
				.querySheduleScopeList(startDate, afterEndDateOneDay);
		
		List<AttenceRecordDetail> attenceRecordDetailList = attenceRecordDetail.queryAttenceRecordDetailList(beforeStartDateOneDay, afterEndDateOneDay,"");
		ClockDetail clockDetail = new ClockDetail();
		this.setClockDetailList(clockDetail.queryAttenceRecordDetailList(beforeStartDateOneDay, afterEndDateOneDay));
		
		// 员工遍历
		for (Object[] user : userList) {
			this.doAttenceRecordDetailTypByUserNoDuty(user,sheduleScopeList,attenceRecordDetailList,dateList);
		}
		return "successful!";
	}

    /**
     * 通过emplyeeNo获取雇员考勤日历
     *
     * @return 考勤日时间范围列表
     */
	private List<SheduleScope> getUserSheduleScopeList(String emplyeeNo,
			List<SheduleScope> sheduleScopeList) {
		List<SheduleScope> userSheduleScopeList = new ArrayList<SheduleScope>();
		for (SheduleScope ss : sheduleScopeList) {
			if (ss.getEmployeeNo().equals(emplyeeNo)) {
				userSheduleScopeList.add(ss);
			}
		}
		return userSheduleScopeList;
	}

	/**
	 * 获取一个时间段内的刷卡记录
	 * @param startDate
	 * @param endDate
	 * @param attenceRecordDetailsList
	 * @return 刷卡记录列表
	 */
	private List<AttenceRecordDetail> attenceRecordDetailList(String startDate , String endDate,List<AttenceRecordDetail> attenceRecordDetailsList){
		List<AttenceRecordDetail> attenceRecordDetailList = new ArrayList<AttenceRecordDetail>();
		for(AttenceRecordDetail ard : attenceRecordDetailsList){
			if(MyDateUtils.formaterDate(ard.getAttenceTime(), MyDateUtils.DefFormatString).equals(startDate)){
				attenceRecordDetailList.add(ard);
			}
		}
		return attenceRecordDetailList;
	}
	
	/**
	 * 处理一个雇员的非考勤日刷卡记录
	 * @param user
	 * @param sheduleScopeList
	 * @param attenceRecordDetailList
	 * @param dateList
	 */
	private void doAttenceRecordDetailTypByUserNoDuty(Object [] user, List<SheduleScope> sheduleScopeList, List<AttenceRecordDetail> attenceRecordDetailList, List<String> dateList){
		if(user[0] == null){
			return;
		}
		List<SheduleScope> userSheduleScopeList = this
				.getUserSheduleScopeList(user[0].toString(),
						sheduleScopeList);
		
		// 日期遍历
		List<String> noDutyDateList = new ArrayList<String>();
		for (String date : dateList) {
			// 遍历员工考勤日历
			boolean isDuty = false;
			for (SheduleScope sheduleScope : userSheduleScopeList) {
				if (date.equals(sheduleScope.getScheduleDate())) {
					isDuty = true;
					break;
				}
			}
			if (!isDuty)
				noDutyDateList.add(date);
		}
		List<AttenceRecordDetail> attenceRecordDetailListByemployeeNo = this.attenceRecordDetailListByEmployeeNo(user[0].toString(),attenceRecordDetailList);
		List<ClockDetail> clockDetailListByEmployeeNo = this.clockDetailListByEmployeeNo(user[0].toString(), this.getClockDetailList());
		// 非考勤日遍历-非考勤日处理
		//List <ClockDetail> clockDetailList = 
		this.saveNoDutyType(user[0].toString(), user[1].toString(),user[2].toString(),
					noDutyDateList,attenceRecordDetailListByemployeeNo,clockDetailListByEmployeeNo,userSheduleScopeList);
	}
	
	/**
	 * 处理一个雇员的考勤日刷卡记录
	 * @param user
	 * @param sheduleScopeList
	 * @param attenceRecordDetailList
	 * @param dateList
	 */
	public void doAttenceRecordDetailTypByUserDuty(Object [] user, List<SheduleScope> sheduleScopeList, List<AttenceRecordDetail> attenceRecordDetailList, List<String> dateList){
		if(user[0] == null){
			return;
		}
		List<SheduleScope> userSheduleScopeList = this
				.getUserSheduleScopeList(user[0].toString(),
						sheduleScopeList);
		List<AttenceRecordDetail> attenceRecordDetailListByemployeeNo = this.attenceRecordDetailListByEmployeeNo(user[0].toString(),attenceRecordDetailList);
		List<ClockDetail> clockDetailListByEmployeeNo = this.clockDetailListByEmployeeNo(user[0].toString(), this.getClockDetailList());
		// 考勤日遍历-考勤日处理
		StringBuffer ssDate = new StringBuffer();
		for (SheduleScope sheduleScope : userSheduleScopeList) {
			ssDate.append(sheduleScope.getScheduleDate()).append("|");
		}
		for (SheduleScope sheduleScope : userSheduleScopeList) {
				this.saveDutyType(sheduleScope,attenceRecordDetailListByemployeeNo,clockDetailListByEmployeeNo,userSheduleScopeList,ssDate.toString());
		}
		

	}
	
	/**
	 * 获取一个雇员的刷卡记录
	 * @param employeeNo
	 * @param attenceRecordDetailsList
	 * @return 
	 */
	private List<AttenceRecordDetail> attenceRecordDetailListByEmployeeNo(String employeeNo,List<AttenceRecordDetail> attenceRecordDetailsList){
		List<AttenceRecordDetail> attenceRecordDetailList = new ArrayList<AttenceRecordDetail>();
		for(AttenceRecordDetail ard : attenceRecordDetailsList){
			if(ard.getEmployeeNo().equals(employeeNo)){
				attenceRecordDetailList.add(ard);
			}
		}
		return attenceRecordDetailList;
	}
	
	/**
	 * 获取一个雇员的刷卡原始记录
	 * @param employeeNo
	 * @param attenceRecordDetailsList
	 * @return 
	 */
	private List<ClockDetail> clockDetailListByEmployeeNo(String employeeNo,List<ClockDetail> clockDetailList){
		List<ClockDetail> clockDetailEmployeeList = new ArrayList<ClockDetail>();
		for(ClockDetail ard : clockDetailList){
			if(ard.getEmployeeNo().equals(employeeNo)){
				clockDetailEmployeeList.add(ard);
			}
		}
		return clockDetailEmployeeList;
	}
	
	/**
	 * @name saveNoDutyType
	 * @param employeeNo
	 *            ,ss
	 * @description 保存员工非考勤日数据
	 */
	@Transactional(readOnly = false)
	private void saveNoDutyType(String employeeNo, String employeeName,String dutyType,
			List<String> noDutyDateList,List<AttenceRecordDetail> attenceRecordDetailsList,List<ClockDetail> clockDetailListByEmployeeNo,List<SheduleScope> userSheduleScopeList) {
		if(this.checkNoAttence(employeeNo)){
			return;
		}
		for (int index = 0 ; index < noDutyDateList.size(); index ++ ) {
			String noDutyDate = noDutyDateList.get(index);
			List<AttenceRecordDetail> attenceRecordDetailList = this.attenceRecordDetailList(noDutyDate, null, attenceRecordDetailsList);
			boolean isFirst = true;
			boolean isWork = false;
			ClockDetail clockDetail = this
					.findClockDetailByEmployeeNoAndAttenceTime(employeeNo, noDutyDate,clockDetailListByEmployeeNo);
			//if(clockDetail != null)
			//	clockDetail.remove();
			//
			if(clockDetail == null){
				clockDetail = new ClockDetail();
			}

			clockDetail.setAttenceTime(MyDateUtils.str2Date(noDutyDate,
					MyDateUtils.DefFormatString));
			clockDetail.setEmployeeNo(employeeNo);
			clockDetail.setName(employeeName);

			for (int i = 0; i < attenceRecordDetailList.size(); i++) {
				AttenceRecordDetail ard = attenceRecordDetailList.get(i);
				ard.setAttenceType("7");// 7:无效刷卡
				String attenceTime = MyDateUtils.formaterDate(ard.getAttenceTime(),
						MyDateUtils.formater);
				if(this.checkLastDayIsWork(userSheduleScopeList, noDutyDate) && i == 0){
					continue;
				}
				if (isFirst) {
					if(Integer.parseInt(dutyType) > 10)
						ard.setAttenceType(this.getNoDutyType(attenceTime.split(" ")[1]));
					else
						ard.setAttenceType("11");// 11:非考勤日上班打卡
					isFirst = false;
					if("24".equals(ard.getAttenceType())){
						ClockDetail lastClockDetail = this
								.findClockDetailByEmployeeNoAndAttenceTime(employeeNo, MyDateUtils.getNewDayNumDate(noDutyDate, -1),clockDetailListByEmployeeNo);
						if(lastClockDetail != null && "23".equals(lastClockDetail.getAttendenceInType())){
							lastClockDetail.setAttendenceOutType(ard.getAttenceType());
							lastClockDetail.setClockOut(attenceTime);
							lastClockDetail.save();
							isFirst = true;
							continue;
						}else{
//							if(clockDetail.getId() != null){
//								clockDetail.remove();
//							}
							ard.setAttenceType(null);
						}
					}else{
						clockDetail.setAttendenceInType(ard.getAttenceType());
						clockDetail.setClockIn(attenceTime);
						clockDetail.setAttendenceType("1");
					}
				}

				if (i == attenceRecordDetailList.size() - 1 && i > 0) {
					if(Integer.parseInt(dutyType) > 10)
						ard.setAttenceType(this.getNoDutyType(attenceTime.split(" ")[1]));
					else
						ard.setAttenceType("12");// 12:非考勤日下班打卡
					if("23".equals(ard.getAttenceType())){
						clockDetail.setAttendenceInType(ard.getAttenceType());
						clockDetail.setClockIn(attenceTime);
						clockDetail.setAttendenceType("2");
					}else{
						clockDetail.setAttendenceOutType(ard.getAttenceType());
						clockDetail.setClockOut(attenceTime);
					}
				}
				// ard.setVersion(1);
				if (ard.getAttenceType() != null) {
					ard.save();
					isWork = true;
				}
			}
			if (isWork) {
				clockDetail.save();
			}
		}
		
	}
	
	private boolean checkLastDayIsWork(List<SheduleScope> userSheduleScopeList,String noDutyDate){
		noDutyDate = MyDateUtils.addDays(noDutyDate, -1);
		for(SheduleScope sheduleScope : userSheduleScopeList){
			if(noDutyDate.equals(sheduleScope.getScheduleDate())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @name saveDutyType
	 * @param ss
	 * @description 保存员工考勤日数据
	 */
	@Transactional(readOnly = false)
	private void saveDutyType(SheduleScope ss,List<AttenceRecordDetail> attenceRecordDetailListByemployeeNo,List<ClockDetail> clockDetailListByEmployeeNo,List<SheduleScope> userSheduleScopeList,String datesStr) {
		//AttenceRecordDetail attenceRecordDetail = new AttenceRecordDetail();
		List<AttenceRecordDetail> attenceRecordDetailList = this
				.queryDutyTypeattenceRecordDetailList(ss.getEmployeeNo(),
						ss.getWorkStartStart(), ss.getWorkEndEnd(), attenceRecordDetailListByemployeeNo);
		boolean isFirst = true;
		ClockDetail clockDetail = this
				.findClockDetailByEmployeeNoAndAttenceTime(ss.getEmployeeNo(),
						ss.getScheduleDate(),clockDetailListByEmployeeNo);
		if (clockDetail == null) {
			clockDetail = new ClockDetail();
		}
		clockDetail.setAttenceTime(MyDateUtils.str2Date(ss.getScheduleDate(),
				MyDateUtils.DefFormatString));
		clockDetail.setEmployeeNo(ss.getEmployeeNo());
		clockDetail.setName(ss.getEmployeeName());
		if(clockDetail.getAttendenceInType() == null)
			clockDetail.setAttendenceInType("10");
		if(clockDetail.getAttendenceOutType() == null)
			clockDetail.setAttendenceOutType("10");
		if(clockDetail.getAttendenceType() == null){
			clockDetail.setAttendenceType(ss.getScheduleType());
		}
		for (int i = 0; i < attenceRecordDetailList.size(); i++) {
			AttenceRecordDetail ard = attenceRecordDetailList.get(i);
			//if("3".equals(ard.getAttenceType()) || "4".equals(ard.getAttenceType())){
			//	continue;
			//}else
				ard.setAttenceType("7");// 7:无效刷卡
			String attenceTime = MyDateUtils.formaterDate(ard.getAttenceTime(),
					MyDateUtils.formater);
			if (isFirst) {
				if (attenceTime.compareTo(ss.getWorkStartStart()) >= 0
						&& attenceTime.compareTo(ss.getWorkStartEnd()) <= 0)
					ard.setAttenceType("3");// 3:上班打卡正常
				else if (attenceTime.compareTo(ss.getWorkStartEnd()) > 0
						&& attenceTime.compareTo(ss.getWorkEndStart()) < 0) {
					ard.setAttenceType("5");// 5:迟到
				} else if (attenceTime.compareTo(ss.getWorkEndStart()) > 0
						&& attenceTime.compareTo(ss.getWorkEndEnd()) < 0) {
					ard.setAttenceType("8");// 8:下班打卡正常，无上班打卡记录
					clockDetail.setAttendenceOutType("4");
					clockDetail.setClockOut(attenceTime);
				}
				isFirst = false;
				clockDetail.setAttendenceInType(ard.getAttenceType());
				clockDetail.setClockIn(attenceTime);
			}

			if (i == attenceRecordDetailList.size() - 1 && i != 0) {
				if (attenceTime.compareTo(ss.getWorkEndStart()) >= 0
						&& attenceTime.compareTo(ss.getWorkEndEnd()) <= 0)
					ard.setAttenceType("4");// 4:下班打卡正常
				else if (attenceTime.compareTo(ss.getWorkStartEnd()) > 0
						&& attenceTime.compareTo(ss.getWorkEndStart()) < 0)
					ard.setAttenceType("6");// 6:早退
				else if (attenceTime.compareTo(ss.getWorkStartStart()) > 0
						&& attenceTime.compareTo(ss.getWorkStartEnd()) < 0) {
					ard.setAttenceType("9");// 9:上班打卡正常，无下班打卡记录
				}
				clockDetail.setAttendenceOutType(ard.getAttenceType());
				clockDetail.setClockOut(attenceTime);
			}
			// ard.setVersion(1);
			try {
				ard.save();
			} catch (OptimisticLockException e) {
				// TODO Auto-generated catch block
				log.info(ard.toJSONString());
				ard.setVersion(ard.getVersion() + 1);
				ard.save();
			}
		}
		clockDetail.save();
		//处理跨天考勤
//		if(datesStr.indexOf(ss.getWorkEndEnd().split(" ")[0]) < 0 && !ss.getScheduleDate().equals(ss.getWorkEndEnd().split(" ")[0])){
//			ClockDetail noDutyClockDetail = this.findClockDetailByEmployeeNoAndAttenceTime(ss.getEmployeeNo(),
//					ss.getWorkEndEnd().split(" ")[0],clockDetailListByEmployeeNo);
//			if(noDutyClockDetail != null && "23".equals(noDutyClockDetail.getAttendenceInType())){
//				noDutyClockDetail.remove();
//			}
//		}
//		if(this.checkNoAttence(ss.getEmployeeNo())){
//			clockDetail.setAttendenceInType("3");
//			clockDetail.setAttendenceOutType("4");
//		}
		
	}


	/**
	 * 获取一个雇员的考勤日刷卡记录
	 * @param employeeNo
	 * @param attenceRecordDetailsList
	 * @return 
	 */
	private List <AttenceRecordDetail> queryDutyTypeattenceRecordDetailList(String employeeNo,String workStartStart,String workEndEnd,List<AttenceRecordDetail> attenceRecordDetailsList){
		List<AttenceRecordDetail> attenceRecordDetailList = new ArrayList<AttenceRecordDetail>();
		
		for(AttenceRecordDetail ard : attenceRecordDetailsList){
			String attenceTime = MyDateUtils.formaterDate(ard.getAttenceTime(), MyDateUtils.formater);
			if(ard.getEmployeeNo().equals(employeeNo) && attenceTime.compareTo(workStartStart)  >= 0 && attenceTime.compareTo(workEndEnd)<=0 ){
				attenceRecordDetailList.add(ard);
			}
		}
		return attenceRecordDetailList;
	}
	
	/**
	 * 通过员工号和考勤日获取考勤记录
	 * @param employeeNo
	 * @param attenceTime
	 * @return ClockDetail
	 */
	@Transactional(readOnly = true)	
	private ClockDetail findClockDetailByEmployeeNoAndAttenceTime(
			String employeeNo, String attenceTime,List<ClockDetail> ClockDetailListByEmployeeNo) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("employeeNo", employeeNo);
		conditions.put("attenceTime",
				MyDateUtils.str2Date(attenceTime, MyDateUtils.DefFormatString));
		for(ClockDetail clockDetail : ClockDetailListByEmployeeNo){
			if(MyDateUtils.formaterDate(clockDetail.getAttenceTime(), MyDateUtils.DefFormatString).equals(attenceTime)){
				log.info("employeeNo:" + employeeNo + "||attenceTime:" + attenceTime);
				return clockDetail;
			}
		}
		return null;
	}
	
	/**
	 * 获取时间戳
	 * @return
	 */
	private Timestamp findTimestamp(String type){
		Timestamp timestamp = new Timestamp();
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("type", Integer.parseInt(type));
		List<Timestamp> timestampList = Timestamp.findByProperties(Timestamp.class, conditions);
		timestamp = timestampList.get(0);
		log.info(timestamp);
		return timestamp;
	}
	
	private List<NoAttenceEmployee> findNoAttenceEmployee(){
		List<NoAttenceEmployee> noAttenceEmployeeList = NoAttenceEmployee.findAll(NoAttenceEmployee.class);
		return noAttenceEmployeeList;
	}
	
	private List<NoAttenceEmployee> noAttenceEmployeeList = null;
	
	private boolean checkNoAttence(String employeeNo){
		if(noAttenceEmployeeList == null){
			noAttenceEmployeeList = this.findNoAttenceEmployee();
		}
		for(NoAttenceEmployee noAttenceEmployee : noAttenceEmployeeList){
			if(employeeNo.equals(noAttenceEmployee.getEmployeeNo())){
				return true;
			}
		}
		return false;
	}

	public List<String> getNoDutyAttendance() {
		if(this.typeList == null){
			this.typeList =  new ArrayList<String>();
			typeList.add("01:15:00;07:14:59;21");//"非考勤日白班上班"
			typeList.add("19:15:00;25:14:59;22");//"非考勤日白班下班"
			typeList.add("13:15:00;19:14:59;23");//"非考勤日夜班上班"
			typeList.add("07:15:00;13:14:59;24");//"非考勤日夜班下班"
		}
		return typeList;
	}
	
	public String getNoDutyType(String date){
		for(String str : this.getNoDutyAttendance()){
			String [] dutys = str.split(";");
			if(date.compareTo(dutys[0]) >=0 && date.compareTo(dutys[1]) <=0){
				return dutys[2];
			}
		}
		return "15"; //异常考勤
	}
}

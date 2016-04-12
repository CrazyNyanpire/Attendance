package com.acetecsemi.attendance.attendance.application.impl.core;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.querychannel.QueryChannelService;

import com.acetecsemi.attendance.attendance.application.core.DayAttendanceConfirmationCreateApplication;
import com.acetecsemi.attendance.attendance.core.*;
import com.acetecsemi.attendance.attendance.util.MyDateUtils;

@Named
@Transactional
public class DayAttendanceConfirmationCreateApplicationImpl implements
		DayAttendanceConfirmationCreateApplication {

	Logger log = Logger
			.getLogger(DayAttendanceConfirmationCreateApplicationImpl.class);

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public String createDayAttendanceConfirmation(int year, int month) {
		String result = "";
		year = 0;
		month = 5;
		List<MonthlyAttendanceConfirmation> macList = queryMonthlyAttendanceConfirmationList(
				year, month);
		if (macList.size() > 0)
			result = "successful";

		else{
			result = "none";	
		}
		return result;
	}

	private List<MonthlyAttendanceConfirmation> queryMonthlyAttendanceConfirmationList(
			int year, int month) {
		Timestamp timestamp = new Timestamp();
		timestamp = Timestamp.findByProperty(Timestamp.class, "type", 6).get(0);
		String startDate = "";
		String endDate = "";
		if( year == 0 && timestamp.getDoNext() == 0){
			startDate = timestamp.getLastTimestamp();
			endDate = timestamp.getTimestamp();
		}else{
			startDate = MyDateUtils.getAttendanceDefStartDate(year, month);
			endDate = MyDateUtils.getAttendanceDefEndDate(year, month);
		}
		
		StringBuilder jpql = new StringBuilder("");
		jpql.append("select a.duty_type,a.user_accounts,a.user_name,");
		jpql.append("白班应出勤,");
		jpql.append("count(CASE WHEN attendenceType = '1' and attendenceInType is not null THEN 1 ELSE NULL END) + 白班出勤  白班实际出勤,");
		jpql.append("count(CASE WHEN attendenceType = '1' and attendenceInType ='5' THEN 1 ELSE NULL END) 白班迟到,");
		jpql.append("count(CASE WHEN attendenceType = '1' and attendenceOutType ='6' THEN 1 ELSE NULL END) 白班早退,");
		jpql.append("count(CASE WHEN attendenceType = '1' and attendenceOutType ='9' or attendenceInType ='8'  THEN 1 ELSE NULL END) 白班未刷卡,");

		jpql.append("夜班应出勤,");
		jpql.append("count(CASE WHEN attendenceType = '2' and  attendenceInType is not null THEN 1 ELSE NULL END) + 夜班出勤  夜班实际出勤,");
		jpql.append("count(CASE WHEN attendenceType = '2' and attendenceInType ='5' THEN 1 ELSE NULL END) 夜班迟到,");
		jpql.append("count(CASE WHEN attendenceType = '2' and attendenceOutType ='6' THEN 1 ELSE NULL END) 夜班早退,");
		jpql.append("count(CASE WHEN attendenceType = '2' and attendenceOutType ='9' or attendenceInType ='8'  THEN 1 ELSE NULL END) 夜班未刷卡,");

		jpql.append("长白班应出勤,");
		jpql.append("count(CASE WHEN a.duty_type = '1' and attendenceInType is not null THEN 1 ELSE NULL END)  长白班实际出勤,");
		jpql.append("count(CASE WHEN a.duty_type = '1' and attendenceInType ='5' THEN 1 ELSE NULL END) 长白班迟到,");
		jpql.append("count(CASE WHEN a.duty_type = '1' and attendenceOutType ='6' THEN 1 ELSE NULL END) 长白班早退,");
		jpql.append("count(CASE WHEN a.duty_type = '1' and attendenceOutType ='9' or attendenceInType ='8'  THEN 1 ELSE NULL END) 长白班未刷卡 ,");
		jpql.append("白班餐补 + count(CASE WHEN attendenceType = '1' and attendenceInType is not null THEN 1 ELSE NULL END) ,");
		jpql.append("夜班餐补 + count(CASE WHEN attendenceType = '2' and  attendenceInType is not null THEN 1 ELSE NULL END) ,");
		jpql.append("CASE WHEN 常白班餐补 is null THEN 0 ELSE 常白班餐补 END  + sum(CASE WHEN a.duty_type = '1' and attendenceInType is not null and attendenceType is not null and  (substring(clockOut ,12) > '13:30:00'  or attendenceOutType ='4'  or  attendenceOutType ='14'   ) THEN 1 ELSE 0 END)   , ");
		jpql.append("平时 ,周末, 节假日 ,调休 ,hours, ");
		jpql.append("count(CASE WHEN attendenceInType ='5' THEN 1 ELSE NULL END) 迟到,");
		jpql.append("count(CASE WHEN attendenceOutType ='6' THEN 1 ELSE NULL END) 早退,");
		jpql.append("count(CASE WHEN attendenceOutType ='9' or attendenceInType ='8'  THEN 1 ELSE NULL END) 未刷卡 , ");
		jpql.append("g.*,h.annualVacation,h.annualVacationBalance,h.entryDate,thisMounthRest,h.lastMounthRest,h.sickLeave,h.sickLeaveBalance,i.attenceDays ");
		jpql.append("from (select * from user where user_accounts is not null and user_accounts != 'admin')  a ");

		jpql.append(" inner join  (select * from attence_clockdetail where attencetime between '"+startDate+"' and '"+endDate+"' )  b on a.user_accounts = b.employeeno ");

		jpql.append("left join (select count(*) 白班应出勤,duty_type from am_schedule where schedule_date between '"+startDate+"' and '"+endDate+"' and schedule_type='1' group by duty_type ) c on a.duty_type = c.duty_type ");

		jpql.append("left join (select count(*) 夜班应出勤,duty_type from am_schedule where schedule_date between '"+startDate+"' and '"+endDate+"' and schedule_type='2' group by duty_type ) d on a.duty_type =d.duty_type ");

		jpql.append("left join (select count(*) 长白班应出勤,duty_type from am_schedule where schedule_type = '0 ' and schedule_date between '"+startDate+"' and '"+endDate+"' and duty_type = '1' ) e on a.duty_type =e.duty_type ");

		jpql.append("left join ( select employeeno,");
		jpql.append("sum(CASE WHEN mealSupplementType = '常白班'  THEN mealSupplementTime ELSE 0 END) 常白班餐补 ,");
		jpql.append("sum(CASE WHEN mealSupplementType = '白班'  THEN mealSupplementTime ELSE 0 END) 白班餐补 ,");
		jpql.append("sum(CASE WHEN mealSupplementType = '夜班'  THEN mealSupplementTime ELSE 0 END) 夜班餐补 ,");
		jpql.append("sum(CASE WHEN workOvertimeType = '工作日加班' and restOrMoney = '计算加班工资' THEN hours ELSE 0 END) 平时 ,");
		jpql.append("sum(CASE WHEN workOvertimeType = '周末加班' and restOrMoney = '计算加班工资' THEN hours ELSE 0 END) 周末,");
		jpql.append("sum(CASE WHEN workOvertimeType = '节假日加班' and restOrMoney = '计算加班工资'  THEN hours ELSE 0 END) 节假日 ,");
		jpql.append("sum(CASE WHEN mealSupplementType = '夜班'  THEN 1 ELSE 0 END) 夜班出勤 ,");
		jpql.append("sum(CASE WHEN mealSupplementType = '白班'  THEN 1 ELSE 0 END) 白班出勤 ,");
		jpql.append("sum(CASE WHEN restOrMoney = '调休'  THEN hours ELSE 0 END) 调休 ,");
		jpql.append("sum(hours) hours from(select date,employeeno,startTime,endtime,mealSupplementTime,mealSupplementType,hours,workOvertimeType,restOrMoney from attence_workovertime ");
		jpql.append("where date between '"+startDate+"' and '"+endDate+"' ");
		jpql.append("group by date,employeeno,startTime,endtime) a ");
		jpql.append("where mealSupplementType is not null ");
		jpql.append("group by employeeno) f ");
		jpql.append("on  a.user_accounts = f.employeeno ");

		jpql.append("left join (select employeeno,");
		jpql.append("sum(CASE WHEN leaveType = '事假 '  THEN days ELSE 0 END) 事假 ,");
		jpql.append("sum(CASE WHEN leaveType = '病假 '  THEN days ELSE 0 END) 病假 ,");
		jpql.append("sum(CASE WHEN leaveType = '婚假 '  THEN days ELSE 0 END) 婚假 ,");
		jpql.append("sum(CASE WHEN leaveType = '丧假 '  THEN days ELSE 0 END) 丧假 ,");
		jpql.append("sum(CASE WHEN leaveType = '计生假 '  THEN days ELSE 0 END) 计生假 ,");
		jpql.append("sum(CASE WHEN leaveType = '工伤假 '  THEN days ELSE 0 END) 工伤假 ,");
		jpql.append("sum(CASE WHEN leaveType = '年休假 '  THEN days ELSE 0 END) 年休假 ,");
		jpql.append("sum(CASE WHEN leaveType = '调休 '  THEN days ELSE 0 END) 调休假 ,");
		jpql.append("sum(CASE WHEN leaveType = '婚检 '  THEN days ELSE 0 END) 婚检 ,");
		jpql.append("sum(CASE WHEN leaveType = '产假 '  THEN days ELSE 0 END) 产假 ,");
		jpql.append("sum(CASE WHEN leaveType = '外出公干 '  THEN days ELSE 0 END) 外出公干,");
		jpql.append("sum(CASE WHEN leaveType = '停薪留职 '  THEN days ELSE 0 END) 停薪留职 ,");
		jpql.append("sum(CASE WHEN leaveType = '换班 '  THEN days ELSE 0 END) 换班 ,");
		jpql.append("sum(CASE WHEN leaveType = '其他 '  THEN days ELSE 0 END) 其他 ");
		jpql.append("from attence_askleave where startDay  between '"+startDate+"' and '"+endDate+"' or  endDay  between '"+startDate+"' and '"+endDate+"' ");
		jpql.append("group by employeeno) g ");
		jpql.append("on  a.user_accounts = g.employeeno ");

		jpql.append("left join attence_informationmaintenance h on a.user_accounts = h.employeeno ");

		jpql.append("left join (");
		jpql.append("select employeeno,sum(attencedays)  attencedays ");
		jpql.append("from attence_businesstravel ");
		jpql.append("where startday between '"+startDate+"' and '"+endDate+"' or endday between '"+startDate+"' and '"+endDate+"' ");
		jpql.append("group by employeeno ");
		jpql.append(") i on a.user_accounts = i.employeeno ");
		
		jpql.append("group by a.user_accounts");

		@SuppressWarnings("unchecked")
		List<Object[]> mtcList = getQueryChannelService().createSqlQuery(
				jpql.toString()).list();
		List<MonthlyAttendanceConfirmation> result = new ArrayList<MonthlyAttendanceConfirmation>();
		for (Object[] object : mtcList) {
			Map<Integer, String> map = this.changeItemToString(object);
			// 将object转成VO
			MonthlyAttendanceConfirmation mac = new MonthlyAttendanceConfirmation();
			List <InformationMaintenance> informationMaintenanceList = InformationMaintenance.findByProperty(InformationMaintenance.class, "employeeNo", map.get(1));
			InformationMaintenance informationMaintenance;
			if(informationMaintenanceList != null && informationMaintenanceList.size() > 0){
				informationMaintenance = informationMaintenanceList.get(0);
			}else{
				continue;
			}
			mac.setName(map.get(2).toString());
			mac.setEmployeeNo(map.get(1).toString());
			mac.setStakeclass_d(map.get(3).toString());
			mac.setAtakeclass_d(map.get(4).toString());
			mac.setMealAllowanced_d(map.get(18).toString());

			mac.setStakeclass_n(map.get(8).toString());
			mac.setAtakeclass_n(map.get(9).toString());
			mac.setMealAllowanced_n(map.get(19).toString());

			mac.setStakeclass_nor(map.get(13).toString());
			
			double atakeclass = Double.parseDouble(map.get(14)) + Double.parseDouble(map.get(51));
			//map.get(51)出差天数
			mac.setAtakeclass_nor(String.valueOf(atakeclass));
			mac.setMealAllowanced_nor(map.get(20).toString());

			int travelAllowance = Integer.parseInt(map.get(4))
					+ Integer.parseInt(map.get(9))
					+ Integer.parseInt(map.get(14));
			mac.setTravelAllowance(String.valueOf(travelAllowance));
			mac.setOvertime_work(map.get(21).toString());
			mac.setOvertime_week(map.get(22).toString());
			mac.setOvertime_holiday(map.get(23).toString());
			mac.setOvertime_Rest(map.get(24).toString()); //本月调休

			mac.setRest_personal(map.get(30).toString());
			mac.setRest_sickness(map.get(31).toString());
			mac.setRest_marry(map.get(32).toString());
			mac.setRest_maternity(map.get(39).toString());
			mac.setRest_funeral(map.get(33).toString());
			mac.setRest_plan_maternity(map.get(34).toString());
			mac.setRest_bruise(map.get(35).toString());

			mac.setRest_rest(map.get(37).toString());//调休
			mac.setRest_annual(map.get(36).toString());//年假


			mac.setNotakeclass("");// 入职缺勤数

			mac.setLate(map.get(26).toString());
			mac.setLeave_early(map.get(27).toString());
			mac.setNocredit_card(map.get(28).toString());

			String lastMounthRest = map.get(47);//上月调休余额（h）
			mac.setLastMounthRest(lastMounthRest);
			
			double thisMounthRest = 0;
			try {
				thisMounthRest = Double.parseDouble(map.get(47)) + Double.parseDouble(map.get(24)) - Double.parseDouble(map.get(37));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				log.info(map.get(47) + map.get(24) +map.get(37));
				e.printStackTrace();
			}

			
			mac.setThisMounthRest(String.valueOf(thisMounthRest));
			mac.setEntryDate(map.get(46));
			
			String annualVacation = map.get(45);
			
			double annualVacationBalance = 0;
			try {
				annualVacationBalance = Double.parseDouble(map.get(45)) - Double.parseDouble(map.get(36));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mac.setAnnualVacation(annualVacation);
			mac.setAnnualVacationBalance(String.valueOf(annualVacationBalance));
			
			String sickLeave = map.get(50);//上月剩余全薪病假（D）
			double sickLeaveBalance = Double.parseDouble(map.get(50)) - Double.parseDouble(map.get(31));
			mac.setSickLeave(sickLeave);
			mac.setSickLeaveBalance(String.valueOf(sickLeaveBalance));
			double fullWorkTime = Double.parseDouble(map.get(30))
					+ Double.parseDouble(map.get(31)) +  Double.parseDouble(map.get(32))
					+ Double.parseDouble(map.get(39))
					+ Double.parseDouble(map.get(33))
					+ Double.parseDouble(map.get(34))
					+ Double.parseDouble(map.get(35));
			log.info(map.get(2) + fullWorkTime);
			String fullWorkTimeSign = "";
			if (fullWorkTime > 0) {
				fullWorkTimeSign = "缺勤";
			} else {
				fullWorkTimeSign = "满勤";
			}
			mac.setIs_full_hours(fullWorkTimeSign);
			mac.setAttendancetype(map.get(0).toString());
			String monthstr = "00" + String.valueOf(month);
			mac.setAttendancemonth(String.valueOf(year) + "-"
					+ monthstr.substring(monthstr.length() - 2));
			mac.setAttendancemonth(endDate.substring(0,7));
			//mac.save();
			//informationMaintenance.setLastMounthRest(lastMounthRest);
			//informationMaintenance.setThisMounthRest(String.valueOf(thisMounthRest));
			informationMaintenance.setNowThisMounthRest(String.valueOf(thisMounthRest));
			//informationMaintenance.setAnnualVacation(annualVacation);
			//informationMaintenance.setAnnualVacationBalance(String.valueOf(annualVacationBalance));
			informationMaintenance.setNowAnnualVacationBalance(String.valueOf(annualVacationBalance));
			//informationMaintenance.setSickLeave(sickLeave);
			//informationMaintenance.setSickLeaveBalance(String.valueOf(sickLeaveBalance));
			informationMaintenance.setNowSickLeaveBalance(String.valueOf(sickLeaveBalance));
			informationMaintenance.save();
			result.add(mac);
		}
		
		//timestamp.setLastTimestamp(MyDateUtils.addMonths(startDate,1));
		//timestamp.setTimestamp(MyDateUtils.addMonths(endDate,1));
		//timestamp.setDoNext(0);
		//timestamp.save();
		return result;
	}

	private Map<Integer, String> changeItemToString(Object[] object) {
		Map<Integer, String> result = new HashMap<Integer, String>();
		for (int i = 0; i < object.length; i++) {
			String value = "0";
			if (object[i] == null || "".equals(object[i])) {
				value = "0";
			} else {
				value = object[i].toString();
			}
			result.put(i, value);
		}
		return result;
	}

}

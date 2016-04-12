
package com.acetecsemi.attendance.attendance.web.controller.core;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;

import com.acetecsemi.attendance.attendance.application.core.AttenceRecordJobApplication;
import com.acetecsemi.attendance.attendance.application.core.DayAttendanceConfirmationCreateApplication;

@Controller
@RequestMapping("/AttenceRecordDetail")
public class AttenceRecordJobController {
		
	@Inject
	private AttenceRecordJobApplication attenceRecordJobApplication;
	
	@Inject
    private DayAttendanceConfirmationCreateApplication dayAttendanceConfirmationCreateApplication;

	Logger log = Logger.getLogger(AttenceRecordJobController.class);
	
	@ResponseBody
	@RequestMapping("/updateAttenceRecordDetailType")
	public Map<String, Object> doAttenceRecordDetailType() {
		Map<String, Object> result = new HashMap<String, Object>();
		attenceRecordJobApplication.doAttenceRecordDetailTypeNoDuty("1");	
		attenceRecordJobApplication.doAttenceRecordDetailTypeDuty("1");
		result.put("data", "successful!");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/updateAttenceRecordDetailTypeWx")
	public Map<String, Object> doAttenceRecordDetailTypeWx() {
		Map<String, Object> result = new HashMap<String, Object>();
		attenceRecordJobApplication.doAttenceRecordDetailTypeNoDuty("4");	
		attenceRecordJobApplication.doAttenceRecordDetailTypeDuty("4");
		result.put("data", "successful!");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/createDayAttendanceConfirmation")
	public Map<String, Object> createDayAttendanceConfirmation() {
		Map<String, Object> result = new HashMap<String, Object>();
		dayAttendanceConfirmationCreateApplication.createDayAttendanceConfirmation(0,5);	
		result.put("data", "successful!");
		return result;
	}
	
	
	public void doTest(){
		log.info("doTest");
	}
}

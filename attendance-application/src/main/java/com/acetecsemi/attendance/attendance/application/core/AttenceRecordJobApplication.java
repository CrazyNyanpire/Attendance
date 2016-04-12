
package com.acetecsemi.attendance.attendance.application.core;

import javax.jws.WebService;

@WebService()
public interface AttenceRecordJobApplication {
	
	public String doAttenceRecordDetailTypeDuty(String Type);
	
	public String doAttenceRecordDetailTypeNoDuty(String type);
	
	public String doTest();
	
}


package com.acetecsemi.attendance.attendance.application.core;


public interface MonthlyAttendanceConfirmationCreateApplication {

	/**
	 * 生成月度考勤确认单
	 * 
	 * @param startDate
	 *            默认系统月 26日
	 * @param endDate
	 *            默认系统月 25日
	 * @return
	 */
	public String createMonthlyAttendanceConfirmation(int year,
			int month);

}

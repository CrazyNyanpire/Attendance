
package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.dto.*;

public interface MonthlyAttendanceConfirmationApplication {

	public MonthlyAttendanceConfirmationDTO getMonthlyAttendanceConfirmation(Long id);
	
	public MonthlyAttendanceConfirmationDTO saveMonthlyAttendanceConfirmation(MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmation);
	
	public void updateMonthlyAttendanceConfirmation(MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmation);
	
	public void removeMonthlyAttendanceConfirmation(Long id);
	
	public void removeMonthlyAttendanceConfirmations(Long[] ids);
	
	public List<MonthlyAttendanceConfirmationDTO> findAllMonthlyAttendanceConfirmation();
	
	public Page<MonthlyAttendanceConfirmationDTO> pageQueryMonthlyAttendanceConfirmation(MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmation, int currentPage, int pageSize);
	

}


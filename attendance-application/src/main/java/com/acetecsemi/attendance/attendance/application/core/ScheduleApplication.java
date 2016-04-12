
package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.dto.*;

public interface ScheduleApplication {

	public ScheduleDTO getSchedule(Long id);
	
	public ScheduleDTO saveSchedule(ScheduleDTO schedule);
	
	public void updateSchedule(ScheduleDTO schedule);
	
	public void removeSchedule(Long id);
	
	public void removeSchedules(Long[] ids);
	
	public List<ScheduleDTO> findAllSchedule();
	
	public Page<ScheduleDTO> pageQuerySchedule(ScheduleDTO schedule, int currentPage, int pageSize);
	

}



package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.dto.*;

public interface WorkOvertimeApplication {

	public WorkOvertimeDTO getWorkOvertime(Long id);
	
	public WorkOvertimeDTO saveWorkOvertime(WorkOvertimeDTO workOvertime);
	
	public void updateWorkOvertime(WorkOvertimeDTO workOvertime);
	
	public void removeWorkOvertime(Long id);
	
	public void removeWorkOvertimes(Long[] ids);
	
	public List<WorkOvertimeDTO> findAllWorkOvertime();
	
	public Page<WorkOvertimeDTO> pageQueryWorkOvertime(WorkOvertimeDTO workOvertime, int currentPage, int pageSize);
	

}


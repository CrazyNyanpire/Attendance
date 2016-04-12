
package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.dto.*;

public interface ClockDetailApplication {

	public ClockDetailDTO getClockDetail(Long id);
	
	public ClockDetailDTO saveClockDetail(ClockDetailDTO clockDetail);
	
	public void updateClockDetail(ClockDetailDTO clockDetail);
	
	public void removeClockDetail(Long id);
	
	public void removeClockDetails(Long[] ids);
	
	public List<ClockDetailDTO> findAllClockDetail();
	
	public Page<ClockDetailDTO> pageQueryClockDetail(ClockDetailDTO clockDetail, int currentPage, int pageSize);
	

}


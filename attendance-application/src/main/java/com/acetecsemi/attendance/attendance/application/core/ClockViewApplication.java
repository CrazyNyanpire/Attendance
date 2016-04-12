
package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.dto.*;

public interface ClockViewApplication {

	public ClockViewDTO getClockView(Long id);
	
	public ClockViewDTO saveClockView(ClockViewDTO clockView);
	
	public void updateClockView(ClockViewDTO clockView);
	
	public void removeClockView(Long id);
	
	public void removeClockViews(Long[] ids);
	
	public List<ClockViewDTO> findAllClockView();
	
	public Page<ClockViewDTO> pageQueryClockView(ClockViewDTO clockView, int currentPage, int pageSize);
	

}


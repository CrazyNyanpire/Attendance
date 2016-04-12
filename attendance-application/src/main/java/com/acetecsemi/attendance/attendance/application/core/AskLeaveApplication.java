
package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.dto.*;

public interface AskLeaveApplication {

	public AskLeaveDTO getAskLeave(Long id);
	
	public AskLeaveDTO saveAskLeave(AskLeaveDTO askLeave);
	
	public void updateAskLeave(AskLeaveDTO askLeave);
	
	public void removeAskLeave(Long id);
	
	public void removeAskLeaves(Long[] ids);
	
	public List<AskLeaveDTO> findAllAskLeave();
	
	public Page<AskLeaveDTO> pageQueryAskLeave(AskLeaveDTO askLeave, int currentPage, int pageSize);
	

}



package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.dto.*;

public interface AttenceRecordFileApplication {

	public AttenceRecordFileDTO getAttenceRecordFile(Long id);
	
	public AttenceRecordFileDTO saveAttenceRecordFile(AttenceRecordFileDTO attenceRecordFile);
	
	public void updateAttenceRecordFile(AttenceRecordFileDTO attenceRecordFile);
	
	public void removeAttenceRecordFile(Long id);
	
	public void removeAttenceRecordFiles(Long[] ids);
	
	public List<AttenceRecordFileDTO> findAllAttenceRecordFile();
	
	public Page<AttenceRecordFileDTO> pageQueryAttenceRecordFile(AttenceRecordFileDTO attenceRecordFile, int currentPage, int pageSize);
	

}



package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import java.util.Map;

import org.dayatang.querychannel.Page;

import com.acetecsemi.attendance.attendance.application.dto.*;

public interface AttenceRecordDetailApplication {

	public AttenceRecordDetailDTO getAttenceRecordDetail(Long id);
	
	public Map<String, String>  getAttenceType();
	
	public AttenceRecordDetailDTO saveAttenceRecordDetail(AttenceRecordDetailDTO attenceRecordDetail);
	
	public void updateAttenceRecordDetail(AttenceRecordDetailDTO attenceRecordDetail);
	
	public void removeAttenceRecordDetail(Long id);
	
	public void removeAttenceRecordDetails(Long[] ids);
	
	public List<AttenceRecordDetailDTO> findAllAttenceRecordDetail();
	
	public Page<AttenceRecordDetailDTO> pageQueryAttenceRecordDetail(AttenceRecordDetailDTO attenceRecordDetail, int currentPage, int pageSize);
	

}


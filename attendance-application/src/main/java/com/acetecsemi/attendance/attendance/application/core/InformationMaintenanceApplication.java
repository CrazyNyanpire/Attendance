
package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.dto.*;

public interface InformationMaintenanceApplication {

	public InformationMaintenanceDTO getInformationMaintenance(Long id);
	
	public InformationMaintenanceDTO saveInformationMaintenance(InformationMaintenanceDTO informationMaintenance);
	
	public void updateInformationMaintenance(InformationMaintenanceDTO informationMaintenance);
	
	public void removeInformationMaintenance(Long id);
	
	public void removeInformationMaintenances(Long[] ids);
	
	public List<InformationMaintenanceDTO> findAllInformationMaintenance();
	
	public Page<InformationMaintenanceDTO> pageQueryInformationMaintenance(InformationMaintenanceDTO informationMaintenance, int currentPage, int pageSize);
	

}


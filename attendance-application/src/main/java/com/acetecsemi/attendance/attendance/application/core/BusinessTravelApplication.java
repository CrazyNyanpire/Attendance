
package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.dto.*;

public interface BusinessTravelApplication {

	public BusinessTravelDTO getBusinessTravel(Long id);
	
	public BusinessTravelDTO saveBusinessTravel(BusinessTravelDTO businessTravel);
	
	public void updateBusinessTravel(BusinessTravelDTO businessTravel);
	
	public void removeBusinessTravel(Long id);
	
	public void removeBusinessTravels(Long[] ids);
	
	public List<BusinessTravelDTO> findAllBusinessTravel();
	
	public Page<BusinessTravelDTO> pageQueryBusinessTravel(BusinessTravelDTO businessTravel, int currentPage, int pageSize);
	

}


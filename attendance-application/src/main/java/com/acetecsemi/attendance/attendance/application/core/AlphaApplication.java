
package com.acetecsemi.attendance.attendance.application.core;

import java.util.List;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.dto.*;

public interface AlphaApplication {

	public AlphaDTO getAlpha(Long id);
	
	public AlphaDTO saveAlpha(AlphaDTO alpha);
	
	public void updateAlpha(AlphaDTO alpha);
	
	public void removeAlpha(Long id);
	
	public void removeAlphas(Long[] ids);
	
	public List<AlphaDTO> findAllAlpha();
	
	public Page<AlphaDTO> pageQueryAlpha(AlphaDTO alpha, int currentPage, int pageSize);
	

}



package com.acetecsemi.attendance.attendance.application.impl.core;

import java.util.List;
import java.util.ArrayList;
import java.text.MessageFormat;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.querychannel.Page;
import org.dayatang.querychannel.QueryChannelService;
import com.acetecsemi.attendance.attendance.application.dto.*;
import com.acetecsemi.attendance.attendance.application.core.InformationMaintenanceApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class InformationMaintenanceApplicationImpl implements InformationMaintenanceApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public InformationMaintenanceDTO getInformationMaintenance(Long id) {
		InformationMaintenance informationMaintenance = InformationMaintenance.load(InformationMaintenance.class, id);
		InformationMaintenanceDTO informationMaintenanceDTO = new InformationMaintenanceDTO();
		// 将domain转成VO
		try {
			BeanUtils.copyProperties(informationMaintenanceDTO, informationMaintenance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		informationMaintenanceDTO.setId((java.lang.Long)informationMaintenance.getId());
		return informationMaintenanceDTO;
	}
	
	public InformationMaintenanceDTO saveInformationMaintenance(InformationMaintenanceDTO informationMaintenanceDTO) {
		InformationMaintenance informationMaintenance = new InformationMaintenance();
		if(informationMaintenanceDTO.getEmployeeNo() == null || "".equals(informationMaintenanceDTO.getEmployeeNo()))
			informationMaintenanceDTO.setEmployeeNo(informationMaintenance.getEmployeeNo());
		if(informationMaintenanceDTO.getName() == null || "".equals(informationMaintenanceDTO.getName()))
			informationMaintenanceDTO.setName(informationMaintenance.getName());
		try {
        	BeanUtils.copyProperties(informationMaintenance, informationMaintenanceDTO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		informationMaintenance.save();
		informationMaintenanceDTO.setId((java.lang.Long)informationMaintenance.getId());
		return informationMaintenanceDTO;
	}
	
	public void updateInformationMaintenance(InformationMaintenanceDTO informationMaintenanceDTO) {
		InformationMaintenance informationMaintenance = InformationMaintenance.get(InformationMaintenance.class, informationMaintenanceDTO.getId());
		// 设置要更新的值
		if(informationMaintenanceDTO.getEmployeeNo() == null || "".equals(informationMaintenanceDTO.getEmployeeNo()))
			informationMaintenanceDTO.setEmployeeNo(informationMaintenance.getEmployeeNo());
		if(informationMaintenanceDTO.getName() == null || "".equals(informationMaintenanceDTO.getName()))
			informationMaintenanceDTO.setName(informationMaintenance.getName());
		try {
			BeanUtils.copyProperties(informationMaintenance, informationMaintenanceDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeInformationMaintenance(Long id) {
		this.removeInformationMaintenances(new Long[] { id });
	}
	
	public void removeInformationMaintenances(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			InformationMaintenance informationMaintenance = InformationMaintenance.load(InformationMaintenance.class, ids[i]);
			informationMaintenance.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InformationMaintenanceDTO> findAllInformationMaintenance() {
		List<InformationMaintenanceDTO> list = new ArrayList<InformationMaintenanceDTO>();
		List<InformationMaintenance> all = InformationMaintenance.findAll(InformationMaintenance.class);
		for (InformationMaintenance informationMaintenance : all) {
			InformationMaintenanceDTO informationMaintenanceDTO = new InformationMaintenanceDTO();
			// 将domain转成VO
			try {
				BeanUtils.copyProperties(informationMaintenanceDTO, informationMaintenance);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(informationMaintenanceDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<InformationMaintenanceDTO> pageQueryInformationMaintenance(InformationMaintenanceDTO queryVo, int currentPage, int pageSize) {
		List<InformationMaintenanceDTO> result = new ArrayList<InformationMaintenanceDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _informationMaintenance from InformationMaintenance _informationMaintenance   where 1=1 ");
	
	
	   	if (queryVo.getName() != null && !"".equals(queryVo.getName())) {
	   		jpql.append(" and _informationMaintenance.name like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getName()));
	   	}		
	
	   	if (queryVo.getEmployeeNo() != null && !"".equals(queryVo.getEmployeeNo())) {
	   		jpql.append(" and _informationMaintenance.employeeNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeNo()));
	   	}		
	
	   	if (queryVo.getLastMounthRest() != null && !"".equals(queryVo.getLastMounthRest())) {
	   		jpql.append(" and _informationMaintenance.lastMounthRest like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastMounthRest()));
	   	}		
	
	   	if (queryVo.getThisMounthRest() != null && !"".equals(queryVo.getThisMounthRest())) {
	   		jpql.append(" and _informationMaintenance.thisMounthRest like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getThisMounthRest()));
	   	}		
	
	   	if (queryVo.getEntryDate() != null) {
	   		jpql.append(" and _informationMaintenance.entryDate between ? and ? ");
	   		conditionVals.add(queryVo.getEntryDate());
	   		conditionVals.add(queryVo.getEntryDateEnd());
	   	}	
	
	   	if (queryVo.getAnnualVacation() != null && !"".equals(queryVo.getAnnualVacation())) {
	   		jpql.append(" and _informationMaintenance.annualVacation like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAnnualVacation()));
	   	}		
	
	   	if (queryVo.getAnnualVacationBalance() != null && !"".equals(queryVo.getAnnualVacationBalance())) {
	   		jpql.append(" and _informationMaintenance.annualVacationBalance like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAnnualVacationBalance()));
	   	}		
	
	   	if (queryVo.getSickLeave() != null && !"".equals(queryVo.getSickLeave())) {
	   		jpql.append(" and _informationMaintenance.sickLeave like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSickLeave()));
	   	}		
	
	   	if (queryVo.getSickLeaveBalance() != null && !"".equals(queryVo.getSickLeaveBalance())) {
	   		jpql.append(" and _informationMaintenance.sickLeaveBalance like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSickLeaveBalance()));
	   	}
	   	if(queryVo.getSortname() != null && !"".equals(queryVo.getSortname()))
		{
				jpql.append(" order by _informationMaintenance."+queryVo.getSortname()+" ").append(queryVo.getSortorder());
		}
        Page<InformationMaintenance> pages = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
        for (InformationMaintenance informationMaintenance : pages.getData()) {
            InformationMaintenanceDTO informationMaintenanceDTO = new InformationMaintenanceDTO();
            
             // 将domain转成VO
            try {
            	BeanUtils.copyProperties(informationMaintenanceDTO, informationMaintenance);
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            
                                                                                                                                                         result.add(informationMaintenanceDTO);
        }
        return new Page<InformationMaintenanceDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
}

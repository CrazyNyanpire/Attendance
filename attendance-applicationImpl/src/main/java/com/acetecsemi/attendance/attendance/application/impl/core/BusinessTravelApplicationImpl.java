
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
import com.acetecsemi.attendance.attendance.application.core.BusinessTravelApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class BusinessTravelApplicationImpl implements BusinessTravelApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BusinessTravelDTO getBusinessTravel(Long id) {
		BusinessTravel businessTravel = BusinessTravel.load(BusinessTravel.class, id);
		BusinessTravelDTO businessTravelDTO = new BusinessTravelDTO();
		// 将domain转成VO
		try {
			BeanUtils.copyProperties(businessTravelDTO, businessTravel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		businessTravelDTO.setId((java.lang.Long)businessTravel.getId());
		return businessTravelDTO;
	}
	
	public BusinessTravelDTO saveBusinessTravel(BusinessTravelDTO businessTravelDTO) {
		BusinessTravel businessTravel = new BusinessTravel();
		try {
        	BeanUtils.copyProperties(businessTravel, businessTravelDTO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		businessTravel.save();
		businessTravelDTO.setId((java.lang.Long)businessTravel.getId());
		return businessTravelDTO;
	}
	
	public void updateBusinessTravel(BusinessTravelDTO businessTravelDTO) {
		BusinessTravel businessTravel = BusinessTravel.get(BusinessTravel.class, businessTravelDTO.getId());
		// 设置要更新的值
		try {
			BeanUtils.copyProperties(businessTravel, businessTravelDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeBusinessTravel(Long id) {
		this.removeBusinessTravels(new Long[] { id });
	}
	
	public void removeBusinessTravels(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			BusinessTravel businessTravel = BusinessTravel.load(BusinessTravel.class, ids[i]);
			businessTravel.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BusinessTravelDTO> findAllBusinessTravel() {
		List<BusinessTravelDTO> list = new ArrayList<BusinessTravelDTO>();
		List<BusinessTravel> all = BusinessTravel.findAll(BusinessTravel.class);
		for (BusinessTravel businessTravel : all) {
			BusinessTravelDTO businessTravelDTO = new BusinessTravelDTO();
			// 将domain转成VO
			try {
				BeanUtils.copyProperties(businessTravelDTO, businessTravel);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(businessTravelDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<BusinessTravelDTO> pageQueryBusinessTravel(BusinessTravelDTO queryVo, int currentPage, int pageSize) {
		List<BusinessTravelDTO> result = new ArrayList<BusinessTravelDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _businessTravel from BusinessTravel _businessTravel   where 1=1 ");
	
	
	   	if (queryVo.getEmployeeNo() != null && !"".equals(queryVo.getEmployeeNo())) {
	   		jpql.append(" and _businessTravel.employeeNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeNo()));
	   	}		
	
	   	if (queryVo.getEmployeeName() != null && !"".equals(queryVo.getEmployeeName())) {
	   		jpql.append(" and _businessTravel.employeeName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeName()));
	   	}		
	
	   	if (queryVo.getRunName() != null && !"".equals(queryVo.getRunName())) {
	   		jpql.append(" and _businessTravel.runName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRunName()));
	   	}		
	
	   	if (queryVo.getRunId() != null && !"".equals(queryVo.getRunId())) {
	   		jpql.append(" and _businessTravel.runId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRunId()));
	   	}		
	
	   	if (queryVo.getCreator() != null && !"".equals(queryVo.getCreator())) {
	   		jpql.append(" and _businessTravel.creator like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreator()));
	   	}		
	
	   	if (queryVo.getDepartmentName() != null && !"".equals(queryVo.getDepartmentName())) {
	   		jpql.append(" and _businessTravel.departmentName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDepartmentName()));
	   	}		
	
	   	if (queryVo.getReason() != null && !"".equals(queryVo.getReason())) {
	   		jpql.append(" and _businessTravel.reason like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getReason()));
	   	}		
	
	   	if (queryVo.getFormArea() != null && !"".equals(queryVo.getFormArea())) {
	   		jpql.append(" and _businessTravel.formArea like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getFormArea()));
	   	}		
	
	   	if (queryVo.getToArea() != null && !"".equals(queryVo.getToArea())) {
	   		jpql.append(" and _businessTravel.toArea like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getToArea()));
	   	}		
	
	   	if (queryVo.getStartDay() != null && !"".equals(queryVo.getStartDay())) {
	   		jpql.append(" and _businessTravel.startDay like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStartDay()));
	   	}		
	
	   	if (queryVo.getStartTime() != null && !"".equals(queryVo.getStartTime())) {
	   		jpql.append(" and _businessTravel.startTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStartTime()));
	   	}		
	
	   	if (queryVo.getEndDay() != null && !"".equals(queryVo.getEndDay())) {
	   		jpql.append(" and _businessTravel.endDay like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndDay()));
	   	}		
	
	   	if (queryVo.getEndTime() != null && !"".equals(queryVo.getEndTime())) {
	   		jpql.append(" and _businessTravel.endTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndTime()));
	   	}		
	
	   	if (queryVo.getDays() != null && !"".equals(queryVo.getDays())) {
	   		jpql.append(" and _businessTravel.days like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDays()));
	   	}		
	
	   	if (queryVo.getDetail() != null && !"".equals(queryVo.getDetail())) {
	   		jpql.append(" and _businessTravel.detail like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDetail()));
	   	}		
	
	   	if (queryVo.getEvent() != null && !"".equals(queryVo.getEvent())) {
	   		jpql.append(" and _businessTravel.event like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEvent()));
	   	}		
	
	   	if (queryVo.getAttenceDays() != null && !"".equals(queryVo.getAttenceDays())) {
	   		jpql.append(" and _businessTravel.attenceDays like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttenceDays()));
	   	}		
        Page<BusinessTravel> pages = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
        for (BusinessTravel businessTravel : pages.getData()) {
            BusinessTravelDTO businessTravelDTO = new BusinessTravelDTO();
            
             // 将domain转成VO
            try {
            	BeanUtils.copyProperties(businessTravelDTO, businessTravel);
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            
                                                                                                                                                                                                                                    result.add(businessTravelDTO);
        }
        return new Page<BusinessTravelDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
}

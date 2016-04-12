
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
import com.acetecsemi.attendance.attendance.application.core.AskLeaveApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class AskLeaveApplicationImpl implements AskLeaveApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AskLeaveDTO getAskLeave(Long id) {
		AskLeave askLeave = AskLeave.load(AskLeave.class, id);
		AskLeaveDTO askLeaveDTO = new AskLeaveDTO();
		// 将domain转成VO
		try {
			BeanUtils.copyProperties(askLeaveDTO, askLeave);
		} catch (Exception e) {
			e.printStackTrace();
		}
		askLeaveDTO.setId((java.lang.Long)askLeave.getId());
		return askLeaveDTO;
	}
	
	public AskLeaveDTO saveAskLeave(AskLeaveDTO askLeaveDTO) {
		AskLeave askLeave = new AskLeave();
		try {
        	BeanUtils.copyProperties(askLeave, askLeaveDTO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		askLeave.save();
		askLeaveDTO.setId((java.lang.Long)askLeave.getId());
		return askLeaveDTO;
	}
	
	public void updateAskLeave(AskLeaveDTO askLeaveDTO) {
		//AskLeave askLeave = AskLeave.get(AskLeave.class, askLeaveDTO.getId());
		AskLeave askLeave = AskLeave.get(AskLeave.class, askLeaveDTO.getId());
		askLeave.setStartDay(askLeaveDTO.getStartDay());
		askLeave.setStartTime(askLeaveDTO.getStartTime());
		askLeave.setEndDay(askLeaveDTO.getEndDay());
		askLeave.setEndTime(askLeaveDTO.getEndTime());
		askLeave.setDays(askLeaveDTO.getDays());
		askLeave.setLeaveType(askLeaveDTO.getLeaveType());
		// 设置要更新的值
		try {
			askLeave.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeAskLeave(Long id) {
		this.removeAskLeaves(new Long[] { id });
	}
	
	public void removeAskLeaves(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			AskLeave askLeave = AskLeave.load(AskLeave.class, ids[i]);
			askLeave.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AskLeaveDTO> findAllAskLeave() {
		List<AskLeaveDTO> list = new ArrayList<AskLeaveDTO>();
		List<AskLeave> all = AskLeave.findAll(AskLeave.class);
		for (AskLeave askLeave : all) {
			AskLeaveDTO askLeaveDTO = new AskLeaveDTO();
			// 将domain转成VO
			try {
				BeanUtils.copyProperties(askLeaveDTO, askLeave);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(askLeaveDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<AskLeaveDTO> pageQueryAskLeave(AskLeaveDTO queryVo, int currentPage, int pageSize) {
		List<AskLeaveDTO> result = new ArrayList<AskLeaveDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _askLeave from AskLeave _askLeave   where 1=1 ");
	
	
	   	if (queryVo.getEmployeeNo() != null && !"".equals(queryVo.getEmployeeNo())) {
	   		jpql.append(" and _askLeave.employeeNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeNo()));
	   	}		
	
	   	if (queryVo.getEmployeeName() != null && !"".equals(queryVo.getEmployeeName())) {
	   		jpql.append(" and _askLeave.employeeName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeName()));
	   	}		
	
	   	if (queryVo.getRunName() != null && !"".equals(queryVo.getRunName())) {
	   		jpql.append(" and _askLeave.runName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRunName()));
	   	}		
	
	   	if (queryVo.getRunId() != null && !"".equals(queryVo.getRunId())) {
	   		jpql.append(" and _askLeave.runId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRunId()));
	   	}		
	
	   	if (queryVo.getCreator() != null && !"".equals(queryVo.getCreator())) {
	   		jpql.append(" and _askLeave.creator like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreator()));
	   	}		
	
	   	if (queryVo.getYearHolidays() != null && !"".equals(queryVo.getYearHolidays())) {
	   		jpql.append(" and _askLeave.yearHolidays like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getYearHolidays()));
	   	}		
	
	   	if (queryVo.getDelayRest() != null && !"".equals(queryVo.getDelayRest())) {
	   		jpql.append(" and _askLeave.delayRest like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDelayRest()));
	   	}		
	
	   	if (queryVo.getSickLeave() != null && !"".equals(queryVo.getSickLeave())) {
	   		jpql.append(" and _askLeave.sickLeave like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSickLeave()));
	   	}		
	   	if (queryVo.getAttenceTime() != null) {
	   		jpql.append(" and _askLeave.startDay between ? and ? ");
	   		conditionVals.add(queryVo.getAttenceTime());
	   		conditionVals.add(queryVo.getAttenceTimeEnd());
	   	}
	   	if (queryVo.getStartDay() != null && !"".equals(queryVo.getStartDay())) {
	   		jpql.append(" and _askLeave.startDay like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStartDay()));
	   	}		
	
	   	if (queryVo.getStartTime() != null && !"".equals(queryVo.getStartTime())) {
	   		jpql.append(" and _askLeave.startTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStartTime()));
	   	}		
	
	   	if (queryVo.getEndDay() != null && !"".equals(queryVo.getEndDay())) {
	   		jpql.append(" and _askLeave.endDay like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndDay()));
	   	}		
	
	   	if (queryVo.getEndTime() != null && !"".equals(queryVo.getEndTime())) {
	   		jpql.append(" and _askLeave.endTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndTime()));
	   	}		
	
	   	if (queryVo.getDays() != null && !"".equals(queryVo.getDays())) {
	   		jpql.append(" and _askLeave.days like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDays()));
	   	}		
	
	   	if (queryVo.getLeaveType() != null && !"".equals(queryVo.getLeaveType())) {
	   		jpql.append(" and _askLeave.leaveType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLeaveType()));
	   	}		
	
	   	if (queryVo.getAskLeaveDescription() != null && !"".equals(queryVo.getAskLeaveDescription())) {
	   		jpql.append(" and _askLeave.askLeaveDescription like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAskLeaveDescription()));
	   	}
	   	if(queryVo.getSortname() != null && !"".equals(queryVo.getSortname()))
		{
				jpql.append(" order by _askLeave."+queryVo.getSortname()+" ").append(queryVo.getSortorder());
		}
	   	else{
	   		jpql.append(" order by _askLeave.startDay desc");
	   	}
        Page<AskLeave> pages = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
        for (AskLeave askLeave : pages.getData()) {
            AskLeaveDTO askLeaveDTO = new AskLeaveDTO();
            
             // 将domain转成VO
            try {
            	BeanUtils.copyProperties(askLeaveDTO, askLeave);
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            
                                                                                                                                                                                                                     result.add(askLeaveDTO);
        }
        return new Page<AskLeaveDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
}

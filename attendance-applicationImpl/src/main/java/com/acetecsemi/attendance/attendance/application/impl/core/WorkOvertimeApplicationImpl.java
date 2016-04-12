
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
import com.acetecsemi.attendance.attendance.application.core.WorkOvertimeApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class WorkOvertimeApplicationImpl implements WorkOvertimeApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkOvertimeDTO getWorkOvertime(Long id) {
		WorkOvertime workOvertime = WorkOvertime.load(WorkOvertime.class, id);
		WorkOvertimeDTO workOvertimeDTO = new WorkOvertimeDTO();
		// 将domain转成VO
		try {
			BeanUtils.copyProperties(workOvertimeDTO, workOvertime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		workOvertimeDTO.setId((java.lang.Long)workOvertime.getId());
		return workOvertimeDTO;
	}
	
	public WorkOvertimeDTO saveWorkOvertime(WorkOvertimeDTO workOvertimeDTO) {
		WorkOvertime workOvertime = new WorkOvertime();
		try {
        	BeanUtils.copyProperties(workOvertime, workOvertimeDTO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		workOvertime.save();
		workOvertimeDTO.setId((java.lang.Long)workOvertime.getId());
		return workOvertimeDTO;
	}
	
	public void updateWorkOvertime(WorkOvertimeDTO workOvertimeDTO) {
		//WorkOvertime workOvertime = WorkOvertime.get(WorkOvertime.class, workOvertimeDTO.getId());
		WorkOvertime workOvertime = WorkOvertime.get(WorkOvertime.class, workOvertimeDTO.getId());
		workOvertime.setDate(workOvertimeDTO.getDate());
		workOvertime.setStartTime(workOvertimeDTO.getStartTime());
		workOvertime.setEndTime(workOvertimeDTO.getEndTime());
		workOvertime.setWorkOvertimeType(workOvertimeDTO.getWorkOvertimeType());
		workOvertime.setRestOrMoney(workOvertimeDTO.getRestOrMoney());
		workOvertime.setHours(workOvertimeDTO.getHours());
		workOvertime.setMealSupplementTime(workOvertimeDTO.getMealSupplementTime());
		// 设置要更新的值
		try {
			workOvertime.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeWorkOvertime(Long id) {
		this.removeWorkOvertimes(new Long[] { id });
	}
	
	public void removeWorkOvertimes(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			WorkOvertime workOvertime = WorkOvertime.load(WorkOvertime.class, ids[i]);
			workOvertime.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WorkOvertimeDTO> findAllWorkOvertime() {
		List<WorkOvertimeDTO> list = new ArrayList<WorkOvertimeDTO>();
		List<WorkOvertime> all = WorkOvertime.findAll(WorkOvertime.class);
		for (WorkOvertime workOvertime : all) {
			WorkOvertimeDTO workOvertimeDTO = new WorkOvertimeDTO();
			// 将domain转成VO
			try {
				BeanUtils.copyProperties(workOvertimeDTO, workOvertime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(workOvertimeDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<WorkOvertimeDTO> pageQueryWorkOvertime(WorkOvertimeDTO queryVo, int currentPage, int pageSize) {
		List<WorkOvertimeDTO> result = new ArrayList<WorkOvertimeDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _workOvertime from WorkOvertime _workOvertime   where 1=1 ");
	
	
	   	if (queryVo.getEmployeeNo() != null && !"".equals(queryVo.getEmployeeNo())) {
	   		jpql.append(" and _workOvertime.employeeNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeNo()));
	   	}		
	
	   	if (queryVo.getEmployeeName() != null && !"".equals(queryVo.getEmployeeName())) {
	   		jpql.append(" and _workOvertime.employeeName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeName()));
	   	}		
	
	   	if (queryVo.getRunName() != null && !"".equals(queryVo.getRunName())) {
	   		jpql.append(" and _workOvertime.runName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRunName()));
	   	}		
	
	   	if (queryVo.getRunId() != null && !"".equals(queryVo.getRunId())) {
	   		jpql.append(" and _workOvertime.runId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRunId()));
	   	}		
	
	   	if (queryVo.getCreator() != null && !"".equals(queryVo.getCreator())) {
	   		jpql.append(" and _workOvertime.creator like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreator()));
	   	}		
	
	   	if (queryVo.getDepartmentName() != null && !"".equals(queryVo.getDepartmentName())) {
	   		jpql.append(" and _workOvertime.departmentName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDepartmentName()));
	   	}		
	   	if (queryVo.getAttenceTime() != null) {
	   		jpql.append(" and _workOvertime.date between ? and ? ");
	   		conditionVals.add(queryVo.getAttenceTime());
	   		conditionVals.add(queryVo.getAttenceTimeEnd());
	   	}
	   	if (queryVo.getDate() != null && !"".equals(queryVo.getDate())) {
	   		jpql.append(" and _workOvertime.date like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDate()));
	   	}		
	
	   	if (queryVo.getStartTime() != null && !"".equals(queryVo.getStartTime())) {
	   		jpql.append(" and _workOvertime.startTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStartTime()));
	   	}		
	
	   	if (queryVo.getEndTime() != null && !"".equals(queryVo.getEndTime())) {
	   		jpql.append(" and _workOvertime.endTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndTime()));
	   	}		
	
	   	if (queryVo.getWorkOvertimeType() != null && !"".equals(queryVo.getWorkOvertimeType())) {
	   		jpql.append(" and _workOvertime.workOvertimeType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWorkOvertimeType()));
	   	}		
	
	   	if (queryVo.getWorkOvertimeDescription() != null && !"".equals(queryVo.getWorkOvertimeDescription())) {
	   		jpql.append(" and _workOvertime.workOvertimeDescription like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWorkOvertimeDescription()));
	   	}		
	
	   	if (queryVo.getRestOrMoney() != null && !"".equals(queryVo.getRestOrMoney())) {
	   		jpql.append(" and _workOvertime.restOrMoney like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRestOrMoney()));
	   	}		
	
	   	if (queryVo.getHours() != null && !"".equals(queryVo.getHours())) {
	   		jpql.append(" and _workOvertime.hours like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getHours()));
	   	}		
	
	   	if (queryVo.getMealSupplementType() != null && !"".equals(queryVo.getMealSupplementType())) {
	   		jpql.append(" and _workOvertime.mealSupplementType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMealSupplementType()));
	   	}		
	
	   	if (queryVo.getMealSupplementTime() != null && !"".equals(queryVo.getMealSupplementTime())) {
	   		jpql.append(" and _workOvertime.mealSupplementTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMealSupplementTime()));
	   	}
	   	if(queryVo.getSortname() != null && !"".equals(queryVo.getSortname()))
		{
				jpql.append(" order by _workOvertime."+queryVo.getSortname()+" ").append(queryVo.getSortorder());
		}
	   	else{
	   		jpql.append(" order by _workOvertime.date desc");
	   	}
        Page<WorkOvertime> pages = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
        for (WorkOvertime workOvertime : pages.getData()) {
            WorkOvertimeDTO workOvertimeDTO = new WorkOvertimeDTO();
            
             // 将domain转成VO
            try {
            	BeanUtils.copyProperties(workOvertimeDTO, workOvertime);
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            
                                                                                                                                                                                                                                                   result.add(workOvertimeDTO);
        }
        return new Page<WorkOvertimeDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
}

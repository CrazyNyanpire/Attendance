
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
import com.acetecsemi.attendance.attendance.application.core.ScheduleApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class ScheduleApplicationImpl implements ScheduleApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ScheduleDTO getSchedule(Long id) {
		Schedule schedule = Schedule.load(Schedule.class, id);
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		// 将domain转成VO
		try {
			BeanUtils.copyProperties(scheduleDTO, schedule);
		} catch (Exception e) {
			e.printStackTrace();
		}
		scheduleDTO.setId((java.lang.Long)schedule.getId());
		return scheduleDTO;
	}
	
	public ScheduleDTO saveSchedule(ScheduleDTO scheduleDTO) {
		Schedule schedule = new Schedule();
		try {
        	BeanUtils.copyProperties(schedule, scheduleDTO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		schedule.save();
		scheduleDTO.setId((java.lang.Long)schedule.getId());
		return scheduleDTO;
	}
	
	public void updateSchedule(ScheduleDTO scheduleDTO) {
		Schedule schedule = Schedule.get(Schedule.class, scheduleDTO.getId());
		// 设置要更新的值
		try {
			BeanUtils.copyProperties(schedule, scheduleDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeSchedule(Long id) {
		this.removeSchedules(new Long[] { id });
	}
	
	public void removeSchedules(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Schedule schedule = Schedule.load(Schedule.class, ids[i]);
			schedule.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ScheduleDTO> findAllSchedule() {
		List<ScheduleDTO> list = new ArrayList<ScheduleDTO>();
		List<Schedule> all = Schedule.findAll(Schedule.class);
		for (Schedule schedule : all) {
			ScheduleDTO scheduleDTO = new ScheduleDTO();
			// 将domain转成VO
			try {
				BeanUtils.copyProperties(scheduleDTO, schedule);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(scheduleDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<ScheduleDTO> pageQuerySchedule(ScheduleDTO queryVo, int currentPage, int pageSize) {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _schedule from Schedule _schedule   where 1=1 ");
	
	   	if (queryVo.getScheduleDate() != null) {
	   		jpql.append(" and _schedule.scheduleDate=?");
	   		conditionVals.add(queryVo.getScheduleDate());
	   	}	
	
	   	if (queryVo.getScheduleType() != null) {
	   		jpql.append(" and _schedule.scheduleType=?");
	   		conditionVals.add(queryVo.getScheduleType());
	   	}	
	
	   	if (queryVo.getDutyType() != null) {
	   		jpql.append(" and _schedule.dutyType=?");
	   		conditionVals.add(queryVo.getDutyType());
	   	}	
	
        Page<Schedule> pages = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
        for (Schedule schedule : pages.getData()) {
            ScheduleDTO scheduleDTO = new ScheduleDTO();
            
             // 将domain转成VO
            try {
            	BeanUtils.copyProperties(scheduleDTO, schedule);
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            
                                                               result.add(scheduleDTO);
        }
        return new Page<ScheduleDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
}

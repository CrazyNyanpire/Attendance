
package com.acetecsemi.attendance.attendance.application.impl.core;

import java.util.Date;
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
import com.acetecsemi.attendance.attendance.application.core.ClockViewApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class ClockViewApplicationImpl implements ClockViewApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ClockViewDTO getClockView(Long id) {
		ClockView clockView = ClockView.load(ClockView.class, id);
		ClockViewDTO clockViewDTO = new ClockViewDTO();
		// 将domain转成VO
		try {
			BeanUtils.copyProperties(clockViewDTO, clockView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		clockViewDTO.setId((java.lang.Long)clockView.getId());
		return clockViewDTO;
	}
	
	public ClockViewDTO saveClockView(ClockViewDTO clockViewDTO) {
		ClockView clockView = new ClockView();
		try {
        	BeanUtils.copyProperties(clockView, clockViewDTO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		clockView.save();
		clockViewDTO.setId((java.lang.Long)clockView.getId());
		return clockViewDTO;
	}
	
	public void updateClockView(ClockViewDTO clockViewDTO) {
		ClockView clockView = ClockView.get(ClockView.class, clockViewDTO.getId());
		// 设置要更新的值
		try {
			BeanUtils.copyProperties(clockView, clockViewDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeClockView(Long id) {
		this.removeClockViews(new Long[] { id });
	}
	
	public void removeClockViews(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			ClockView clockView = ClockView.load(ClockView.class, ids[i]);
			clockView.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClockViewDTO> findAllClockView() {
		List<ClockViewDTO> list = new ArrayList<ClockViewDTO>();
		List<ClockView> all = ClockView.findAll(ClockView.class);
		for (ClockView clockView : all) {
			ClockViewDTO clockViewDTO = new ClockViewDTO();
			// 将domain转成VO
			try {
				BeanUtils.copyProperties(clockViewDTO, clockView);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(clockViewDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<ClockViewDTO> pageQueryClockView(ClockViewDTO queryVo, int currentPage, int pageSize) {
		List<ClockViewDTO> result = new ArrayList<ClockViewDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select attencetime,count(*),CONCAT(CONVERT(COUNT( CASE WHEN b.attendenceInType = '3' or  b.attendenceInType = '13' THEN 1 ELSE NULL END ),char),'(',CONVERT(COUNT( CASE WHEN b.attendenceInType = '13' THEN 1 ELSE NULL END ),char),')'), COUNT( CASE WHEN  b.attendenceInType ='5' THEN 1 ELSE NULL END ),CONCAT(CONVERT(COUNT( CASE WHEN b.attendenceOutType = '4' or  b.attendenceOutType = '14' THEN 1 ELSE NULL END ),char),'(',CONVERT(COUNT( CASE WHEN b.attendenceOutType = '14' THEN 1 ELSE NULL END ),char),')'),COUNT( CASE WHEN  b.attendenceOutType ='6' THEN 1 ELSE NULL END ),COUNT( CASE WHEN  b.attendenceInType ='11' THEN 1 ELSE NULL END ),COUNT( CASE WHEN  b.attendenceOutType ='12' THEN 1 ELSE NULL END ),COUNT( CASE WHEN  b.attendenceOutType is null or b.attendenceOutType='10' THEN 1 ELSE NULL END ) from  attence_clockdetail b where 1=1");
	
	   	if (queryVo.getAttendenceTime() != null) {
	   		jpql.append(" and attencetime between ? and ? ");
	   		conditionVals.add(queryVo.getAttendenceTime());
	   		conditionVals.add(queryVo.getAttendenceTimeEnd());
	   	}	
	   	
	   	jpql.append(" group by attencetime DESC");
        Page<Object[]> pages = getQueryChannelService().createSqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
        
        for (Object[] object : pages.getData()) {
            // 将domain转成VO
            ClockViewDTO clockViewDTO = new ClockViewDTO();
            clockViewDTO.setAttendenceTime((Date)object[0]);
            clockViewDTO.setHeadcount(object[1].toString());
            clockViewDTO.setNormalInClock(object[2].toString());
            clockViewDTO.setLateClock(object[3].toString());
            clockViewDTO.setNormalOutClock(object[4].toString());
            clockViewDTO.setEarlyClock(object[5].toString());
            clockViewDTO.setNoNeedInClock(object[6].toString());
            clockViewDTO.setNoNeedOutClock(object[7].toString());
            clockViewDTO.setErroClock(object[8].toString());
            result.add(clockViewDTO);
        }
        return new Page<ClockViewDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
}

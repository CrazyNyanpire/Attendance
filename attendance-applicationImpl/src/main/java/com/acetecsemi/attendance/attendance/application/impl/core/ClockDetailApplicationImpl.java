
package com.acetecsemi.attendance.attendance.application.impl.core;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.domain.SqlQuery;
import org.dayatang.querychannel.Page;
import org.dayatang.querychannel.QueryChannelService;

import com.acetecsemi.attendance.attendance.application.dto.*;
import com.acetecsemi.attendance.attendance.application.core.ClockDetailApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class ClockDetailApplicationImpl implements ClockDetailApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ClockDetailDTO getClockDetail(Long id) {
		ClockDetail clockDetail = ClockDetail.load(ClockDetail.class, id);
		ClockDetailDTO clockDetailDTO = new ClockDetailDTO();
		// 灏哾omain杞垚VO
		try {
			BeanUtils.copyProperties(clockDetailDTO, clockDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		clockDetailDTO.setId((java.lang.Long)clockDetail.getId());
		return clockDetailDTO;
	}
	
	public ClockDetailDTO saveClockDetail(ClockDetailDTO clockDetailDTO) {
		ClockDetail clockDetail = new ClockDetail();
		try {
        	BeanUtils.copyProperties(clockDetail, clockDetailDTO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		clockDetail.save();
		clockDetailDTO.setId((java.lang.Long)clockDetail.getId());
		return clockDetailDTO;
	}
	
	public void updateClockDetail(ClockDetailDTO clockDetailDTO) {
		ClockDetail clockDetail = ClockDetail.get(ClockDetail.class, clockDetailDTO.getId());
		// 璁剧疆瑕佹洿鏂扮殑鍊�
		try {
			BeanUtils.copyProperties(clockDetail, clockDetailDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeClockDetail(Long id) {
		this.removeClockDetails(new Long[] { id });
	}
	
	public void removeClockDetails(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			ClockDetail clockDetail = ClockDetail.load(ClockDetail.class, ids[i]);
			clockDetail.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClockDetailDTO> findAllClockDetail() {
		List<ClockDetailDTO> list = new ArrayList<ClockDetailDTO>();
		List<ClockDetail> all = ClockDetail.findAll(ClockDetail.class);
		for (ClockDetail clockDetail : all) {
			ClockDetailDTO clockDetailDTO = new ClockDetailDTO();
			// 灏哾omain杞垚VO
			try {
				BeanUtils.copyProperties(clockDetailDTO, clockDetail);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(clockDetailDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<ClockDetailDTO> pageQueryClockDetail(ClockDetailDTO queryVo, int currentPage, int pageSize) {
		List<ClockDetailDTO> result = new ArrayList<ClockDetailDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _clockDetail from ClockDetail _clockDetail   where 1=1 ");
	
	
	   	if (queryVo.getAttenceTime() != null) {
	   		jpql.append(" and _clockDetail.attenceTime between ? and ? ");
	   		conditionVals.add(queryVo.getAttenceTime());
	   		conditionVals.add(queryVo.getAttenceTimeEnd());
	   	}	
	
	   	if (queryVo.getEmployeeNo() != null && !"".equals(queryVo.getEmployeeNo())) {
	   		jpql.append(" and _clockDetail.employeeNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeNo()));
	   	}		
	
	   	if (queryVo.getName() != null && !"".equals(queryVo.getName())) {
	   		jpql.append(" and _clockDetail.name like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getName()));
	   	}		
	
	   	if (queryVo.getClockIn() != null && !"".equals(queryVo.getClockIn())) {
	   		jpql.append(" and _clockDetail.clockIn like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getClockIn()));
	   	}		
	
	   	if (queryVo.getAttendenceInType() != null && !"".equals(queryVo.getAttendenceInType())) {
	   		jpql.append(" and _clockDetail.attendenceInType  in("+queryVo.getAttendenceInType()+")");
	   	}		
	
	   	if (queryVo.getClockOut() != null && !"".equals(queryVo.getClockOut())) {
	   		jpql.append(" and _clockDetail.clockOut like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getClockOut()));
	   	}		
	
	   	if (queryVo.getAttendenceOutType() != null && !"".equals(queryVo.getAttendenceOutType())) {
	   		jpql.append(" and _clockDetail.attendenceOutType in("+queryVo.getAttendenceOutType()+")");
	   	}		
	
	   	if (queryVo.getAttendenceType() != null && !"".equals(queryVo.getAttendenceType())) {
	   		jpql.append(" and _clockDetail.attendenceType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttendenceType()));
	   	}
	   	jpql.append(" order by _clockDetail.attenceTime DESC");
        Page<ClockDetail> pages = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
        StringBuilder jpqlc = new StringBuilder("select code,type from am_recordtype");
    	List<Object[]> mapdate = getQueryChannelService().createSqlQuery(jpqlc.toString()).list();
        Map<String, String> mapc = new HashMap<String, String>();
	    for (Object[] object : mapdate) {
	    		mapc.put(object[0].toString(),object[1].toString());
	        }
        Map<String, String> map = new HashMap<String, String>();
    	map.put("1", "白班");
    	map.put("2", "夜班");
    	map.put("0", "常白班");
        for (ClockDetail clockDetail : pages.getData()) {
            ClockDetailDTO clockDetailDTO = new ClockDetailDTO();
            
             // 灏哾omain杞垚VO
            try {
            	BeanUtils.copyProperties(clockDetailDTO, clockDetail);
            	String attType=clockDetailDTO.getAttendenceType();
            	clockDetailDTO.setAttendenceType(map.get(attType));
            	String attTypeone=clockDetailDTO.getAttendenceInType();
            	clockDetailDTO.setAttendenceInType(mapc.get(attTypeone));
            	String attTypetwo=clockDetailDTO.getAttendenceOutType();
            	clockDetailDTO.setAttendenceOutType(mapc.get(attTypetwo));
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            
            result.add(clockDetailDTO);
        }
        return new Page<ClockDetailDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
	public List<ClockDetailDTO> queryAttenceRecordDetailList(ClockDetailDTO queryVo){
		List<ClockDetailDTO> result = new ArrayList<ClockDetailDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _clockDetail from ClockDetail _clockDetail   where 1=1 ");
	
	   	if (queryVo.getAttenceTime() != null) {
	   		jpql.append(" and _clockDetail.attenceTime between ? and ? ");
	   		conditionVals.add(queryVo.getAttenceTime());
	   		conditionVals.add(queryVo.getAttenceTimeEnd());
	   	}	
	
	   	if (queryVo.getEmployeeNo() != null && !"".equals(queryVo.getEmployeeNo())) {
	   		jpql.append(" and _clockDetail.employeeNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeNo()));
	   	}		
	
	   	if (queryVo.getName() != null && !"".equals(queryVo.getName())) {
	   		jpql.append(" and _clockDetail.name like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getName()));
	   	}		
	
	   	if (queryVo.getClockIn() != null && !"".equals(queryVo.getClockIn())) {
	   		jpql.append(" and _clockDetail.clockIn like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getClockIn()));
	   	}		
	
	   	if (queryVo.getAttendenceInType() != null && !"".equals(queryVo.getAttendenceInType())) {
	   		jpql.append(" and _clockDetail.attendenceInType  in("+queryVo.getAttendenceInType()+")");
	   	}		
	
	   	if (queryVo.getClockOut() != null && !"".equals(queryVo.getClockOut())) {
	   		jpql.append(" and _clockDetail.clockOut like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getClockOut()));
	   	}		
	
	   	if (queryVo.getAttendenceOutType() != null && !"".equals(queryVo.getAttendenceOutType())) {
	   		jpql.append(" and _clockDetail.attendenceOutType in("+queryVo.getAttendenceOutType()+")");
	   	}		
	
	   	if (queryVo.getAttendenceType() != null && !"".equals(queryVo.getAttendenceType())) {
	   		jpql.append(" and _clockDetail.attendenceType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttendenceType()));
	   	}
	   	jpql.append(" order by _clockDetail.attenceTime DESC");
        List<ClockDetail> list = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).list();
        StringBuilder jpqlc = new StringBuilder("select code,type from am_recordtype");
        for (ClockDetail clockDetail : list) {
            ClockDetailDTO clockDetailDTO = new ClockDetailDTO();
            try {
            	BeanUtils.copyProperties(clockDetailDTO, clockDetail);
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            
            result.add(clockDetailDTO);
        }

		return result;
	}
	
}

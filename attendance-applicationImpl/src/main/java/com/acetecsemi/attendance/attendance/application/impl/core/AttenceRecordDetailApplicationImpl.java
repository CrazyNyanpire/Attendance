
package com.acetecsemi.attendance.attendance.application.impl.core;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.querychannel.Page;
import org.dayatang.querychannel.QueryChannelService;

import com.acetecsemi.attendance.attendance.application.dto.*;
import com.acetecsemi.attendance.attendance.application.core.AttenceRecordDetailApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class AttenceRecordDetailApplicationImpl implements AttenceRecordDetailApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AttenceRecordDetailDTO getAttenceRecordDetail(Long id) {
		AttenceRecordDetail attenceRecordDetail = AttenceRecordDetail.load(AttenceRecordDetail.class, id);
		AttenceRecordDetailDTO attenceRecordDetailDTO = new AttenceRecordDetailDTO();
		// 将domain转成VO
		try {
			BeanUtils.copyProperties(attenceRecordDetailDTO, attenceRecordDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		attenceRecordDetailDTO.setId((java.lang.Long)attenceRecordDetail.getId());
		return attenceRecordDetailDTO;
	}
	
	public AttenceRecordDetailDTO saveAttenceRecordDetail(AttenceRecordDetailDTO attenceRecordDetailDTO) {
		AttenceRecordDetail attenceRecordDetail = new AttenceRecordDetail();
		try {
			attenceRecordDetailDTO.setOptDate(new Date());
        	BeanUtils.copyProperties(attenceRecordDetail, attenceRecordDetailDTO);
		} catch (Exception e) {
        	e.printStackTrace();
        }
		attenceRecordDetail.save();
		attenceRecordDetailDTO.setId((java.lang.Long)attenceRecordDetail.getId());
		return attenceRecordDetailDTO;
	}
	
	public Map<String, String> getAttenceType(){
		StringBuilder jpqlc = new StringBuilder("select code,type from am_recordtype");
    	List<Object[]> mapdate = getQueryChannelService().createSqlQuery(jpqlc.toString()).list();
        Map<String, String> mapc = new HashMap<String, String>();
	    for (Object[] object : mapdate) {
	    		mapc.put(object[0].toString(),object[1].toString());
	        }
		return mapc;
	}
	
	public void updateAttenceRecordDetail(AttenceRecordDetailDTO attenceRecordDetailDTO) {
		AttenceRecordDetail attenceRecordDetail = AttenceRecordDetail.get(AttenceRecordDetail.class, attenceRecordDetailDTO.getId());
		// 设置要更新的值
		try {
			attenceRecordDetailDTO.setOptDate(new Date());
			BeanUtils.copyProperties(attenceRecordDetail, attenceRecordDetailDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeAttenceRecordDetail(Long id) {
		this.removeAttenceRecordDetails(new Long[] { id });
	}
	
	public void removeAttenceRecordDetails(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			AttenceRecordDetail attenceRecordDetail = AttenceRecordDetail.load(AttenceRecordDetail.class, ids[i]);
			attenceRecordDetail.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AttenceRecordDetailDTO> findAllAttenceRecordDetail() {
		List<AttenceRecordDetailDTO> list = new ArrayList<AttenceRecordDetailDTO>();
		List<AttenceRecordDetail> all = AttenceRecordDetail.findAll(AttenceRecordDetail.class);
		for (AttenceRecordDetail attenceRecordDetail : all) {
			AttenceRecordDetailDTO attenceRecordDetailDTO = new AttenceRecordDetailDTO();
			// 将domain转成VO
			try {
				BeanUtils.copyProperties(attenceRecordDetailDTO, attenceRecordDetail);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(attenceRecordDetailDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<AttenceRecordDetailDTO> pageQueryAttenceRecordDetail(AttenceRecordDetailDTO queryVo, int currentPage, int pageSize) {
		List<AttenceRecordDetailDTO> result = new ArrayList<AttenceRecordDetailDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _attenceRecordDetail from AttenceRecordDetail _attenceRecordDetail   where 1=1 ");
	
	
	   	if (queryVo.getAttenceTime() != null) {
	   		jpql.append(" and _attenceRecordDetail.attenceTime between ? and ? ");
	   		conditionVals.add(queryVo.getAttenceTime());
	   		conditionVals.add(queryVo.getAttenceTimeEnd());
	   	}	
	
	   	if (queryVo.getAttenceType() != null && !"".equals(queryVo.getAttenceType())) {
	   		jpql.append(" and _attenceRecordDetail.attenceType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttenceType()));
	   	}		
	
	   	if (queryVo.getEmployeeNo() != null && !"".equals(queryVo.getEmployeeNo())) {
	   		jpql.append(" and _attenceRecordDetail.employeeNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeNo()));
	   	}		
	
	   	if (queryVo.getEmpolyeeName() != null && !"".equals(queryVo.getEmpolyeeName())) {
	   		jpql.append(" and _attenceRecordDetail.empolyeeName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmpolyeeName()));
	   	}		
	   	if (queryVo.getAttenceRecordFileId() != null) {
	   		jpql.append(" and _attenceRecordDetail.attenceRecordFileId=?");
	   		conditionVals.add(queryVo.getAttenceRecordFileId());
	   	}
	   	if(queryVo.getSortname() != null && !"".equals(queryVo.getSortname()))
		{
				jpql.append(" order by _attenceRecordDetail."+queryVo.getSortname()+" ").append(queryVo.getSortorder());
		}
	   	jpql.append(" order by _attenceRecordDetail.attenceTime DESC");
        Page<AttenceRecordDetail> pages = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
       
        StringBuilder jpqlc = new StringBuilder("select code,type from am_recordtype");
    	List<Object[]> mapdate = getQueryChannelService().createSqlQuery(jpqlc.toString()).list();
        Map<String, String> mapc = new HashMap<String, String>(); 
	    for (Object[] object : mapdate) {
	    		mapc.put(object[0].toString(),object[1].toString());
	        }
    	for (AttenceRecordDetail attenceRecordDetail : pages.getData()) {
            AttenceRecordDetailDTO attenceRecordDetailDTO = new AttenceRecordDetailDTO();
             // 将domain转成VO
            try {
            	BeanUtils.copyProperties(attenceRecordDetailDTO, attenceRecordDetail);
            	String attType=attenceRecordDetailDTO.getAttenceType();
            	attenceRecordDetailDTO.setAttenceType(mapc.get(attType));
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            result.add(attenceRecordDetailDTO);
        }
        return new Page<AttenceRecordDetailDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
}

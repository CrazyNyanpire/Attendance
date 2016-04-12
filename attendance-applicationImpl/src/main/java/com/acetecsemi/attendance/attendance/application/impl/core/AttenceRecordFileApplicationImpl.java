
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
import com.acetecsemi.attendance.attendance.application.core.AttenceRecordFileApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class AttenceRecordFileApplicationImpl implements AttenceRecordFileApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AttenceRecordFileDTO getAttenceRecordFile(Long id) {
		AttenceRecordFile attenceRecordFile = AttenceRecordFile.load(AttenceRecordFile.class, id);
		AttenceRecordFileDTO attenceRecordFileDTO = new AttenceRecordFileDTO();
		// 将domain转成VO
		try {
			BeanUtils.copyProperties(attenceRecordFileDTO, attenceRecordFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		attenceRecordFileDTO.setId((java.lang.Long)attenceRecordFile.getId());
		return attenceRecordFileDTO;
	}
	
	public AttenceRecordFileDTO saveAttenceRecordFile(AttenceRecordFileDTO attenceRecordFileDTO) {
		AttenceRecordFile attenceRecordFile = new AttenceRecordFile();
		try {
        	BeanUtils.copyProperties(attenceRecordFile, attenceRecordFileDTO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		attenceRecordFile.save();
		attenceRecordFileDTO.setId((java.lang.Long)attenceRecordFile.getId());
		return attenceRecordFileDTO;
	}
	
	public void updateAttenceRecordFile(AttenceRecordFileDTO attenceRecordFileDTO) {
		AttenceRecordFile attenceRecordFile = AttenceRecordFile.get(AttenceRecordFile.class, attenceRecordFileDTO.getId());
		// 设置要更新的值
		try {
			BeanUtils.copyProperties(attenceRecordFile, attenceRecordFileDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeAttenceRecordFile(Long id) {
		this.removeAttenceRecordFiles(new Long[] { id });
	}
	
	public void removeAttenceRecordFiles(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			AttenceRecordFile attenceRecordFile = AttenceRecordFile.load(AttenceRecordFile.class, ids[i]);
			attenceRecordFile.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AttenceRecordFileDTO> findAllAttenceRecordFile() {
		List<AttenceRecordFileDTO> list = new ArrayList<AttenceRecordFileDTO>();
		List<AttenceRecordFile> all = AttenceRecordFile.findAll(AttenceRecordFile.class);
		for (AttenceRecordFile attenceRecordFile : all) {
			AttenceRecordFileDTO attenceRecordFileDTO = new AttenceRecordFileDTO();
			// 将domain转成VO
			try {
				BeanUtils.copyProperties(attenceRecordFileDTO, attenceRecordFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(attenceRecordFileDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<AttenceRecordFileDTO> pageQueryAttenceRecordFile(AttenceRecordFileDTO queryVo, int currentPage, int pageSize) {
		List<AttenceRecordFileDTO> result = new ArrayList<AttenceRecordFileDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _attenceRecordFile from AttenceRecordFile _attenceRecordFile   where 1=1 ");
	
	
	   	if (queryVo.getFileName() != null && !"".equals(queryVo.getFileName())) {
	   		jpql.append(" and _attenceRecordFile.fileName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getFileName()));
	   	}		
	
	   	if (queryVo.getImportTime() != null) {
	   		jpql.append(" and _attenceRecordFile.importTime between ? and ? ");
	   		conditionVals.add(queryVo.getImportTime());
	   		conditionVals.add(queryVo.getImportTimeEnd());
	   	}	
	   	if (queryVo.getRecord() != null) {
	   		jpql.append(" and _attenceRecordFile.record=?");
	   		conditionVals.add(queryVo.getRecord());
	   	}	
	
	   	if (queryVo.getRecordSuccess() != null) {
	   		jpql.append(" and _attenceRecordFile.recordSuccess=?");
	   		conditionVals.add(queryVo.getRecordSuccess());
	   	}	
	
	
	   	if (queryVo.getPath() != null && !"".equals(queryVo.getPath())) {
	   		jpql.append(" and _attenceRecordFile.path like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPath()));
	   	}
	   	jpql.append(" order by _attenceRecordFile.importTime DESC");
        Page<AttenceRecordFile> pages = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
        for (AttenceRecordFile attenceRecordFile : pages.getData()) {
            AttenceRecordFileDTO attenceRecordFileDTO = new AttenceRecordFileDTO();
            
             // 将domain转成VO
            try {
            	BeanUtils.copyProperties(attenceRecordFileDTO, attenceRecordFile);
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            
                                                                              result.add(attenceRecordFileDTO);
        }
        return new Page<AttenceRecordFileDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
}

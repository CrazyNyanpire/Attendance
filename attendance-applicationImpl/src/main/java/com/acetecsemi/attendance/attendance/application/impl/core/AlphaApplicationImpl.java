
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
import com.acetecsemi.attendance.attendance.application.core.AlphaApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class AlphaApplicationImpl implements AlphaApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AlphaDTO getAlpha(Long id) {
		Alpha alpha = Alpha.load(Alpha.class, id);
		AlphaDTO alphaDTO = new AlphaDTO();
		// 将domain转成VO
		try {
			BeanUtils.copyProperties(alphaDTO, alpha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		alphaDTO.setId((java.lang.Long)alpha.getId());
		return alphaDTO;
	}
	
	public AlphaDTO saveAlpha(AlphaDTO alphaDTO) {
		Alpha alpha = new Alpha();
		try {
        	BeanUtils.copyProperties(alpha, alphaDTO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		alpha.save();
		alphaDTO.setId((java.lang.Long)alpha.getId());
		return alphaDTO;
	}
	
	public void updateAlpha(AlphaDTO alphaDTO) {
		Alpha alpha = Alpha.get(Alpha.class, alphaDTO.getId());
		// 设置要更新的值
		try {
			BeanUtils.copyProperties(alpha, alphaDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeAlpha(Long id) {
		this.removeAlphas(new Long[] { id });
	}
	
	public void removeAlphas(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Alpha alpha = Alpha.load(Alpha.class, ids[i]);
			alpha.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AlphaDTO> findAllAlpha() {
		List<AlphaDTO> list = new ArrayList<AlphaDTO>();
		List<Alpha> all = Alpha.findAll(Alpha.class);
		for (Alpha alpha : all) {
			AlphaDTO alphaDTO = new AlphaDTO();
			// 将domain转成VO
			try {
				BeanUtils.copyProperties(alphaDTO, alpha);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(alphaDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<AlphaDTO> pageQueryAlpha(AlphaDTO queryVo, int currentPage, int pageSize) {
		List<AlphaDTO> result = new ArrayList<AlphaDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _alpha from Alpha _alpha   where 1=1 ");
	
	
	   	if (queryVo.getFileName() != null && !"".equals(queryVo.getFileName())) {
	   		jpql.append(" and _alpha.fileName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getFileName()));
	   	}		
	
	   	if (queryVo.getImportTime() != null) {
	   		jpql.append(" and _alpha.importTime between ? and ? ");
	   		conditionVals.add(queryVo.getImportTime());
	   		conditionVals.add(queryVo.getImportTimeEnd());
	   	}	
	   	if (queryVo.getRecord() != null) {
	   		jpql.append(" and _alpha.record=?");
	   		conditionVals.add(queryVo.getRecord());
	   	}	
	
	   	if (queryVo.getTrueRecord() != null) {
	   		jpql.append(" and _alpha.trueRecord=?");
	   		conditionVals.add(queryVo.getTrueRecord());
	   	}	
	
        Page<Alpha> pages = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
        for (Alpha alpha : pages.getData()) {
            AlphaDTO alphaDTO = new AlphaDTO();
            
             // 将domain转成VO
            try {
            	BeanUtils.copyProperties(alphaDTO, alpha);
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            
                                                                              result.add(alphaDTO);
        }
        return new Page<AlphaDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
}

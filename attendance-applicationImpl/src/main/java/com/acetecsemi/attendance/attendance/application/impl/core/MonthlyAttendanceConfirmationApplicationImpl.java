
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
import com.acetecsemi.attendance.attendance.application.core.MonthlyAttendanceConfirmationApplication;
import com.acetecsemi.attendance.attendance.core.*;

@Named
@Transactional
public class MonthlyAttendanceConfirmationApplicationImpl implements MonthlyAttendanceConfirmationApplication {


	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MonthlyAttendanceConfirmationDTO getMonthlyAttendanceConfirmation(Long id) {
		MonthlyAttendanceConfirmation monthlyAttendanceConfirmation = MonthlyAttendanceConfirmation.load(MonthlyAttendanceConfirmation.class, id);
		MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmationDTO = new MonthlyAttendanceConfirmationDTO();
		// 将domain转成VO
		try {
			BeanUtils.copyProperties(monthlyAttendanceConfirmationDTO, monthlyAttendanceConfirmation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		monthlyAttendanceConfirmationDTO.setId((java.lang.Long)monthlyAttendanceConfirmation.getId());
		return monthlyAttendanceConfirmationDTO;
	}
	
	public MonthlyAttendanceConfirmationDTO saveMonthlyAttendanceConfirmation(MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmationDTO) {
		MonthlyAttendanceConfirmation monthlyAttendanceConfirmation = new MonthlyAttendanceConfirmation();
		try {
        	BeanUtils.copyProperties(monthlyAttendanceConfirmation, monthlyAttendanceConfirmationDTO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		monthlyAttendanceConfirmation.save();
		monthlyAttendanceConfirmationDTO.setId((java.lang.Long)monthlyAttendanceConfirmation.getId());
		return monthlyAttendanceConfirmationDTO;
	}
	
	public void updateMonthlyAttendanceConfirmation(MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmationDTO) {
		MonthlyAttendanceConfirmation monthlyAttendanceConfirmation = MonthlyAttendanceConfirmation.get(MonthlyAttendanceConfirmation.class, monthlyAttendanceConfirmationDTO.getId());
		// 设置要更新的值
		try {
			BeanUtils.copyProperties(monthlyAttendanceConfirmation, monthlyAttendanceConfirmationDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeMonthlyAttendanceConfirmation(Long id) {
		this.removeMonthlyAttendanceConfirmations(new Long[] { id });
	}
	
	public void removeMonthlyAttendanceConfirmations(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			MonthlyAttendanceConfirmation monthlyAttendanceConfirmation = MonthlyAttendanceConfirmation.load(MonthlyAttendanceConfirmation.class, ids[i]);
			monthlyAttendanceConfirmation.remove();
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MonthlyAttendanceConfirmationDTO> findAllMonthlyAttendanceConfirmation() {
		List<MonthlyAttendanceConfirmationDTO> list = new ArrayList<MonthlyAttendanceConfirmationDTO>();
		List<MonthlyAttendanceConfirmation> all = MonthlyAttendanceConfirmation.findAll(MonthlyAttendanceConfirmation.class);
		for (MonthlyAttendanceConfirmation monthlyAttendanceConfirmation : all) {
			MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmationDTO = new MonthlyAttendanceConfirmationDTO();
			// 将domain转成VO
			try {
				BeanUtils.copyProperties(monthlyAttendanceConfirmationDTO, monthlyAttendanceConfirmation);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(monthlyAttendanceConfirmationDTO);
		}
		return list;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<MonthlyAttendanceConfirmationDTO> pageQueryMonthlyAttendanceConfirmation(MonthlyAttendanceConfirmationDTO queryVo, int currentPage, int pageSize) {
		List<MonthlyAttendanceConfirmationDTO> result = new ArrayList<MonthlyAttendanceConfirmationDTO>();
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _monthlyAttendanceConfirmation from MonthlyAttendanceConfirmation _monthlyAttendanceConfirmation   where 1=1 ");
	
	
	   	if (queryVo.getName() != null && !"".equals(queryVo.getName())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.name like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getName()));
	   	}		
	
	   	if (queryVo.getEmployeeNo() != null && !"".equals(queryVo.getEmployeeNo())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.employeeNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmployeeNo()));
	   	}		
	
	   	if (queryVo.getStakeclass_d() != null && !"".equals(queryVo.getStakeclass_d())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.stakeclass_d like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStakeclass_d()));
	   	}		
	
	   	if (queryVo.getAtakeclass_d() != null && !"".equals(queryVo.getAtakeclass_d())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.atakeclass_d like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAtakeclass_d()));
	   	}		
	
	   	if (queryVo.getMealAllowanced_d() != null && !"".equals(queryVo.getMealAllowanced_d())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.mealAllowanced_d like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMealAllowanced_d()));
	   	}		
	
	   	if (queryVo.getStakeclass_n() != null && !"".equals(queryVo.getStakeclass_n())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.stakeclass_n like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStakeclass_n()));
	   	}		
	
	   	if (queryVo.getAtakeclass_n() != null && !"".equals(queryVo.getAtakeclass_n())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.atakeclass_n like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAtakeclass_n()));
	   	}		
	
	   	if (queryVo.getMealAllowanced_n() != null && !"".equals(queryVo.getMealAllowanced_n())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.mealAllowanced_n like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMealAllowanced_n()));
	   	}		
	
	   	if (queryVo.getStakeclass_nor() != null && !"".equals(queryVo.getStakeclass_nor())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.stakeclass_nor like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStakeclass_nor()));
	   	}		
	
	   	if (queryVo.getAtakeclass_nor() != null && !"".equals(queryVo.getAtakeclass_nor())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.atakeclass_nor like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAtakeclass_nor()));
	   	}		
	
	   	if (queryVo.getMealAllowanced_nor() != null && !"".equals(queryVo.getMealAllowanced_nor())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.mealAllowanced_nor like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMealAllowanced_nor()));
	   	}		
	
	   	if (queryVo.getTravelAllowance() != null && !"".equals(queryVo.getTravelAllowance())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.travelAllowance like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTravelAllowance()));
	   	}		
	
	   	if (queryVo.getOvertime_work() != null && !"".equals(queryVo.getOvertime_work())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.overtime_work like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOvertime_work()));
	   	}		
	
	   	if (queryVo.getOvertime_week() != null && !"".equals(queryVo.getOvertime_week())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.overtime_week like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOvertime_week()));
	   	}		
	
	   	if (queryVo.getOvertime_holiday() != null && !"".equals(queryVo.getOvertime_holiday())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.overtime_holiday like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOvertime_holiday()));
	   	}		
	
	   	if (queryVo.getOvertime_Rest() != null && !"".equals(queryVo.getOvertime_Rest())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.overtime_Rest like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOvertime_Rest()));
	   	}		
	
	   	if (queryVo.getRest_personal() != null && !"".equals(queryVo.getRest_personal())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.rest_personal like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRest_personal()));
	   	}		
	
	   	if (queryVo.getRest_sickness() != null && !"".equals(queryVo.getRest_sickness())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.rest_sickness like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRest_sickness()));
	   	}		
	
	   	if (queryVo.getRest_marry() != null && !"".equals(queryVo.getRest_marry())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.rest_marry like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRest_marry()));
	   	}		
	
	   	if (queryVo.getRest_maternity() != null && !"".equals(queryVo.getRest_maternity())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.rest_maternity like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRest_maternity()));
	   	}		
	
	   	if (queryVo.getRest_funeral() != null && !"".equals(queryVo.getRest_funeral())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.rest_funeral like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRest_funeral()));
	   	}		
	
	   	if (queryVo.getRest_plan_maternity() != null && !"".equals(queryVo.getRest_plan_maternity())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.rest_plan_maternity like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRest_plan_maternity()));
	   	}		
	
	   	if (queryVo.getRest_bruise() != null && !"".equals(queryVo.getRest_bruise())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.rest_bruise like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRest_bruise()));
	   	}		
	
	   	if (queryVo.getRest_rest() != null && !"".equals(queryVo.getRest_rest())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.rest_rest like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRest_rest()));
	   	}		
	
	   	if (queryVo.getRest_annual() != null && !"".equals(queryVo.getRest_annual())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.rest_annual like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRest_annual()));
	   	}		
	
	   	if (queryVo.getNotakeclass() != null && !"".equals(queryVo.getNotakeclass())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.notakeclass like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNotakeclass()));
	   	}		
	
	   	if (queryVo.getLate() != null && !"".equals(queryVo.getLate())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.late like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLate()));
	   	}		
	
	   	if (queryVo.getLeave_early() != null && !"".equals(queryVo.getLeave_early())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.leave_early like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLeave_early()));
	   	}		
	
	   	if (queryVo.getNocredit_card() != null && !"".equals(queryVo.getNocredit_card())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.nocredit_card like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNocredit_card()));
	   	}		
	
	   	if (queryVo.getLastMounthRest() != null && !"".equals(queryVo.getLastMounthRest())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.lastMounthRest like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastMounthRest()));
	   	}		
	
	   	if (queryVo.getThisMounthRest() != null && !"".equals(queryVo.getThisMounthRest())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.thisMounthRest like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getThisMounthRest()));
	   	}		
	
	   	if (queryVo.getEntryDate() != null && !"".equals(queryVo.getEntryDate())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.entryDate like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEntryDate()));
	   	}		
	
	   	if (queryVo.getAnnualVacation() != null && !"".equals(queryVo.getAnnualVacation())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.annualVacation like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAnnualVacation()));
	   	}		
	
	   	if (queryVo.getAnnualVacationBalance() != null && !"".equals(queryVo.getAnnualVacationBalance())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.annualVacationBalance like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAnnualVacationBalance()));
	   	}		
	
	   	if (queryVo.getSickLeave() != null && !"".equals(queryVo.getSickLeave())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.sickLeave like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSickLeave()));
	   	}		
	
	   	if (queryVo.getSickLeaveBalance() != null && !"".equals(queryVo.getSickLeaveBalance())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.sickLeaveBalance like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSickLeaveBalance()));
	   	}		
	
	   	if (queryVo.getIs_full_hours() != null && !"".equals(queryVo.getIs_full_hours())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.is_full_hours like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIs_full_hours()));
	   	}		
	
	   	if (queryVo.getAttendancetype() != null && !"".equals(queryVo.getAttendancetype())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.attendancetype like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttendancetype()));
	   	}
	   	if (queryVo.getAttendancemonth() != null && !"".equals(queryVo.getAttendancemonth())) {
	   		jpql.append(" and _monthlyAttendanceConfirmation.attendancemonth like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttendancemonth()));
	   	}
        Page<MonthlyAttendanceConfirmation> pages = getQueryChannelService().createJpqlQuery(jpql.toString()).setParameters(conditionVals).setPage(currentPage, pageSize).pagedList();
        for (MonthlyAttendanceConfirmation monthlyAttendanceConfirmation : pages.getData()) {
            MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmationDTO = new MonthlyAttendanceConfirmationDTO();
            
             // 将domain转成VO
            try {
            	BeanUtils.copyProperties(monthlyAttendanceConfirmationDTO, monthlyAttendanceConfirmation);
            } catch (Exception e) {
            	e.printStackTrace();
            } 
            
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            result.add(monthlyAttendanceConfirmationDTO);
        }
        return new Page<MonthlyAttendanceConfirmationDTO>(pages.getPageIndex(), pages.getResultCount(), pageSize, result);
	}
	
	
}

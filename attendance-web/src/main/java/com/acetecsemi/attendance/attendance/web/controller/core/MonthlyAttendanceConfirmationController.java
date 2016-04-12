
package com.acetecsemi.attendance.attendance.web.controller.core;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.dayatang.querychannel.Page;

import com.acetecsemi.attendance.attendance.application.core.MonthlyAttendanceConfirmationApplication;
import com.acetecsemi.attendance.attendance.application.core.MonthlyAttendanceConfirmationCreateApplication;
import com.acetecsemi.attendance.attendance.application.dto.*;
import com.acetecsemi.attendance.attendance.util.MyDateUtils;

@Controller
@RequestMapping("/MonthlyAttendanceConfirmation")
public class MonthlyAttendanceConfirmationController {
		
	@Inject
	private MonthlyAttendanceConfirmationApplication monthlyAttendanceConfirmationApplication;
	
	@Inject
	private MonthlyAttendanceConfirmationCreateApplication monthlyAttendanceConfirmationCreateApplication;
	
	@ResponseBody
	@RequestMapping("/add")
	public Map<String, Object> add(MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmationDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		monthlyAttendanceConfirmationApplication.saveMonthlyAttendanceConfirmation(monthlyAttendanceConfirmationDTO);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Map<String, Object> update(MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmationDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		monthlyAttendanceConfirmationApplication.updateMonthlyAttendanceConfirmation(monthlyAttendanceConfirmationDTO);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(MonthlyAttendanceConfirmationDTO monthlyAttendanceConfirmationDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<MonthlyAttendanceConfirmationDTO> all = monthlyAttendanceConfirmationApplication.pageQueryMonthlyAttendanceConfirmation(monthlyAttendanceConfirmationDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Map<String, Object> delete(@RequestParam String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		String[] value = ids.split(",");
        Long[] idArrs = new Long[value.length];
        for (int i = 0; i < value.length; i ++) {
        	
        	        					idArrs[i] = Long.parseLong(value[i]);
						        	
        }
        monthlyAttendanceConfirmationApplication.removeMonthlyAttendanceConfirmations(idArrs);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public Map<String, Object> get(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", monthlyAttendanceConfirmationApplication.getMonthlyAttendanceConfirmation(id));
		return result;
	}
	
	@ResponseBody
    @RequestMapping("/attendanceDatebaseCreat")  
    public Map<String, Object> attendanceDatebaseCreat(@RequestParam String value) {
		Map<String, Object> result = new HashMap<String, Object>();
		Calendar a = Calendar.getInstance();
		String flage=monthlyAttendanceConfirmationCreateApplication.createMonthlyAttendanceConfirmation(a.get(Calendar.YEAR), a.get(Calendar.MONTH) + 1);
		if(flage=="successful")
		result.put("result","successed");
		else
		result.put("result","none");
		return result;
		
	}
	
	@ResponseBody
    @RequestMapping("/attendanceDatebaseGet")  
    public Map<String, Object> attendanceDatebaseGet(@RequestParam String date,String type,String Page,String Pagesize) {
		int realpage=Integer.parseInt(Page)-1;
		int realpagesize=Integer.parseInt(Pagesize);
		Map<String, Object> result = new HashMap<String, Object>(); 
		MonthlyAttendanceConfirmationDTO ard = new MonthlyAttendanceConfirmationDTO();
		ard.setAttendancemonth(date);
		ard.setAttendancetype(type);
        System.out.println(realpage);
        Page<MonthlyAttendanceConfirmationDTO> ardpage = monthlyAttendanceConfirmationApplication.pageQueryMonthlyAttendanceConfirmation(ard,realpage,realpagesize);
        Long totalpage=ardpage.getPageCount();
        List <MonthlyAttendanceConfirmationDTO> ardlist = ardpage.getData();
        String data = "{'totalpage':'"+totalpage+"','data':[";
        for(MonthlyAttendanceConfirmationDTO ardDTO : ardlist){
        	data += ardDTO.toJSONString()+",";
        }
        data += "]}";
		result.put("result",data);
		return result;
		
	}
		
}

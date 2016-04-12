
package com.acetecsemi.attendance.attendance.web.controller.core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.dayatang.querychannel.Page;

import com.acetecsemi.attendance.attendance.application.core.AttenceRecordDetailApplication;
import com.acetecsemi.attendance.attendance.application.dto.*;
import com.acetecsemi.attendance.attendance.util.MyDateUtils;

@Controller
@RequestMapping("/AttenceRecordDetail")
public class AttenceRecordDetailController {
		
	@Inject
	private AttenceRecordDetailApplication attenceRecordDetailApplication;
	
	@ResponseBody
	@RequestMapping("/add")
	public Map<String, Object> add(AttenceRecordDetailDTO attenceRecordDetailDTO,@RequestParam String attDate) {
		Map<String, Object> result = new HashMap<String, Object>();
		attenceRecordDetailDTO.setAttenceTime(MyDateUtils.str2Date(attDate.replace("T", " "), "yyyy-MM-dd HH:mm"));
		attenceRecordDetailApplication.saveAttenceRecordDetail(attenceRecordDetailDTO);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Map<String, Object> update(AttenceRecordDetailDTO attenceRecordDetailDTO,@RequestParam String attDate) {
		Map<String, Object> result = new HashMap<String, Object>();
		attenceRecordDetailDTO.setAttenceTime(MyDateUtils.str2Date(attDate.replace("T", " "), "yyyy-MM-dd HH:mm"));
		attenceRecordDetailApplication.updateAttenceRecordDetail(attenceRecordDetailDTO);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(AttenceRecordDetailDTO attenceRecordDetailDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<AttenceRecordDetailDTO> all = attenceRecordDetailApplication.pageQueryAttenceRecordDetail(attenceRecordDetailDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/getAttendanceType")
	public Map<String, String> pageJson() {
		Map<String, String> result = new HashMap<String, String>();
		result=attenceRecordDetailApplication.getAttenceType();
		return result;
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
        attenceRecordDetailApplication.removeAttenceRecordDetails(idArrs);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public Map<String, Object> get(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", attenceRecordDetailApplication.getAttenceRecordDetail(id));
		return result;
	}
	
		
}

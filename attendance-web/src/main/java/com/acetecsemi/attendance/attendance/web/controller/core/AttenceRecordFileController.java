
package com.acetecsemi.attendance.attendance.web.controller.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.dayatang.querychannel.Page;

import com.acetecsemi.attendance.attendance.application.core.AttenceRecordDetailApplication;
import com.acetecsemi.attendance.attendance.application.core.AttenceRecordFileApplication;
import com.acetecsemi.attendance.attendance.application.dto.*;

@Controller
@RequestMapping("/AttenceRecordFile")
public class AttenceRecordFileController {
		
	@Inject
	private AttenceRecordFileApplication attenceRecordFileApplication;
	
	@Inject
	private AttenceRecordDetailApplication attenceRecordDetailApplication;
	
	@ResponseBody
	@RequestMapping("/add")
	public Map<String, Object> add(AttenceRecordFileDTO attenceRecordFileDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		attenceRecordFileApplication.saveAttenceRecordFile(attenceRecordFileDTO);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Map<String, Object> update(AttenceRecordFileDTO attenceRecordFileDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		attenceRecordFileApplication.updateAttenceRecordFile(attenceRecordFileDTO);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(AttenceRecordFileDTO attenceRecordFileDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<AttenceRecordFileDTO> all = attenceRecordFileApplication.pageQueryAttenceRecordFile(attenceRecordFileDTO, page, pagesize);
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
        attenceRecordFileApplication.removeAttenceRecordFiles(idArrs);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public Map<String, Object> get(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", attenceRecordFileApplication.getAttenceRecordFile(id));
		return result;
	}  
	
	
	@ResponseBody
    @RequestMapping("/attendanceDetailAjax")  
    public Map<String, Object> ajax(@RequestParam String ID,String Page ,String Pagesize) {
        int realpage=Integer.parseInt(Page)-1;
        int realpagesize=Integer.parseInt(Pagesize);
        Map<String, Object> result = new HashMap<String, Object>();
        AttenceRecordDetailDTO ard = new AttenceRecordDetailDTO();
        ard.setAttenceRecordFileId(Long.parseLong(ID));
        System.out.println(realpage);
        Page<AttenceRecordDetailDTO> ardpage = attenceRecordDetailApplication.pageQueryAttenceRecordDetail(ard,realpage,realpagesize);
        Long totalpage=ardpage.getPageCount();
        List <AttenceRecordDetailDTO> ardlist = ardpage.getData();
        String data = "{'totalpage':'"+totalpage+"','data':[";
        for(AttenceRecordDetailDTO ardDTO : ardlist){
        	data += ardDTO.toJSONString()+",";
        }
        data += "]}";
        //String str="{'data':[{'employeeNo':'0121','empolyeeName':'jack','attenceTime':'2014-5-13 09:15','attenceType':'正常'},{'employeeNo':'0121','empolyeeName':'jack','attenceTime':'2014-5-13 09:15','attenceType':'正常'},{'employeeNo':'0121','empolyeeName':'jack','attenceTime':'2014-5-13 09:15','attenceType':'正常'},{'employeeNo':'0121','empolyeeName':'jack','attenceTime':'2014-5-13 09:15','attenceType':'正常'}]}";
        result.put("result",data);
		return result;
    } 
 
      
	
}

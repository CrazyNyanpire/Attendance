
package com.acetecsemi.attendance.attendance.web.controller.core;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.dayatang.querychannel.Page;
import com.acetecsemi.attendance.attendance.application.core.AlphaApplication;
import com.acetecsemi.attendance.attendance.application.dto.*;

@Controller
@RequestMapping("/Alpha")
public class AlphaController {
		
	@Inject
	private AlphaApplication alphaApplication;
	
	@ResponseBody
	@RequestMapping("/add")
	public Map<String, Object> add(AlphaDTO alphaDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		alphaApplication.saveAlpha(alphaDTO);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Map<String, Object> update(AlphaDTO alphaDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		alphaApplication.updateAlpha(alphaDTO);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(AlphaDTO alphaDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<AlphaDTO> all = alphaApplication.pageQueryAlpha(alphaDTO, page, pagesize);
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
        alphaApplication.removeAlphas(idArrs);
		result.put("result", "success");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public Map<String, Object> get(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", alphaApplication.getAlpha(id));
		return result;
	}
	
		
}

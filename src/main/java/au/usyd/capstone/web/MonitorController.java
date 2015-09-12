package au.usyd.capstone.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

@Controller
public class MonitorController {

	@RequestMapping(value="/monitor")
	public ModelAndView monitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("monitor");
	}
	
	
	@RequestMapping(value="/monitor", method=RequestMethod.POST,produces = "application/json")
	//@ResponseBody将内容作为response的主体传回
	@ResponseBody
	public String monitortestpost() throws JsonProcessingException {
		
		Map<String, String> map = new HashMap<String, String>();
		
		//随机生成坐标
		double x = Math.random() * 880 + 10;
		double y = Math.random() * 270 + 10;
		String coordinateX = String.valueOf(x);
		String coordinateY = String.valueOf(y);
		
		//向hashmap中放入坐标键值对
		map.put("coordinateX", coordinateX);
		map.put("coordinateY", coordinateY);
		
		//将hashmap转为JSON格式字符串
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(map);
		
		//System.out.println(str);
		
		return str;
		
	}
	
	
//	@RequestMapping(value="/monitor", method=RequestMethod.POST)
//	public Map<String, String> monitortest() {
//		
//		Map<String, String> map = new HashMap<String, String>();
//		double x = Math.random() * 900 + 1;
//		double y = Math.random() * 290 + 1;
//		String coordinateX = String.valueOf(x);
//		String coordinateY = String.valueOf(y);
//		map.put("coordinateX", coordinateX);
//		map.put("coordinateY", coordinateY);
//		return map;
//		
//	}
}

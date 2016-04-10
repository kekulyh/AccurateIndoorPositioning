package au.usyd.capstone.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.usyd.capstone.domain.Device;
import au.usyd.capstone.service.DeviceService;

@Controller
public class MonitorAndroidController {
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value="/monitorandroid")
	public ModelAndView monitorAndroid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("monitorandroid");
	}
	
	@RequestMapping(value="/monitorandroid", method=RequestMethod.POST, produces = "application/json")
	//@ResponseBody将内容作为response的主体传回
	@ResponseBody
	public String monitorAndroidAjax() throws JsonProcessingException {
		
		Device device = new Device();
		
		device.setDevicename("device1");
		
		this.deviceService.calculateCoordinate(device);
		
		Device deviceTest = this.deviceService.display(device);
		
		Map<String, String> map = new HashMap<String, String>();
		
		String coordinateX = String.valueOf( deviceTest.getCoordinateX() );
		String coordinateY = String.valueOf( deviceTest.getCoordinateY() );
		
		//向HashMap中放入坐标键值对
		map.put("coordinateX", coordinateX);
		map.put("coordinateY", coordinateY);
		
		//将HashMap转为JSON格式字符串
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(map);
		//System.out.println(str);
		
		return str;
		
	}
	
}

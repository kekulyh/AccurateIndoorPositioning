package au.usyd.capstone.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import au.usyd.capstone.domain.Device;
import au.usyd.capstone.service.DeviceService;

@Controller
public class MonitorForZhaidiController {

	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value="/monitorforzhaidi")
	public ModelAndView monitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("monitorforzhaidi");
	}
	
	@RequestMapping(value="/monitorforzhaidi", method=RequestMethod.POST, produces = "application/json")
	//@ResponseBody将内容作为response的主体传回
	@ResponseBody
	public String monitortestpost() throws JsonProcessingException {
		
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
	
	@RequestMapping(value="/resetcoordinate", method=RequestMethod.POST, produces = "application/json")
	//@ResponseBody将内容作为response的主体传回
	@ResponseBody
	public String resetCoordinate() throws JsonProcessingException {
		
		Device device = new Device();
		
		device.setDevicename("device1");
		
		this.deviceService.resetCoordinate(device);
		
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

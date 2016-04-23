package au.usyd.capstone.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.usyd.capstone.domain.Device;
import au.usyd.capstone.service.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GestureController {

	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value="/gesture")
	public ModelAndView gesture(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("gesture");
	}
	
	@RequestMapping(value="/gesture", method=RequestMethod.POST, produces = "application/json")
	//@ResponseBody将内容作为response的主体传回
	@ResponseBody
	public String gesturePost() throws JsonProcessingException {
		
		Device device = new Device();
		
		device.setDevicename("device1");
		
		this.deviceService.calculateGesture(device);
		
		Device deviceTest = this.deviceService.display(device);
		
		Map<String, String> map = new HashMap<String, String>();
		
//		String coordinateX = String.valueOf( deviceTest.getCoordinateX() );
//		String coordinateY = String.valueOf( deviceTest.getCoordinateY() );
		
		String yaw = String.valueOf( deviceTest.getYaw() );
		String pitch = String.valueOf( deviceTest.getPitch() );
		String roll = String.valueOf( deviceTest.getRoll() );
		
		//向HashMap中放入键值对
		map.put("yaw", yaw);
		map.put("pitch", pitch);
		map.put("roll", roll);
		
		//将HashMap转为JSON格式字符串
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(map);
		//System.out.println(str);
		
		return str;
		
	}
}

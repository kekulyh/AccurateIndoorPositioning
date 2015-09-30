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
public class DeviceAddController {
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value="/deviceadd")
	public ModelAndView deviceadd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("deviceadd");
	}
	
	@RequestMapping(value="/deviceadd", method=RequestMethod.POST)
	public ModelAndView deviceaddaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Device device = new Device();
		
		//判断devicename是否为空，为空则返回devicenameNull
		if ((request.getParameter("deviceadd-devicename")) == "") {
			
			ModelAndView mav = new ModelAndView("deviceadd");
			String alertDeviceadd = "devicenameNull";
			mav.addObject("alertDeviceadd", alertDeviceadd);
			return mav;
			
		}else{
			//判断macaddress是否为空， 为空则返回macaddressNull
			if ((request.getParameter("deviceadd-macaddress")) == "") {
				ModelAndView mav = new ModelAndView("deviceadd");
				String alertDeviceadd = "macaddressNull";
				mav.addObject("alertDeviceadd", alertDeviceadd);
				return mav;
			}else{
				//输入正确，进行处理
				device.setDevicename(request.getParameter("deviceadd-devicename"));
				device.setDevicemacaddress(request.getParameter("deviceadd-macaddress"));
				device.setDevicemodel(request.getParameter("deviceadd-devicemodel"));
				device.setDescription(request.getParameter("deviceadd-description"));
				
				Device device1 = this.deviceService.deviceAdd(device);
				
				ModelAndView mav = new ModelAndView("devicestatus");
				String alertDeviceadd = "addSuccess";
				mav.addObject("alertDeviceadd", alertDeviceadd);
				return mav;
			}
		
		}
		
		
		
		
		
	}
	
	

}

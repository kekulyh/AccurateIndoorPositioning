package au.usyd.capstone.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.capstone.service.DeviceService;

@Controller
public class DeviceStatusController {
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value="/devicestatus")
	public ModelAndView devicestatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("devicestatus");
	}
	
	
}

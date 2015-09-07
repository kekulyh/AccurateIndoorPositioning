package au.usyd.capstone.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;

@Controller
public class MonitorController {

	@RequestMapping(value="/monitor")
	public ModelAndView monitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("monitor");
	}
	
}

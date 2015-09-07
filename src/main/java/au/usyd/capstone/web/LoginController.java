package au.usyd.capstone.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.capstone.domain.Admin;
import au.usyd.capstone.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Admin admin = new Admin();
		
		admin.setUsername(request.getParameter("login-username"));
		admin.setPassword(request.getParameter("login-password"));
		
		Admin admin1 = this.adminService.login(admin);
		
		if (admin1 != null) {
			
			//System.out.println("admin1.getUsername:" + admin1.getUsername());
			
			if (admin1.getUsername().toString().equals("usernamenotexist")) {
				
				//用户名不存在，返回usernameNotExist
				ModelAndView mav = new ModelAndView("login");
				String alertLogin = "usernameNotExist";
				mav.addObject("alertLogin", alertLogin);
				return mav;
				
			}else{
				
				//登陆成功，返回loginsuccess
				ModelAndView mav = new ModelAndView("loginsuccess");
				String adminUsername = admin1.getUsername();
				mav.addObject("adminUsername", adminUsername);
				return mav;
			}
			
		}else{
			
			//密码错误登录失败，返回loginFail
			ModelAndView mav = new ModelAndView("login");
			String alertLogin = "loginFail";
			mav.addObject("alertLogin", alertLogin);
			return mav;
			
		}
		
	}
	
	
	
	
	
	
}

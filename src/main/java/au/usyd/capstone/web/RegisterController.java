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
public class RegisterController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/register")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("register");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Admin admin = new Admin();
		
		//判断两个密码是否一致
		if (request.getParameter("register-password").toString().equals(request.getParameter("register-password2").toString())) {
			
			//判断密码是否为空， 为空则返回passwordNull
			if ((request.getParameter("register-password")) == "") {
				
				ModelAndView mav = new ModelAndView("register");
				String alertRegister = "passwordNull";
				mav.addObject("alertRegister", alertRegister);
				return mav;
				
			}else{
				
				//输入正确，进行处理
				admin.setUsername(request.getParameter("register-username"));
				admin.setPassword(request.getParameter("register-password"));
				
				Admin admin1 = this.adminService.register(admin);
				
				if (admin1 != null) {
					//用户名不存在，注册成功，返回registerSuccess
					ModelAndView mav = new ModelAndView("login");
					String alertRegister = "registerSuccess";
					mav.addObject("alertRegister", alertRegister);
					return mav;
					
				}else{
					//用户名已存在，返回usernameExist
					ModelAndView mav = new ModelAndView("register");
					String alertRegister = "usernameExist";
					mav.addObject("alertRegister", alertRegister);
					return mav;
					
				}
	
			}
			
		}else{
			
			//密码不一致，返回passwordNotSame
			ModelAndView mav = new ModelAndView("register");
			String alertRegister = "passwordNotSame";
			mav.addObject("alertRegister", alertRegister);
			return mav;
			
		}
		
	}
	
	
	
	
	
	
	
}

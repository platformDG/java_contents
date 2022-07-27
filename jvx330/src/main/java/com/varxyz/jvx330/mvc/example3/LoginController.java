package com.varxyz.jvx330.mvc.example3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("example3.loginController")
public class LoginController {
	@GetMapping("/example3/login")
	public String loginForm() {
		return "example3/login";
	}
	
//	@PostMapping("/example3/login")
	public ModelAndView login(HttpServletRequest requset) {
		String userId = requset.getParameter("userId");
		String passwd = requset.getParameter("passwd");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result");
		return mav;
	}
	
	@PostMapping("/example3/login")
	public ModelAndView login(@RequestParam(value="userId", required = true) String id, 
			@RequestParam String passwd) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result");
		return mav;
	}
}

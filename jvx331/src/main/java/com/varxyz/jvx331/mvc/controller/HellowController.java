package com.varxyz.jvx331.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HellowController {
	@RequestMapping("/example1/sayHello")
	public ModelAndView sayHello() {
		String greating = "Hello 스프링 MVC";
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example1/hello");
		mav.addObject("greating", greating);
		return mav;
	}
}

package com.sankar.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GreetingController {

	@RequestMapping(value="/test" , method=RequestMethod.GET)
	public ModelAndView abc() {
		return new ModelAndView("success","greetingMsg","Testing");
	}
	
	@RequestMapping(value="/greetings" , method=RequestMethod.POST)
	public ModelAndView greet(HttpServletRequest req, HttpServletResponse res) {
		String outputView="error";
		String greetingMessage = null;
		
		String name = req.getParameter("name");
		if(name == null || name.trim().length() == 0) {
			outputView = "error";
			greetingMessage = "Welcome Guest";
		}else {
			greetingMessage = "Welcome " + name;
			outputView = "success";
		}
				
		return new ModelAndView(outputView,"greetingMsg",greetingMessage);
	}

}

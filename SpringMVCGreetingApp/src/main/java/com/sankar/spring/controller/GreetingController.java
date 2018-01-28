package com.sankar.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.sankar.spring.model.GreetingModel;

public class GreetingController extends AbstractController{

	private GreetingModel model;
	private String successView;
	private String errorView;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String outputpage=errorView;
		String greetingMessage = null;
		
		String name = req.getParameter("name");
		if(name == null || name.trim().length() == 0) {
			greetingMessage = model.sayGreetings("Guest");
			outputpage = errorView;
		}else {
			greetingMessage = model.sayGreetings(name);
			outputpage = successView;
		}
				
		return new ModelAndView(outputpage,"greetingMsg",greetingMessage);
	}
	public void setSuccessView(String successView) {
		this.successView = successView;
	}
	public void setErrorView(String errorView) {
		this.errorView = errorView;
	}
	public void setModel(GreetingModel model) {
		this.model = model;
	}
	

}

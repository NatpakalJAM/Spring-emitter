package com.arms.app.staticpages;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaticPagesController {
	/*@RequestMapping("/help")
	public String help() {
		return "static/help";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "static/contact";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "static/about";
	}*/
	
	@RequestMapping("/help")
	public ModelAndView help(ModelAndView modelAndView, Principal principal) {
		modelAndView.setViewName("static/help");
		return modelAndView;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact(ModelAndView modelAndView, Principal principal) {
		modelAndView.setViewName("static/contact");
		return modelAndView;
	}
	
	@RequestMapping("/about")
	public ModelAndView about(ModelAndView modelAndView, Principal principal) {
		modelAndView.setViewName("static/about");
		return modelAndView;
	}
}
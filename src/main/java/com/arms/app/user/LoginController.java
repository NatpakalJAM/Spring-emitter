package com.arms.app.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arms.domain.service.AuthenticationService;

@Controller
public class LoginController {
	@Autowired
	AuthenticationService authenticationService;
	
	@RequestMapping("/user/login")
	public ModelAndView login(ModelAndView modelAndView) {
		modelAndView.setViewName("user/login");
		return modelAndView;
	}

	@RequestMapping(value = "/user/failLogin", method = RequestMethod.GET)
	public ModelAndView failLogin(ModelAndView model) {
		model.addObject("errorMsg", "Login failed, Invalid name and/or passwod");
		model.addObject("loginFail", true);
		model.setViewName("user/login");
		return model;
	}

	@RequestMapping(value = "/user/successLogin", method = RequestMethod.GET)
	public Object successLogin(ModelAndView model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			model.setViewName("/user/login");
			return model;
		}
		redirectAttributes.addFlashAttribute("message", "Login Successful");
		model.addObject("loginSuccess", true);
		return "redirect:/";
	}

	/*@RequestMapping("/loginUser")
	@ResponseBody
	public String currentUser(Principal principal) {
		if (principal != null) {
			return principal.getName();
		} else {
			return "pricipal is null!!";
		}
	}*/

	/*@RequestMapping("/loginUser")
	@ResponseBody
	public Object currentUser(Authentication authentication) {
		if (authentication != null) {
			return authentication.getName();
		} else {
			return "Authentication is null!!";
		}
	}*/

	@RequestMapping(value = "/loginUser")
	@ResponseBody
	public UserDetails currentUser(Principal principal) {
		Authentication auth = (Authentication) principal;
		UserDetails ud = (UserDetails) auth.getPrincipal();
		return authenticationService.loadUserByUsername(ud.getUsername());
	}
}
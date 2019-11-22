package com.mozzishop.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mozzishop.www.resolver.SocialUser;
import com.mozzishop.www.user.jpa.User;

@Controller
public class MainController {
	
	@GetMapping("/")
	public ModelAndView mainpage(){
		ModelAndView mv = new ModelAndView("main");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@GetMapping("/loginSuccess")
	public String loginComplete(@SocialUser User user) {
		return "redirect:/";
	}

}
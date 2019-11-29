package com.mozzishop.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mozzishop.www.resolver.SocialUser;
import com.mozzishop.www.user.jpa.Grade;
import com.mozzishop.www.user.jpa.User;
import com.mozzishop.www.user.jpa.UserRepository;
import com.mozzishop.www.user.service.UserService;

@Controller
public class MainController {

	@Autowired 
	UserService userService;
	
	@GetMapping("/")
	public ModelAndView mainpage(){
		
		ModelAndView mv = new ModelAndView("main");
		//User user = userRepository.findByGrade(Grade.ADMIN);
	//	mv.addObject("list", String.valueOf(user));
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@GetMapping("/loginSuccess")
	public ModelAndView loginComplete(@SocialUser User user) {
		System.out.println(user.toString());
		ModelAndView mv = new ModelAndView("loginSuccess");
		mv.addObject("username", user.getName());
		return mv;
	}
	
	@GetMapping("/loginFailure")
	public ModelAndView loginFailure() {
		ModelAndView mv = new ModelAndView("loginFailure");
		
		return mv;
	}

}

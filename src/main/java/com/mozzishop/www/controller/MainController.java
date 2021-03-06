package com.mozzishop.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mozzishop.www.resolver.SocialUser;
import com.mozzishop.www.user.jpa.User;
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
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@PostMapping("/signed")
	public String signed(@SocialUser User user) {
		if(user==null) {
			System.out.println("null 입니다.");
		}
		
		return "redirect:/";
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
	
	@GetMapping("/AccessDenied")
	public ModelAndView AccessDeniedView() {
		ModelAndView mv = new ModelAndView("noAuth");
		
		return mv;
	}

	/*
	@GetMapping("/error")
	public ModelAndView errorView() {
		ModelAndView mv = new ModelAndView("error");
		return mv;
	}
	*/

}

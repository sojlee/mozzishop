package com.mozzishop.www.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mozzishop.www.resolver.SocialUser;
import com.mozzishop.www.user.jpa.User;

@RestController
public class MainController {
	
	@GetMapping("/")
	public String mainpage(){
		return "main";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/loginSuccess")
	public String loginComplete(@SocialUser User user) {
		return "redirect:/board/list";
	}

}

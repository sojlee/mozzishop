package com.mozzishop.www.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mozzishop.www.user.jpa.User;
import com.mozzishop.www.user.jpa.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserRepository userRepository;
	
	public ModelAndView adminMain() {
		ModelAndView mv = new ModelAndView("Admin");
		List<User> Alluser = userRepository.findAll();
		mv.addObject("list", Alluser.toString());
		return mv;
	}
	
	@GetMapping("/")
	public ModelAndView aaaa() {
		ModelAndView mv = new ModelAndView("Admin");
		List<User> Alluser = userRepository.findAll();
		mv.addObject("list", Alluser.toString());
		return mv;
	}
	
	@GetMapping("/log")
	public ModelAndView awef() {
		ModelAndView mv = new ModelAndView("Admin");
		List<User> Alluser = userRepository.findAll();
		mv.addObject("list", Alluser.toString());
		return mv;
	}

}

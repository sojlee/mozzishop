package com.mozzishop.www.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/")
	public ModelAndView usermain() throws Exception{
		ModelAndView mv = new ModelAndView("");
		return mv;
	}
	// 마이페이지
	@GetMapping("/mypage")
	public ModelAndView mypage() throws Exception{
		ModelAndView mv = new ModelAndView("");
		return mv;
	}
	
	@GetMapping("/cart")
	public ModelAndView cart() throws Exception{
		ModelAndView mv = new ModelAndView("");
		return mv;
	}
	
	@GetMapping("/orderlist")
	public ModelAndView orderlist() throws Exception{
		ModelAndView mv = new ModelAndView("");
		return mv;
	}
	
	@GetMapping("/refund")
	public ModelAndView refund() throws Exception{
		ModelAndView mv = new ModelAndView("");
		return mv;
	}
	
	@GetMapping("/myask")
	public ModelAndView myask() throws Exception{
		ModelAndView mv = new ModelAndView("");
		return mv;
	}

}

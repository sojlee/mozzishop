package com.mozzishop.www.user.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mozzishop.www.resolver.SocialUser;
import com.mozzishop.www.user.jpa.User;
import com.mozzishop.www.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 유저 메인
	@GetMapping("/")
	public ModelAndView usermain() throws Exception{
		ModelAndView mv = new ModelAndView("User");
		return mv;
	}
	// 마이페이지
	@GetMapping("/myinfo")
	public ModelAndView mypage(@SocialUser User user) throws Exception{
		ModelAndView mv = new ModelAndView("user/myinfo");
		User my = userService.findByEmail(user.getEmail());
		mv.addObject("list", my.toString());
		return mv;
	}
	// 장바구니
	@GetMapping("/cart")
	public ModelAndView cart() throws Exception{
		ModelAndView mv = new ModelAndView("User");
		return mv;
	}
	// 주문 목록
	@GetMapping("/orderlist")
	public ModelAndView orderlist() throws Exception{
		ModelAndView mv = new ModelAndView("User");
		return mv;
	}
	// 환불 
	@GetMapping("/refund")
	public ModelAndView refund() throws Exception{
		ModelAndView mv = new ModelAndView("User");
		return mv;
	}
	// 문의
	@GetMapping("/myask")
	public ModelAndView myask() throws Exception{
		ModelAndView mv = new ModelAndView("User");
		return mv;
	}

}

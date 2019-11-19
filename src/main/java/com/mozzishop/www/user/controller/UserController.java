package com.mozzishop.www.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
	
	// 유저 메인
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
	// 장바구니
	@GetMapping("/cart")
	public ModelAndView cart() throws Exception{
		ModelAndView mv = new ModelAndView("");
		return mv;
	}
	// 주문 목록
	@GetMapping("/orderlist")
	public ModelAndView orderlist() throws Exception{
		ModelAndView mv = new ModelAndView("");
		return mv;
	}
	// 환불 
	@GetMapping("/refund")
	public ModelAndView refund() throws Exception{
		ModelAndView mv = new ModelAndView("");
		return mv;
	}
	// 문의
	@GetMapping("/myask")
	public ModelAndView myask() throws Exception{
		ModelAndView mv = new ModelAndView("");
		return mv;
	}

}

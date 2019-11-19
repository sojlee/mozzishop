package com.mozzishop.www.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@GetMapping("/stickers")
	public ModelAndView stickers(@RequestParam String author) throws Exception {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}

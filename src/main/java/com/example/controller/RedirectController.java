package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	//redirect
	@RequestMapping("/testredirect")
	public String testRedirect(Model model ,RedirectAttributes redirectAttrs) {
		redirectAttrs.addAttribute("name", "浏览量");
		//redirectAttrs.addFlashAttribute("name", "12345");
		
		return "redirect:testRed";
	}
	
	@RequestMapping("/testRed")
	public String testRed(Model model,String name) {
		System.out.println("name="+name);
		model.addAttribute("name", name);
		
		return "value";
		
	}
	//forword
	@RequestMapping("/testforword")
	public String testForword(Model model) {
		
		model.addAttribute("name", "yuyuyuy");
		
		return "forword:testFor";
	}
	
	@RequestMapping("/testFor")
	public String testFor(Model model,HttpServletRequest request) {
		String name= (String)request.getAttribute("name");
		System.out.println(name);
		
		return "value";
		
	}
}

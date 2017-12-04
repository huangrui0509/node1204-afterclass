package com.example.controller;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.User;

@Controller
public class IndexController {

	//使用Model 将参数传到页面
	@RequestMapping("/index")
	public String getIndex(Model model) {
		model.addAttribute("name", "小明");
		
		return "index";
		
	}
	//原生request实现参数从后台传到前台页面
	@RequestMapping("/testrequset")
	public String getValueByReq(HttpServletRequest request) {
		request.setAttribute("department", "后勤部");
		
		return "value";
		
	}
	
	@RequestMapping(value = "/value")
	public void getValue(String name,int age) {
		System.out.println("name="+name+"  age="+age);
	}
	
	//使用@RequestParam
	@RequestMapping(value = "/value2")
	public void getValue2(@RequestParam(name = "name", required = true, defaultValue = "默认名字")String name,int age) {
		System.out.println("name="+name+"  age="+age);
	}
	//原生HttpServletRequest获取页面的传值
	@RequestMapping(value = "/value3")
	public void getValue3(HttpServletRequest request) {
		String name =request.getParameter("name");
		String age =request.getParameter("age");
		
		System.out.println("name="+name+"  age="+age);
	}
	//测试post和get
	@RequestMapping("/testpost")
	public String testPost(String name,int age) {
		System.out.println("name="+name+"  age="+age);
		return "value";
	}
	//获取map对象
	@RequestMapping(value="/testmap",method=RequestMethod.POST)
	public String testMap(@RequestParam Map<String,String> map) {
		Set<Entry<String, String>> entrySet = map.entrySet();
		
		Iterator<Entry<String,String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		return "value";
		
	}
	//传递实体类信息
	@RequestMapping(value="/testuser",method=RequestMethod.POST)
	public String testEntity(@ModelAttribute("user") User user) {
		System.out.println(user);
		return "value";
		
	}
	//获取header
	@RequestMapping(value="/testheader",method=RequestMethod.POST)
	public String testHeader(@RequestParam(name="id",required=true,defaultValue="666") String id,
			@RequestHeader(name="User-Agent") String userAgent) {
		System.out.println("id="+id);
		System.out.println("userAgent="+userAgent);
		
		return "value";
		
		
	}
	
	//使用@PathVariable("")
	//localhost:8080/testpath/11/roles/22
	//直接从路径里面获取值
	@RequestMapping(value="/testpath/{userId}/roles/{roleId}",method=RequestMethod.POST)
	public String testPath(@PathVariable("userId") String userId,@PathVariable("roleId") String roleId ) {
		System.out.println("userId="+userId);
		System.out.println("roleId="+roleId);
		return "value";
	}
	
	
	
}

package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.User;

@Controller
@ResponseBody
public class JsonController {

	@RequestMapping(value="/testjson")
	public User testJson(User user) {
		user.setAge("222");
		user.setName("jjj");
		user.setHeight("122");
		
		return user;
		
		//{"name":"jjj","age":"222","height":"122"}	
	}
	
	//map
	@RequestMapping(value="/testjson2")
	public Map<String,String> testJsonByMap(){
		Map<String,String> map = new HashMap();
		map.put("name", "sss");
		map.put("age", "123");
		
		return map;
		//{"name":"sss","age":"123"}
	}
	
	
	
	
	
	
}

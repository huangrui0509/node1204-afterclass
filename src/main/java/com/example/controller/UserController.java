package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Person;
import com.example.model.User;


@Controller
public class UserController {
	
	//跳转到value2.html页面
	@RequestMapping("/tovalue2")
	public String toValue2() {
		return "value2";
		
	}
	
	//获取前台form表单中的数据，以json格式输出到页面
	@RequestMapping("/getvaluebyform")
	@ResponseBody
	public User getValueByForm(User user) {
		System.out.println(user);
		return user;
		
	}
	
	//作业2
	//跳转到value2.html页面
		@RequestMapping("/tovalue3")
		public String toValue3() {
			return "value3";
			
		}
	
	
	@RequestMapping("/gettable")
	@ResponseBody
	public Map<String,Person> getTable() {
		Map<String,Person> personMap = new HashMap();
		
		for(int i=1;i<10;i++) {
			Person p = new Person();
			p.setId(i+"");
			p.setName("person"+i);
			p.setAge("2"+i);
			p.setHeight("17"+i);
			personMap.put("person"+i, p);
		}
		
		
		
		return personMap;
		
	}

}

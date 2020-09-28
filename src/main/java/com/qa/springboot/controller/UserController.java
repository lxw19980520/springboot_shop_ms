package com.qa.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.pojo.User;
import com.qa.springboot.service.UserService;

@RestController
@RequestMapping("/userController")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public Object login(@RequestParam("username") String username,@RequestParam("password")  String password,
			HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		List<User> list = userService.login(username, password);
		if(list != null && list.size() > 0){
			map.put("code", 200);
			session.setAttribute("user", list.get(0));
			return map;
		}
		return map;
	}
	
	
	@RequestMapping("/getUser")
	public Object login(HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		Object obj = session.getAttribute("user");
		if(obj != null){
			map.put("code", 200);
			map.put("user", obj);
			return map;
		}
		return map;
	}
	
}

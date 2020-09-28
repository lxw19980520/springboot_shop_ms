package com.qa.springboot.service;

import java.util.List;

import com.qa.springboot.pojo.User;

public interface UserService {
	List<User> login(String username,String password);
}

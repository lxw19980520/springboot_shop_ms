package com.qa.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qa.springboot.mapper.UserMapper;
import com.qa.springboot.pojo.User;
import com.qa.springboot.pojo.UserExample;
import com.qa.springboot.pojo.UserExample.Criteria;
import com.qa.springboot.service.UserService;
@Transactional
@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> login(String username, String password) {
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

}

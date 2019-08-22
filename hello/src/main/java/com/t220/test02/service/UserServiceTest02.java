package com.t220.test02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.t220.test02.dao.UserMapperTest02;

import lombok.Data;
@Data
@Service
public class UserServiceTest02 {
	@Autowired
	private UserMapperTest02 userMapper;
	@Transactional
	public void insertTest02(String userCode,String password,String name){
		userMapper.insert(userCode, password, name);
	}
}

package com.t220.test01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.t220.test01.dao.UserMapperTest01;
import com.t220.test02.dao.UserMapperTest02;

import lombok.Data;
@Data
@Service
public class UserServiceTest01 {
	@Autowired
	private UserMapperTest01 userMapper;
	//private UserServiceTest02 userService2;
	@Autowired
	private UserMapperTest02 userMapper02;
	@Transactional
	public String insertTest01(String userCode,String password,String name){
		//存在事務不會添加
		userMapper.insert(userCode, password,name);
		//事務的傳播性不會添加
		//userService2.insertTest02(userCode, password, name);
		//會添加
		userMapper02.insert(userCode, password, name);
		int i=1/0;
		return "success";
	}
}

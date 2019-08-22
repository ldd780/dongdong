package com.t220.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List userList(){
		return jdbcTemplate.queryForList("select * from itrip_hotel_order");
	}
}

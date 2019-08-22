package com.t220.controler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.t220.service.UserService;
import com.t220.test01.service.UserServiceTest01;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserServiceTest01 userServiceTest01;
	
	@RequestMapping("/list")
	public String queryUserList(Map result) {
			List userlist=userService.userList();
			for (int i = 0; i < userlist.size(); i++) {
				Map<String,Object> map=(Map)userlist.get(i);
				for (String key : map.keySet()) {
					System.out.println(key+"values:"+map.get(key));
				}
				System.out.println();
			}
			log.info("就带你订单的数量--:"+userlist.size());
			result.put("userList", userlist);
			result.put("name", "东东");
			result.put("count", userlist.size());
			return "demo";
	}
	@RequestMapping("/insert")
	public String insertUser(String userCode,String password,String name) {
		userServiceTest01.insertTest01(userCode, password,name);
			return "demo";
	}
}

package com.t220.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class freemarkerController {
	
	@RequestMapping("/free")
	public String demoFreeMarker(Map result) {
		List<String> userList = new ArrayList<String>();
		userList.add("张三");
		userList.add("李四");
		userList.add("王五");
		result.put("name", "龙");
		result.put("userList", userList);
		return "demo";
	}
}

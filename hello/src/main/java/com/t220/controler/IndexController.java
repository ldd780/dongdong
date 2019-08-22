package com.t220.controler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@Value(value="${name}")//将读取全局属性配置文件key的值
	private String name;
	
	@RequestMapping("/index")
	public String index(){
		return "success";
	}
	
	@RequestMapping(path={"/out"})
	public Map getMsg(){
		Map map=new HashMap();
		//int i=5/0;
		map.put("msg", "错误！");
		return map;
	}
	@RequestMapping(path={"/getName"})
	public String getName(){
		return name;
	}
}

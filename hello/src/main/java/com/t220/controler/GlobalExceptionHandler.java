package com.t220.controler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//全局捕获异常类
@ControllerAdvice
public class GlobalExceptionHandler {
	//指定捕捉的异常类型
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody//返回json格式
	public Map HandlerException(){
		Map resultMap=new HashMap();
		resultMap.put("500", "内部出错");
		return resultMap;
	}
}

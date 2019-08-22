package com.t220.aop;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect // 注解定义切面
@Component // 定义为Spring的bean
public class AopLogger {
	private static final Logger log = LoggerFactory.getLogger(AopLogger.class);

	/*
	 * @Pointcut("execution(* simple.*.*(..))") public void pointcut(){}
	 */
	/**
	 * 前置增强
	 * 
	 * @param jp
	 */
	@Before("execution(* com.t220.controler.*.*(..))") // 注解定义前置增强执行在符合模糊查询条件的方法中
	public void before(JoinPoint jp) {
		// 接收到请求内容 记录请求,RequestContextHolder和ServletRequestAttributes位于Spring框架的web组件中的context
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=attributes.getRequest();
		//记录请求信息如路径,方法,请求的数据名和值,IP
		log.info("请求URL", request.getRequestURI().toString());
		log.info("请求的一些方法", request.getMethod());
		//远程地址
		log.info("IP", request.getRemoteAddr());
		//用户 
		log.info("用户", request.getRemoteUser());
		Enumeration<String> enumeration=request.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			log.info("请求数据", name+":"+request.getParameter(name));
		}
		log.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法。方法参数" + Arrays.toString(jp.getArgs()));
	}

	/**
	 * 后置增强
	 * 
	 * @param jp
	 * @param result
	 */
	@AfterReturning(pointcut = "execution(* com.t220.controler.*.*(..))", returning = "result") // 注解定义后置增强执行在符合模糊查询条件的方法中
	public void afterReturning(JoinPoint jp, Object result) {
		//处理完后返回信息 result
		log.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法。方法返回值：" + result);
	}

	/**
	 * AfterThrowing异常抛出增强
	 * 发生异常才进入
	 * @param jp
	 * @param e
	 */
	@AfterThrowing(pointcut = "execution(* com.t220.controler.*.*(..))", throwing = "e")
	public void Throwing(JoinPoint jp, RuntimeException e) {
		log.error(jp.getSignature().getName() + "方法发生异常：" + e);
	}
}

package com.xuyu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//切面类
@Aspect
//注入容器
@Component
public class AopLog {

	
	//aop通知 前置，后置，运行，异常，环绕通知
	@Before("execution(* com.xuyu.service.UserService.add(..))")
	public void before() {
		System.out.println("前置通知");
	}
	@After("execution(* com.xuyu.service.UserService.add(..))")
	public void after() {
		System.out.println("后置通知");
	}
	@AfterReturning("execution(* com.xuyu.service.UserService.add(..))")
	public void afterReturning() {
		System.out.println("运行通知");
	}
	@AfterThrowing("execution(* com.xuyu.service.UserService.add(..))")
	public void afterThrowing() {
		System.out.println("异常通知");
	}
	@Around("execution(* com.xuyu.service.UserService.add(..))")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕通知,调用方法之前执行");
		proceedingJoinPoint.proceed();//代理调用方法抛出异常，不会执行后面代码
		System.out.println("环绕通知,调用方法之后执行");
	}
	
}

package com.xuyu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//������
@Aspect
//ע������
@Component
public class AopLog {

	
	//aop֪ͨ ǰ�ã����ã����У��쳣������֪ͨ
	@Before("execution(* com.xuyu.service.UserService.add(..))")
	public void before() {
		System.out.println("ǰ��֪ͨ");
	}
	@After("execution(* com.xuyu.service.UserService.add(..))")
	public void after() {
		System.out.println("����֪ͨ");
	}
	@AfterReturning("execution(* com.xuyu.service.UserService.add(..))")
	public void afterReturning() {
		System.out.println("����֪ͨ");
	}
	@AfterThrowing("execution(* com.xuyu.service.UserService.add(..))")
	public void afterThrowing() {
		System.out.println("�쳣֪ͨ");
	}
	@Around("execution(* com.xuyu.service.UserService.add(..))")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("����֪ͨ,���÷���֮ǰִ��");
		proceedingJoinPoint.proceed();//������÷����׳��쳣������ִ�к������
		System.out.println("����֪ͨ,���÷���֮��ִ��");
	}
	
}

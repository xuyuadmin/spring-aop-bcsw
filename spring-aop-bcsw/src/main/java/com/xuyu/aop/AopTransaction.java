package com.xuyu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.xuyu.transaction.TransactionUtils;

@Aspect
@Component
// aop基于手动事务封装
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AopTransaction {

	
	@Autowired
	private TransactionUtils transactionUtils;

	@AfterThrowing("execution(* com.xuyu.service.UserService.add(..))")
	public void afterThrowing() {
		System.out.println("异常通知 回滚事务");
		//获取当前事务 直接回滚
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}
	@Around("execution(* com.xuyu.service.UserService.add(..))")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕通知,调用方法之前执行 开启事务");
		TransactionStatus status = transactionUtils.begin();
		proceedingJoinPoint.proceed();// 代理调用方法抛出异常，不会执行后面代码
		System.out.println("环绕通知,调用方法之后执行 提交事务");
		transactionUtils.commit(status);
	}
}

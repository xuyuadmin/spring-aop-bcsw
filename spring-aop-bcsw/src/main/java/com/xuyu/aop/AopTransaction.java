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
// aop�����ֶ������װ
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AopTransaction {

	
	@Autowired
	private TransactionUtils transactionUtils;

	@AfterThrowing("execution(* com.xuyu.service.UserService.add(..))")
	public void afterThrowing() {
		System.out.println("�쳣֪ͨ �ع�����");
		//��ȡ��ǰ���� ֱ�ӻع�
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}
	@Around("execution(* com.xuyu.service.UserService.add(..))")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("����֪ͨ,���÷���֮ǰִ�� ��������");
		TransactionStatus status = transactionUtils.begin();
		proceedingJoinPoint.proceed();// ������÷����׳��쳣������ִ�к������
		System.out.println("����֪ͨ,���÷���֮��ִ�� �ύ����");
		transactionUtils.commit(status);
	}
}

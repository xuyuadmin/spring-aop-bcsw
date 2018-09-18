package com.xuyu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xuyu.service.UserService;

public class Test001 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
		UserService bean = (UserService) classPathXmlApplicationContext.getBean("userServiceImpl");
		bean.add();
		
	}
}

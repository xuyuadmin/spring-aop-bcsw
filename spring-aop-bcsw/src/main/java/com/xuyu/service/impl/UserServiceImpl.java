package com.xuyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuyu.dao.UserDao;
import com.xuyu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	// spring 事务 aop 最好将异常抛出
	public void add() {

		userDao.add("test001", 21);
		System.out.println("#########");
		//int i = 1 / 0;
		userDao.add("test002", 22);
		System.out.println("往数据库插入数据");

	}

}

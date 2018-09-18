package com.xuyu.service.impl;

import org.springframework.stereotype.Service;

import com.xuyu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public void add() {
		try {
			int i=1/0;
		} catch (Exception e) {
		}
		System.out.println("往数据库插入数据");
	}

}

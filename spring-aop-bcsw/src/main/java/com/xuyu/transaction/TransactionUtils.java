package com.xuyu.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

//编程事务 手动
@Component
public class TransactionUtils {

	//获取自己的事务源
	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;
	
	//开启事务
	public TransactionStatus begin() {
		TransactionStatus transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
		//返回事务状态
		return transaction;
	}
	//提交事务
	public void commit(TransactionStatus status) {
		dataSourceTransactionManager.commit(status);
	}
	//回滚事务
	public void rollback(TransactionStatus status) {
		dataSourceTransactionManager.rollback(status);
	}
}

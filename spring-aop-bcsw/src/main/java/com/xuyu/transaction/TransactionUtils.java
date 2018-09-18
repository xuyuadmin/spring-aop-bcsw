package com.xuyu.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

//������� �ֶ�
@Component
public class TransactionUtils {

	//��ȡ�Լ�������Դ
	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;
	
	//��������
	public TransactionStatus begin() {
		TransactionStatus transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
		//��������״̬
		return transaction;
	}
	//�ύ����
	public void commit(TransactionStatus status) {
		dataSourceTransactionManager.commit(status);
	}
	//�ع�����
	public void rollback(TransactionStatus status) {
		dataSourceTransactionManager.rollback(status);
	}
}

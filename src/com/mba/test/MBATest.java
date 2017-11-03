package com.mba.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mba.beans.LoanManager;
import com.mba.helper.AuthenticationHelper;

public class MBATest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/mba/common/application-context.xml");
		LoanManager loanManager = context.getBean("loanManager", LoanManager.class);
		
		AuthenticationHelper authenticationHelper = AuthenticationHelper.getInstance();
		authenticationHelper.login("john1", "welcome1");
		
		boolean status = loanManager.approveLoan("l1001");
		System.out.println("Status: "+status);
	}
}

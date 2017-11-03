package com.mba.aspect;

import org.aspectj.lang.JoinPoint;

import com.mba.helper.AuthenticationHelper;

public class SecurityAspect {
private AuthenticationHelper authenticationHelper;
	
	//[AuditAspect advice method logic]
	public void audit(JoinPoint joinPoint) {
		String methodName = null;
		Object[] args = null;
		args = joinPoint.getArgs();
		
		methodName = joinPoint.getSignature().getName();
		/*System.out.println(AuthenticationHelper.getInstance().getLoggedInUser()+" has accessed "+methodName+ " with loanNo "+args[0]);*/
		System.out.println(authenticationHelper.getLoggedInUser()+" has accessed "+methodName+ " with loanNo "+args[0]);
	}

    //[SecurityCheckAspect advice method logic]
	public void check(JoinPoint joinPoint) throws IllegalAccessException {
		if(authenticationHelper.authenticate() == false) {
			throw new IllegalAccessException("Invalid username/password");
		}
	}
	public void setAuthenticationHelper(AuthenticationHelper authenticationHelper) {
		this.authenticationHelper = authenticationHelper;
	}
}

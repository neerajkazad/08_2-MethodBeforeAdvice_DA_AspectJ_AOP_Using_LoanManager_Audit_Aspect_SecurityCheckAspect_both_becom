package com.mba.notes;

public class Notes {
	/**
	 * In this example  
	 * Note1:
	 * <aop:config>
	    <aop:pointcut expression="execution(* com.mba.beans.*.*(..))" id="securityPointcut"/>
		<aop:aspect ref="securityAspect">
			<aop:before method="audit" pointcut-ref="securityPointcut"/>
			<aop:before method="check" pointcut-ref="securityPointcut" />
		</aop:aspect>
	   </aop:config>
	   
	  * If you see the above code in the BeforeAdvice when we are working in the one aspect that advice two
	  * advice method then we can't use the "order" attribute to execute or advice the advice method. There is
	  * no attribute which we can use at <aop:before or after> level when we are using in the same aspect because
	  * both are related advice method (related to security) that's the reason we wrote both advice method inside
	  * the SecurityAspect class.
	  * 
	  * So when we are using two advice method and advice inside the one aspect so declare in the same order in which
	  * order you want to execute it, because we can't use "order" attribute.
	  * 
	  * IQ: We are writing two advice method inside the One AspectClass, How we can execute it?
	  * A: In which order we declare in the same order advice method is going to advice on the target
	  * class method.
	 */
}

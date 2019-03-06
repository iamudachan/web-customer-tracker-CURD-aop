package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution (* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution (* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution (* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow(){}
	
	
	
//	add @Before advice
	@Before("forAppFlow()")
	private void before(JoinPoint theJointPoint){
		String methodName = theJointPoint.getSignature().toShortString();
		logger.info("=====>> @before: calling method : "+methodName);
		
		Object[] obj = theJointPoint.getArgs();
		for(Object o : obj){
			logger.info("===>> arguments:"+o);
		}
	}
	
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResutl"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResutl){
		String methodName = theJoinPoint.getSignature().toShortString();
		logger.info("=====>> @AfterReturning: calling method : "+methodName);
		
		logger.info("=====>> @theResutl:  "+theResutl);
	}
	
}

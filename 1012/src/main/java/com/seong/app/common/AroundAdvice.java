package com.seong.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointcutCommon.bPointcut()")
	public Object printlog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println();
		System.out.println("--- 수행 시간 체크 ----");
		System.out.println("메소드명: " + pjp.getSignature().getName());
		
		StopWatch sw = new StopWatch();
		
		sw.start();
		Object obj = pjp.proceed();
		sw.stop();
		
		System.out.println("수행 소요 시간: " + sw.getTotalTimeMillis());
		System.out.println("-------------------");
		System.out.println();
		return obj;
		
		}
	
}

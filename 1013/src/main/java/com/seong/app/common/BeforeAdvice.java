package com.seong.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect // Aspect : 위빙 처리의 대상 == pointcut + advice 결합
public class BeforeAdvice {
	
	@Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {		
		System.out.println("=================");
		System.out.println(jp.getSignature().getName() + " 메소드 수행 전에 데이터 출력이 시작됩니다!");
		System.out.println("=================");
	}
}

package com.seong.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	
	@Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {		
		System.out.println("=================");
		System.out.println(jp.getSignature().getName() + " 메소드 수행 전에 데이터 출력이 시작됩니다!");
		System.out.println("=================");
	}
}

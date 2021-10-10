package com.seong.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// 테스팅할 때 사용
public class AroundAdvice {
	public Object printlog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("AroundAdvice - pjp인자를 갖는 메소드에서 출력하는 문구-1");
		
		System.out.println("메소드명: " + pjp.getSignature().getName());
		
		StopWatch sw = new StopWatch(); // 스프링에서 제공하는 객체
		
		sw.start();
		Object obj =  pjp.proceed(); // proceed : 수행 결과를 Object형으로 반환 (자원확인, 수행시간, 트랜잭션 autocommit false->true 처리 등)
		sw.stop();
		
		System.out.println("수행 소요 시간: " + sw.getTotalTimeMillis());
		
		System.out.println("AroundAdvice - pjp인자를 갖는 메소드에서 출력하는 문구-2");
		return obj;
	}
}

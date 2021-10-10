package com.seong.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect // 실시간 weaving 처리를 위해 aspect라는 것을 명시
public class AfterAdvice {
	
	// asepect(advice + pointcut)를 만들어야 실시간 weaving 처리가 가능하다.
	@After("PointcutCommon.bPointcut()") // 동작 시점과 결합할 pointcut 설정
	public void pringLog(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String name = jp.getSignature().getName();
		
		System.out.println("메소드명: " + name);
		System.out.println("매개변수정보: " + args);
		System.out.println("핵심관리 후에 호출됨!");
	}
}

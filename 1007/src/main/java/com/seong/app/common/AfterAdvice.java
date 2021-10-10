package com.seong.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterAdvice {
	public void pringLog(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String name = jp.getSignature().getName();
		
		System.out.println("메소드명: " + name);
		System.out.println("매개변수정보: " + args);
		System.out.println("핵심관리 후에 호출됨!");
	}
}

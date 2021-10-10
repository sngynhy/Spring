package com.seong.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterThrowingAdvice {
	public void pringLog(JoinPoint jp, Exception e) {
		
		String name = jp.getSignature().getName();
		System.out.println("메소드명: " + name);
		System.out.println("예외: " + e);
		
		if(e instanceof IllegalAccessException) {
			System.out.println("적절하지 않은 매개변수입니다.");
			System.out.println("1. id가 pk인데 0 or 중복되는지 확인 필요");
		} else if (e instanceof ArithmeticException) {
			System.out.println("0으로 나눌 수 없습니다");
		} else {
			System.out.println("미확인 예외입니다.");
		}
		
		
		System.out.println("예외발생 시 호출됨!");
	}
}

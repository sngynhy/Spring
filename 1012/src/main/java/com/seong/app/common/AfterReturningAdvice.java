package com.seong.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterReturningAdvice {
	
	public void beforeLog(JoinPoint jp, Object obj) throws Throwable {
		System.out.println();
		System.out.println("=================");
		System.out.println("메소드명: " + jp.getSignature().getName());
		
		if (obj instanceof MemberVO) {
			MemberVO mVO = (MemberVO) obj;
			if (mVO.getRole().equals("ADMIN")) {
				System.out.println("관리자 로그인!");
			} else if (!mVO.getRole().equals("ADMIN")) {
				System.out.println("일반 사용자 로그인!");
			} else if (mVO.getRole() == null){
				System.out.println("로그인 실패!");
			}
		}
		System.out.println("=================");
	}
}

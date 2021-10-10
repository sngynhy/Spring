package com.seong.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterReturningAdvice {
	public void pringLog(JoinPoint jp, Object obj) {
		String name = jp.getSignature().getName();
		System.out.println("메소드명: " + name);
		
		// obj가 모든 클래스와 사용이 가능하기 때문에 instanceof로 먼저 체크
		if (obj instanceof MemberVO) { // instanceof : 캐스팅 가능 여부  true/false 반환
			MemberVO mVO = (MemberVO) obj;
			if (mVO.getRole().equals("ADMIN")) {
				System.out.println("관리자 로그인");
			} else if(!mVO.getRole().equals("admin")) {
				System.out.println("일반사용자 로그인");
			} else {
				System.out.println("로그인 실패!");
			}
		}
		System.out.println("get()와 조합되는 returning!");
	}
}

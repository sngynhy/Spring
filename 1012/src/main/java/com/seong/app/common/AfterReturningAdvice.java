package com.seong.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterReturningAdvice {
	
	public void beforeLog(JoinPoint jp, Object obj) throws Throwable {
		System.out.println();
		System.out.println("=================");
		System.out.println("�޼ҵ��: " + jp.getSignature().getName());
		
		if (obj instanceof MemberVO) {
			MemberVO mVO = (MemberVO) obj;
			if (mVO.getRole().equals("ADMIN")) {
				System.out.println("������ �α���!");
			} else if (!mVO.getRole().equals("ADMIN")) {
				System.out.println("�Ϲ� ����� �α���!");
			} else if (mVO.getRole() == null){
				System.out.println("�α��� ����!");
			}
		}
		System.out.println("=================");
	}
}

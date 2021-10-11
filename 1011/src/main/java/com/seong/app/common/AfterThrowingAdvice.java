package com.seong.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterThrowingAdvice {
	public void pringLog(JoinPoint jp, Exception e) {
		
		String name = jp.getSignature().getName();
		System.out.println("�޼ҵ��: " + name);
		System.out.println("����: " + e);
		
		if(e instanceof IllegalAccessException) {
			System.out.println("�������� ���� �Ű������Դϴ�.");
			System.out.println("1. id�� pk�ε� 0 or �ߺ��Ǵ��� Ȯ�� �ʿ�");
		} else if (e instanceof ArithmeticException) {
			System.out.println("0���� ���� �� �����ϴ�");
		} else {
			System.out.println("��Ȯ�� �����Դϴ�.");
		}
		
		
		System.out.println("���ܹ߻� �� ȣ���!");
	}
}

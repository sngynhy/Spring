package com.seong.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import model.member.MemberVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.cPointcut()", returning="obj")
	public void pringLog(JoinPoint jp, Object obj) {
		String name = jp.getSignature().getName();
		System.out.println("�޼ҵ��: " + name);
		
		// obj�� ��� Ŭ������ ����� �����ϱ� ������ instanceof�� ���� üũ
		if (obj instanceof MemberVO) { // instanceof : ĳ���� ���� ����  true/false ��ȯ
			MemberVO mVO = (MemberVO) obj;
			if (mVO.getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			} else if(!mVO.getRole().equals("admin")) {
				System.out.println("�Ϲݻ���� �α���");
			} else {
				System.out.println("�α��� ����!");
			}
		}
		System.out.println("get()�� ���յǴ� returning!");
	}
}

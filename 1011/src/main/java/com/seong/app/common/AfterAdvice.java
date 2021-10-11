package com.seong.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect // �ǽð� weaving ó���� ���� aspect��� ���� ���
public class AfterAdvice {
	
	// asepect(advice + pointcut)�� ������ �ǽð� weaving ó���� �����ϴ�.
	@After("PointcutCommon.bPointcut()") // ���� ������ ������ pointcut ����
	public void pringLog(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String name = jp.getSignature().getName();
		
		System.out.println("�޼ҵ��: " + name);
		System.out.println("�Ű���������: " + args);
		System.out.println("�ٽɰ��� �Ŀ� ȣ���!");
	}
}

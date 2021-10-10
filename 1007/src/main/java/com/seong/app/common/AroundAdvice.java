package com.seong.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// �׽����� �� ���
public class AroundAdvice {
	public Object printlog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("AroundAdvice - pjp���ڸ� ���� �޼ҵ忡�� ����ϴ� ����-1");
		
		System.out.println("�޼ҵ��: " + pjp.getSignature().getName());
		
		StopWatch sw = new StopWatch(); // ���������� �����ϴ� ��ü
		
		sw.start();
		Object obj =  pjp.proceed(); // proceed : ���� ����� Object������ ��ȯ (�ڿ�Ȯ��, ����ð�, Ʈ����� autocommit false->true ó�� ��)
		sw.stop();
		
		System.out.println("���� �ҿ� �ð�: " + sw.getTotalTimeMillis());
		
		System.out.println("AroundAdvice - pjp���ڸ� ���� �޼ҵ忡�� ����ϴ� ����-2");
		return obj;
	}
}

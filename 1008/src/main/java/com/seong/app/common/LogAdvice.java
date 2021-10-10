package com.seong.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	// pointcut�� ��ġ ���	- ����Ʈ��Ŭ������.�޼ҵ��
	@Before("PointcutCommon.aPointcut()")
	public void printLog() {
		System.out.println("����Ͻ� �޼��带 �����ϱ� ���� ��µǴ� �α�!");
	}
}

package com.seong.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon { // ����Ʈ�� Ŭ����
	
	// ���� �޼ҵ� - advice�� pointcut�� '�ĺ�'�ϱ� ���� �޼ҵ�
	// pointcut�� ������ �� �ʿ䰡 ����, ���¸� �����ϸ� �Ǳ� ������ �޼ҵ��� �ٵ���� ����ִ�.
	// <aop:pointcut expression="execution(* model.board.*Impl.get*(..))" id="aPointCut"/>�� ���� ����
	@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void aPointcut() {}
	@Pointcut("execution(* model.board.*Impl.*(..))")
	public void bPointcut() {}
	@Pointcut("execution(* model.member.*Impl.get*(..))")
	public void cPointcut() {}
}

package com.seong.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon { // 포인트컷 클래스
	
	// 참조 메소드 - advice가 pointcut을 '식별'하기 위한 메소드
	// pointcut의 로직은 알 필요가 없고, 형태만 구분하면 되기 때문에 메소드의 바디블럭이 비어있다.
	// <aop:pointcut expression="execution(* model.board.*Impl.get*(..))" id="aPointCut"/>와 같은 역할
	@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void aPointcut() {}
	@Pointcut("execution(* model.board.*Impl.*(..))")
	public void bPointcut() {}
	@Pointcut("execution(* model.member.*Impl.get*(..))")
	public void cPointcut() {}
}

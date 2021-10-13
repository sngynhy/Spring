package com.seong.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // Aspect : 위빙 처리의 대상 == pointcut + advice 결합
public class PointcutCommon {
	
	@Pointcut("execution(* model..*Impl.get*(..))")
	public void aPointcut() {}
	@Pointcut("execution(* model..*Impl.*(..))")
	public void bPointcut() {}
}

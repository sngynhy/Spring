package com.seong.app.common;

// 부가적 기능 (횡단 관심 == Advice)
public class LogAdvice {
	
	// 모든 메서드마다 공통으로 처리될 로직
	public void printLog() {
		System.out.println("비즈니스 메서드를 수행하기 전에 출력되는 로그!");
		// 만일 log의 출력문구를 변경하고 싶다면 현재 함수만 변경해주면 된다 -> 높은 응집도!
	}
}

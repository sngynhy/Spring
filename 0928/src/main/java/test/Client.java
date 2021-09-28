package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너 동작시키기
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 객체 요청 시 해당 객체를 줌 == Look up
		Test t = (Test) factory.getBean("test"); // 파라미터 값 == applicationContext.xml에 bean 등록 시 설정한 id 값
		t.print();
		
		Phone phone = (Phone) factory.getBean("Phone");
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		
		// 3. 스프링 컨테이너 종료
		factory.close();
		
		// console
		// 현재 <bean>으로 등록된 모든 클래스에 대한 객체를 미리 생성해 놓음
		// pre-loading (즉시 로딩) <-> lazy-loading (지연 로딩) : bean 등록 시 설정 가능
		// 기본 생성자 호출됨!
		
	}
}

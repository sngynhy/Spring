package test2;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Master {
	
	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너 동작
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 객체 요청(Look Up)
		Animal ani = (Animal) factory.getBean("animal");
		ani.sound();
		ani.play();
		
		CBean cb = (CBean) factory.getBean("cb2");
		List<String> list = cb.getList();
		for (String v : list) {
			System.out.println(v);
		}
		
		Map<String, String> map = cb.getMap();
		System.out.println(map);
		
		// 3. 스프링 컨테이너 종료
		factory.close();
	}
}

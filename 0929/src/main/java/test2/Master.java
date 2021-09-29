package test2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Master {
	
	public static void main(String[] args) {
		
		// 1. ������ �����̳� ����
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. ��ü ��û(Look Up)
		Animal ani = (Animal) factory.getBean("animal");
		ani.sound();
		ani.play();
		
		// 3. ������ �����̳� ����
		factory.close();
	}
}

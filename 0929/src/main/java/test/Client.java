package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		
		// 1. ������ �����̳� ���۽�Ű��
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. ��ü ��û(==Look up) �� �ش� ��ü�� �ǳ���
		Phone phone = (Phone) factory.getBean("Phone");
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		
		// 3. ������ �����̳� ����
		factory.close();
		
		// console
		// ���� <bean>���� ��ϵ� ��� Ŭ������ ���� ��ü�� �̸� ������ ����
		// pre-loading (��� �ε�) <-> lazy-loading (���� �ε�) : bean ��� �� ���� ����
		// �⺻ ������ ȣ���!
		
	}
}

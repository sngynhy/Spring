package test;

import org.springframework.stereotype.Component;

// (id��)
//@Component("sword") // ������̼� ó�� == <bean class="test.Sword" id="sword"/>�� ������ ����
public class Sword implements Weapon {
	@Override
	public void attack() {
		System.out.println("������ ����!!!");
	}
}

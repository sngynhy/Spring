package test;

import org.springframework.stereotype.Component;

// (id값)
//@Component("sword") // 어노테이션 처리 == <bean class="test.Sword" id="sword"/>와 동일한 역할
public class Sword implements Weapon {
	@Override
	public void attack() {
		System.out.println("검으로 공격!!!");
	}
}

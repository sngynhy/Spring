package test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("champ")
public class Champ implements ChampAction {
	
	private String name;
	private List<String> inven;
	//@Autowired // 의존성 주입하는데에 사용 -> 컨테이너는 Autowired를 보고 자신이 "만들어 두었던" 객체의 "타입"을 확인! (해당 자료형이 유일해야하고, 만들어 두지 않았다면 에러발생)
				// 스프링 컨테이너가 관리하기 때문에 생성자나 getter, setter가 필요하지 않음
	@Resource(name="bow") // 객체명 설정
	private Weapon weapon;
	
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getInven() {
		return inven;
	}
	public void setInven(List<String> inven) {
		this.inven = inven;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}*/
	
	@Override
	public void attack() {
		weapon.attack();
		// NullPointerException(예외) 발생 우려가 있으므로, new로 객체를 생성해야하지만
		// 멤버변수로 처리 - 생성자 주입
		// setter 주입으로 변경 (기본 생성자 필요!)
	}
	@Override
	public void print() {
		System.out.println(name);
		for (String v : inven) {
			System.out.println(v);
		}
	}
	
}

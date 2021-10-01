package test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("champ")
public class Champ implements ChampAction {
	
	private String name;
	private List<String> inven;
	//@Autowired // ������ �����ϴµ��� ��� -> �����̳ʴ� Autowired�� ���� �ڽ��� "����� �ξ���" ��ü�� "Ÿ��"�� Ȯ��! (�ش� �ڷ����� �����ؾ��ϰ�, ����� ���� �ʾҴٸ� �����߻�)
				// ������ �����̳ʰ� �����ϱ� ������ �����ڳ� getter, setter�� �ʿ����� ����
	@Resource(name="bow") // ��ü�� ����
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
		// NullPointerException(����) �߻� ����� �����Ƿ�, new�� ��ü�� �����ؾ�������
		// ��������� ó�� - ������ ����
		// setter �������� ���� (�⺻ ������ �ʿ�!)
	}
	@Override
	public void print() {
		System.out.println(name);
		for (String v : inven) {
			System.out.println(v);
		}
	}
	
}

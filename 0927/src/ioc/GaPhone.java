package ioc;

public class GaPhone implements Phone {
	
	public void volumeUp() {
		System.out.println("���� += 10");
	}
	public void volumeDown() {
		System.out.println("���� -= 10");
	}
	public void powerOn() {
		System.out.println("���� ����");
	}
	public void powerOff() {
		System.out.println("���� ����");
	}
}

package ioc;

public class IPhone implements Phone {
	
	public void volumeUp() {
		System.out.println("����++");
	}
	public void volumeDown() {
		System.out.println("����--");
	}
	public void powerOn() {
		System.out.println("���� ON");
	}
	public void powerOff() {
		System.out.println("���� OFF");
	}
}

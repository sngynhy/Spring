package test;

public class IPhone implements Phone {
	
	private Watch watch;
	private String user;
	
	public IPhone() {
		System.out.println("������ �⺻ ������ ȣ��");
	}
	
	public IPhone(Watch watch, String user) {
		this.watch = watch;
		this.user = user;
		System.out.println("������ ������ ȣ��");
	}
	public void volumeUp() {
		watch.volumeUp();
//		System.out.println("������ ����++");
	}
	public void volumeDown() {
		watch.volumeDown();
//		System.out.println("������ ����--");
	}
	public void powerOn() {
		System.out.println("������ ���� ON");
	}
	public void powerOff() {
		System.out.println("������ ���� OFF");
	}
}

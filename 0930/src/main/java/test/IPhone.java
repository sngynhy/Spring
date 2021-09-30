package test;

public class IPhone implements Phone {
	
	private Watch watch;
	private String user;
	
	public IPhone() {
		System.out.println("������ �⺻ ������ ȣ��");
	}
	
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public void setUser(String user) {
		this.user = user;
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
		System.out.println(this.user + " ������ ���� ON");
	}
	public void powerOff() {
		System.out.println(this.user + " ������ ���� OFF");
	}
}

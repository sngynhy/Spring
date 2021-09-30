package test;

public class GaPhone implements Phone {
	
	private Watch watch;
	private String user;
	
	public GaPhone() {
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
	}
	public void volumeDown() {
		watch.volumeDown();
	}
	public void powerOn() {
		System.out.println(this.user + "������ ���� ON");
	}
	public void powerOff() {
		System.out.println(this.user + "������ ���� OFF");
	}
}

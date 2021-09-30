package test;

public class IPhone implements Phone {
	
	private Watch watch;
	private String user;
	
	public IPhone() {
		System.out.println("아이폰 기본 생성자 호출");
	}
	
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public void volumeUp() {
		watch.volumeUp();
//		System.out.println("아이폰 볼륨++");
	}
	public void volumeDown() {
		watch.volumeDown();
//		System.out.println("아이폰 볼륨--");
	}
	public void powerOn() {
		System.out.println(this.user + " 아이폰 전원 ON");
	}
	public void powerOff() {
		System.out.println(this.user + " 아이폰 전원 OFF");
	}
}

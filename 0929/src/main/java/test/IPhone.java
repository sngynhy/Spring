package test;

public class IPhone implements Phone {
	
	private Watch watch;
	private String user;
	
	public IPhone() {
		System.out.println("아이폰 기본 생성자 호출");
	}
	
	public IPhone(Watch watch, String user) {
		this.watch = watch;
		this.user = user;
		System.out.println("아이폰 생성자 호출");
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
		System.out.println("아이폰 전원 ON");
	}
	public void powerOff() {
		System.out.println("아이폰 전원 OFF");
	}
}

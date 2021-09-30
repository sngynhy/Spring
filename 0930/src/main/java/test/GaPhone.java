package test;

public class GaPhone implements Phone {
	
	private Watch watch;
	private String user;
	
	public GaPhone() {
		System.out.println("갤럭시 기본 생성자 호출");
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
		System.out.println(this.user + "갤럭시 전원 ON");
	}
	public void powerOff() {
		System.out.println(this.user + "갤럭시 전원 OFF");
	}
}

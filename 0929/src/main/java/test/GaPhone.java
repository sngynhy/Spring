package test;

public class GaPhone implements Phone {
	
//	private GalaxyWatch gw; // 메모리 낭비 방지를 위해 필드로 설정
	private Watch watch; // 낮은 결합도를 위해 SmartWatch가 아닌 Watch로
	private String user;
	
	public GaPhone() {
		System.out.println("갤럭시 기본 생성자 호출");
	}
	public GaPhone(Watch watch, String user) { // 불필요한 객체 생성을 막기 위해 객체를 인자로 전달받음
		this.watch = watch; // 낮은 결합도를 위해 GalaxyWatch가 아닌 Watch로
		this.user = user;
		System.out.println("갤럭시 생성자 호출");
	}
	public void volumeUp() {
//		GalaxyWatch gw = new GalaxyWatch();
		watch.volumeUp();
//		System.out.println("갤럭시 볼륨 += 10");
	}
	public void volumeDown() {
//		GalaxyWatch gw = new GalaxyWatch(); // 위에서 이미 생성된 객체를 다시 생성해서 사용하는건 메모리 낭비! -> 이때 싱글톤 패턴을 사용!
		watch.volumeDown();
//		System.out.println("갤럭시 볼륨 -= 10");
	}
	public void powerOn() {
		System.out.println("갤럭시 전원 켜짐");
	}
	public void powerOff() {
		System.out.println("갤럭시 전원 꺼짐");
	}
}

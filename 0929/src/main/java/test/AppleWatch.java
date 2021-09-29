package test;

public class AppleWatch implements Watch {
	
	public AppleWatch() {
		System.out.println("애플워치 기본 생성자 호출");
	}
	@Override
	public void volumeUp() {
		System.out.println("애플워치로 볼륨 UP");
		
	}
	@Override
	public void volumeDown() {
		System.out.println("애플워치로 볼륨 DOWN");
		
	}
}

package test;

public class GalaxyWatch implements Watch {
	
	public GalaxyWatch() {
		System.out.println("갤럭시워치 기본 생성자 호출");
	}
	@Override
	public void volumeUp() {
		System.out.println("갤럭시워치로 볼륨 UP");
	}
	@Override
	public void volumeDown() {
		System.out.println("갤럭시워치로 볼륨 DOWN");
	}
}

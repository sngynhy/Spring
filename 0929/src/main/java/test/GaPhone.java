package test;

public class GaPhone implements Phone {
	
//	private GalaxyWatch gw; // �޸� ���� ������ ���� �ʵ�� ����
	private Watch watch; // ���� ���յ��� ���� SmartWatch�� �ƴ� Watch��
	private String user;
	
	public GaPhone() {
		System.out.println("������ �⺻ ������ ȣ��");
	}
	public GaPhone(Watch watch, String user) { // ���ʿ��� ��ü ������ ���� ���� ��ü�� ���ڷ� ���޹���
		this.watch = watch; // ���� ���յ��� ���� GalaxyWatch�� �ƴ� Watch��
		this.user = user;
		System.out.println("������ ������ ȣ��");
	}
	public void volumeUp() {
//		GalaxyWatch gw = new GalaxyWatch();
		watch.volumeUp();
//		System.out.println("������ ���� += 10");
	}
	public void volumeDown() {
//		GalaxyWatch gw = new GalaxyWatch(); // ������ �̹� ������ ��ü�� �ٽ� �����ؼ� ����ϴ°� �޸� ����! -> �̶� �̱��� ������ ���!
		watch.volumeDown();
//		System.out.println("������ ���� -= 10");
	}
	public void powerOn() {
		System.out.println("������ ���� ����");
	}
	public void powerOff() {
		System.out.println("������ ���� ����");
	}
}

package test;

public class GalaxyWatch implements Watch {
	
	public GalaxyWatch() {
		System.out.println("�����ÿ�ġ �⺻ ������ ȣ��");
	}
	@Override
	public void volumeUp() {
		System.out.println("�����ÿ�ġ�� ���� UP");
	}
	@Override
	public void volumeDown() {
		System.out.println("�����ÿ�ġ�� ���� DOWN");
	}
}

package ioc;

public class Client {
	
	public static void main(String[] args) {
		
//		Phone phone = new IPhone(); // Ÿ���� �������̽��� �����ϸ� ���յ��� ��������!
		BeanFactory factory = new BeanFactory();
		Phone phone = (Phone) factory.getBean(args[0]); // getBean()�� ���ϰ��� object�̹Ƿ� ĳ���� �ʿ�
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		
	}
}

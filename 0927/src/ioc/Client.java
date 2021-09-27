package ioc;

public class Client {
	
	public static void main(String[] args) {
		
//		Phone phone = new IPhone(); // 타입을 인터페이스로 설정하면 결합도가 낮아진다!
		BeanFactory factory = new BeanFactory();
		Phone phone = (Phone) factory.getBean(args[0]); // getBean()는 리턴값이 object이므로 캐스팅 필요
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		
	}
}

package ioc;

public class GaPhone implements Phone {
	
	public void volumeUp() {
		System.out.println("º¼·ý += 10");
	}
	public void volumeDown() {
		System.out.println("º¼·ý -= 10");
	}
	public void powerOn() {
		System.out.println("Àü¿ø ÄÑÁü");
	}
	public void powerOff() {
		System.out.println("Àü¿ø ²¨Áü");
	}
}

package test2;

public class Cat implements Animal {
	
	private Toy toy;
	private String name;
	
	public Cat() {
		System.out.println("����� ����!");
	}
	
	public void setToy(Toy toy) {
		this.toy = toy;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sound() {
		System.out.println("�߿�~");
	}
	@Override
	public void play() {
		toy.play();
	}
}

package test2;

public class Dog implements Animal {
	
	private Toy toy;
	private String name;
	public Dog() {
		System.out.println("������ ����");
	}
	public Dog(Toy toy, String name) {
		this.toy = toy;
		this.name = name;
		System.out.println(this.name + " �ȳ� :D");
	}
	@Override
	public void sound() {
		System.out.println("��!");
	}
	@Override
	public void play() {
		toy.toy();
	}
}

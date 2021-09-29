package test2;

public class Cat implements Animal {
	
	private Toy toy;
	private String name;
	
	public Cat() {
		System.out.println("고양이 생성!");
	}
	
	public Cat(Toy toy, String name) {
		this.toy = toy;
		this.name = name;
		System.out.println(this.name + " 안녕 :D");
	}
	
	@Override
	public void sound() {
		System.out.println("야옹~");
	}
	@Override
	public void play() {
		toy.toy();
	}
}

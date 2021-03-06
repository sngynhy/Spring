package test2;

public class Cat implements Animal {
	
	private Toy toy;
	private String name;
	
	public Cat() {
		System.out.println("고양이 생성!");
	}
	
	public void setToy(Toy toy) {
		this.toy = toy;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sound() {
		System.out.println("야옹~");
	}
	@Override
	public void play() {
		toy.play();
	}
}

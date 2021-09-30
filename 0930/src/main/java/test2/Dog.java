package test2;

public class Dog implements Animal {
	
	private Toy toy;
	private String name;
	public Dog() {
		System.out.println("강아지 생성");
	}

	public void setToy(Toy toy) {
		this.toy = toy;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sound() {
		System.out.println("왈!");
	}
	@Override
	public void play() {
		toy.play();
	}
}

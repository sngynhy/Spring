package test2;

public class Dog implements Animal {
	
	private Toy toy;
	private String name;
	public Dog() {
		System.out.println("°­¾ÆÁö »ý¼º");
	}
	public Dog(Toy toy, String name) {
		this.toy = toy;
		this.name = name;
		System.out.println(this.name + " ¾È³ç :D");
	}
	@Override
	public void sound() {
		System.out.println("¿Ð!");
	}
	@Override
	public void play() {
		toy.toy();
	}
}

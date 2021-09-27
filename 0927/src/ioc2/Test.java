package ioc2;

public class Test {
	
	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		Animal ani = (Animal) factory.getBean(args[0]);
		ani.sound();
		ani.play();
	}
}
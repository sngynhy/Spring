package ioc2;

public class BeanFactory {
	
	public Object getBean(String beanName) {
		if (beanName.equals("고양이") || beanName.toLowerCase().equals("cat")) {
			return new Cat();
		} else if (beanName.equals("강아지") || beanName.equals("개") || beanName.toLowerCase().equals("dog")) {
			return new Dog();
		}
		return null;
	}
}

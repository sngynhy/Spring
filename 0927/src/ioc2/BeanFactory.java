package ioc2;

public class BeanFactory {
	
	public Object getBean(String beanName) {
		if (beanName.equals("�����") || beanName.toLowerCase().equals("cat")) {
			return new Cat();
		} else if (beanName.equals("������") || beanName.equals("��") || beanName.toLowerCase().equals("dog")) {
			return new Dog();
		}
		return null;
	}
}

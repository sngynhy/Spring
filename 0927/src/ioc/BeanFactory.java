package ioc;

public class BeanFactory {
	
	public Object getBean(String beanName) {
		// 인자값에 맞는 객체를 생성하여 건네줌
		if (beanName.equals("Ga")) {
			return new GaPhone();
		} else if (beanName.equals("I")) {
			return new IPhone();
		}
		return null;
	}
}

package ioc;

public class BeanFactory {
	
	public Object getBean(String beanName) {
		// ���ڰ��� �´� ��ü�� �����Ͽ� �ǳ���
		if (beanName.equals("Ga")) {
			return new GaPhone();
		} else if (beanName.equals("I")) {
			return new IPhone();
		}
		return null;
	}
}

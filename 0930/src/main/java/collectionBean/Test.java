package collectionBean;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CBean cb = (CBean) factory.getBean("cb");
		
		List<String> list = cb.getList();
		for(String v : list) {
			System.out.println(v);
		}
		
		Map<String, String> map = cb.getMap();
		System.out.println(map);
		
		factory.close();
	}
}

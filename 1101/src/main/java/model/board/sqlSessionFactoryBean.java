package model.board;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sqlSessionFactoryBean {

	private static SqlSessionFactory sessionFactory = null;  // DAO�� �������� sql�� �������ִ� ��ü ���� ��ü

	static { // sessionFactory ����
		try {
			if(sessionFactory == null) { // �̱��� ������ ���� ���� ����
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml"); // sql-map-config.xml�� ������ �о����
				sessionFactory = new SqlSessionFactoryBuilder().build(reader); // reader ������ 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static SqlSession getSqlSessionInstance() {
		return sessionFactory.openSession(); // sessionFactory ����!
	}
}

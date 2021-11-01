package model.board;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sqlSessionFactoryBean {

	private static SqlSessionFactory sessionFactory = null;  // DAO를 수행해줄 sql을 제공해주는 객체 세션 객체

	static { // sessionFactory 생성
		try {
			if(sessionFactory == null) { // 싱글톤 패턴을 위한 조건 설정
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml"); // sql-map-config.xml의 설정을 읽어들임
				sessionFactory = new SqlSessionFactoryBuilder().build(reader); // reader 내용을 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static SqlSession getSqlSessionInstance() {
		return sessionFactory.openSession(); // sessionFactory 생성!
	}
}

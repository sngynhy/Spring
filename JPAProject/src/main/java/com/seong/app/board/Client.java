package com.seong.app.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Client {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject"); // persistence-unit의 name
		EntityManager em = emf.createEntityManager(); // DAO 클래스 생성 파트 
		
		EntityTransaction et = em.getTransaction(); // 트랜잭션
		try {
			et.begin();
			
			Board board = new Board();
			board.setId("ang");
			board.setTitle("JPA 망해라!!!!");
			board.setContent("와~~!");
			
			// 등록
			em.persist(board); // insert문 생성
			et.commit();
			
			// JPQL : SQL문들의 표준으로써, JPA 구현체가 읽어들여 해당 DBMS의 SQL문으로 처리
			String jpql = "select b from Board b";
			List<Board> datas = em.createQuery(jpql, Board.class).getResultList();
			for (Board v : datas) {
				System.out.println(v );
			}
			
		} catch (Exception e) {
			et.rollback();
		} finally {
			em.close();
			emf.close();
		}
		
	}
}

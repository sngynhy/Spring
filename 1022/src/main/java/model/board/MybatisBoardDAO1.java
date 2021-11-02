package model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisBoardDAO1 extends SqlSessionDaoSupport { // jdbcTemplate과 유사
	
	@Autowired // applicationContext.xml에 등록한 sessionFactory 객체 주입
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insertBoard(BoardVO vo) {
		getSqlSession().insert("dao.inserBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		getSqlSession().update("dao.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		getSqlSession().delete("dao.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) getSqlSession().selectOne("dao.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		return getSqlSession().selectList("dao.getBoardList", vo);
	}
}

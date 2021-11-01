package model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDAO {

	private SqlSession mybatis;
	
	public BoardDAO() {
		mybatis = sqlSessionFactoryBean.getSqlSessionInstance();
	}
	public void insertBoard(BoardVO vo) {
		mybatis.insert("dao.insertBoard", vo); // board-mappins.xml에서 설정한 namespace로 메소드를 호출할 수 있음
		mybatis.commit();
	}
	public void updateBoard(BoardVO vo) {
		mybatis.update("dao.updateBoard", vo);
		mybatis.commit();
	}
	public void deleteBoard(BoardVO vo) {
		mybatis.update("dao.deleteBoard", vo);
		mybatis.commit();
	}
	public List<BoardVO> getBoardList() {
		return mybatis.selectList("dao.getBoardList");
	}
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("dao.getBoard", vo);
	}
}

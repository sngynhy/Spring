package model.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisBoardDAO2 {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("dao.inserBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		mybatis.update("dao.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("dao.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("dao.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("dao.getBoardList", vo);
	}
}

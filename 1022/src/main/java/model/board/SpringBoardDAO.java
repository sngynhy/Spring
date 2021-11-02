package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class BoardRowMapper implements RowMapper<BoardVO> {
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO outvo = new BoardVO();
		outvo.setWpk(rs.getInt("wpk"));
		outvo.setTitle(rs.getString("title"));
		outvo.setId(rs.getString("id"));
		outvo.setContent(rs.getString("content"));
		outvo.setWdate(rs.getDate("wdate"));
		return outvo;
	}
}
//Spring에서 제공하는 DAO
//방법1. extends 상속 받아서 구현
//방법2. jdbcTemplate객체를 <bean>으로 등록하여 의존성 주입받아 사용★ (사용 빈도 높음)
@Repository
public class SpringBoardDAO {
	
	private final String insertSQL = "insert into board (wpk, title, id, content) values (nvl((select max(wpk) from board),0)+1, ?, ?, ?)";
	private final String updateSQL = "update board set title = ?, content = ? where wpk = ?";
	private final String deleteSQL = "delete board where wpk = ?";
	private final String getBoardListSQL = "select * from board";
	private final String getBoardSQL = "select * from board where wpk = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO invo) {
		System.out.println("jdbcTemplate으로 insert");
		jdbcTemplate.update(insertSQL, invo.getTitle(), invo.getId(), invo.getContent());
	}
	public void updateBoard(BoardVO invo) {
		System.out.println("jdbcTemplate으로 update");
		jdbcTemplate.update(updateSQL, invo.getTitle(), invo.getContent(), invo.getWpk());
	}
	public void deleteBoard(BoardVO invo) {
		System.out.println("jdbcTemplate으로 delete");
		jdbcTemplate.update(deleteSQL, invo.getWpk());
	}
	public List<BoardVO> getBoardList(BoardVO invo) {
		System.out.println("jdbcTemplate으로 getBoardList");
		return jdbcTemplate.query(getBoardListSQL, new BoardRowMapper());

	}
	public BoardVO getBoard(BoardVO invo) {
		System.out.println("jdbcTemplate으로 getBoard");
		Object[] args = {invo.getWpk()};
		return jdbcTemplate.queryForObject(getBoardSQL, args, new BoardRowMapper());
		
	}
}

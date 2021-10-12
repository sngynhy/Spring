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
		outvo.setWriter(rs.getString("writer"));
		outvo.setContent(rs.getString("content"));
		outvo.setWdate(rs.getDate("wdate"));
		return outvo;
	}
}

@Repository
public class BoardDAO {
	private final String insertSQL = "insert into board (wpk, title, writer, content) values (nvl((select max(wpk) from board),0)+1, ?, ?, ?)";
	private final String getBoardListSQL1 = "select * from board order by wpk";
	private final String getBoardListSQL2 = "select * from board where title like ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("JdbcTemplate으로 게시글 등록");
		jdbcTemplate.update(insertSQL, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		if (vo.getKeyword() == null) {
			System.out.println("JdbcTemplate으로 모든 게시글 조회");
			return jdbcTemplate.query(getBoardListSQL1, new BoardRowMapper());
		} else {
			System.out.println("JdbcTemplate으로 특정 게시글 조회");
			Object[] args = {"%" + vo.getKeyword() + "%"};
			return jdbcTemplate.query(getBoardListSQL2, args, new BoardRowMapper());
		}
	}
}

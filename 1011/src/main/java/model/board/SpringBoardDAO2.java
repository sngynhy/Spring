package model.board;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//Spring���� �����ϴ� DAO
//���1. extends ��� �޾Ƽ� ����
//���2. jdbcTemplate��ü�� <bean>���� ����Ͽ� ������ ���Թ޾� ���� (��� �� ����)
@Repository
public class SpringBoardDAO2 {
	
	private final String insertSQL = "insert into board (wpk, title, writer, content) values (nvl((select max(wpk) from board),0)+1, ?, ?, ?)";
	private final String updateSQL = "update board set title = ?, content = ? where wpk = ?";
	private final String deleteSQL = "delete board where wpk = ?";
	private final String getBoardListSQL = "select * from board";
	private final String getBoardSQL = "select * from board where wpk = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO invo) {
		System.out.println("jdbcTemplate���� insert");
		jdbcTemplate.update(insertSQL, invo.getTitle(), invo.getWriter(), invo.getContent());
	}
	public void updateBoard(BoardVO invo) {
		System.out.println("jdbcTemplate���� update");
		jdbcTemplate.update(updateSQL, invo.getTitle(), invo.getContent(), invo.getWpk());
	}
	public void deleteBoard(BoardVO invo) {
		System.out.println("jdbcTemplate���� delete");
		jdbcTemplate.update(deleteSQL, invo.getWpk());
	}
	public List<BoardVO> getBoardList(BoardVO invo) {
		System.out.println("jdbcTemplate���� getBoardList");
		return jdbcTemplate.query(getBoardListSQL, new BoardRowMapper());

	}
	public BoardVO getBoard(BoardVO invo) {
		System.out.println("jdbcTemplate���� getBoard");
		Object[] args = {invo.getWpk()};
		return jdbcTemplate.queryForObject(getBoardSQL, args, new BoardRowMapper());
		
	}
}

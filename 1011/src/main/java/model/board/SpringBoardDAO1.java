package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

// BoardRowMapper�� RowMapper �������̽��� ��ӹ޾� class�� ����
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

// Spring���� �����ϴ� DAO
// ���1. extends ��� �޾Ƽ� ������
// ���2. jdbcTemplate��ü�� <bean>���� ����Ͽ� ������ ���Թ޾� ���
@Repository
public class SpringBoardDAO1 extends JdbcDaoSupport{
	
	private final String insertSQL = "insert into board (wpk, title, writer, content) values (nvl((select max(wpk) from board),0)+1, ?, ?, ?)";
	private final String updateSQL = "update board set title = ?, content = ? where wpk = ?";
	private final String deleteSQL = "delete board where wpk = ?";
	private final String getBoardListSQL = "select * from board";
	private final String getBoardSQL = "select * from board where wpk = ?";
	
	// DataSource �޾ƿ���
	@Autowired // ��
	public void setSuperDataSource(DataSource dataSouce) {
		super.setDataSource(dataSouce);
	}
	
	public void insertBoard(BoardVO invo) {
		System.out.println("jdbcTemplate���� insert");
		getJdbcTemplate().update(insertSQL, invo.getTitle(), invo.getWriter(), invo.getContent());
	}
	
	public void updateBoard(BoardVO invo) {
		System.out.println("jdbcTemplate���� update");
		getJdbcTemplate().update(updateSQL, invo.getTitle(), invo.getContent(), invo.getWpk());
	}
	
	public void deleteBoard(BoardVO invo) {
		System.out.println("jdbcTemplate���� delete");
		getJdbcTemplate().update(deleteSQL, invo.getWpk());
	}
	public List<BoardVO> getBoardList(BoardVO invo) {
		System.out.println("jdbcTemplate���� getBoardList");
		return getJdbcTemplate().query(getBoardListSQL, new BoardRowMapper());

	}
	public BoardVO getBoard(BoardVO invo) {
		System.out.println("jdbcTemplate���� getBoard");
		Object[] args = {invo.getWpk()};
		return getJdbcTemplate().queryForObject(getBoardSQL, args, new BoardRowMapper());
		
	}
	
}

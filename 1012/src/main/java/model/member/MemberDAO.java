package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class MemberRowMapper implements RowMapper<MemberVO> {
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO outvo = new MemberVO();
		outvo.setId(rs.getString("id"));
		outvo.setPw(rs.getString("pw"));
		outvo.setName(rs.getString("name"));
		outvo.setRole(rs.getString("role"));
		return outvo;
	}
}

@Repository
public class MemberDAO {
	
	private final String insertSQL = "insert into members values (?, ?, ?, ?)";
	private final String loginSQL = "select * from members where id = ? and pw = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertMember(MemberVO vo) {
		System.out.println("JdbcTemplate으로 회원 등록");
		jdbcTemplate.update(insertSQL, vo.getId(), vo.getPw(), vo.getName(), vo.getRole());
	}
	public MemberVO login(MemberVO vo) {
		System.out.println("JdbcTemplate으로 로그인");
		Object[] args = {vo.getId(), vo.getPw()};
		return jdbcTemplate.queryForObject(loginSQL, args, new MemberRowMapper());
	}
}

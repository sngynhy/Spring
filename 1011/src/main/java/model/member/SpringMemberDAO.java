package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
public class SpringMemberDAO {
	
	private final String insertSQL = "insert into members values (?, ?, ?, ?)";
	private final String updateSQL = "update members set pw = ?, name = ? where id = ?";
	private final String deleteSQL = "delete board where id = ?";
	private final String getMemberListSQL = "select * from members";
	private final String loginSQL = "select * from members where id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertMember(MemberVO invo) {
		System.out.println("jdbcTemplate으로 insert");
		jdbcTemplate.update(insertSQL, invo.getId(), invo.getPw(), invo.getName(), invo.getRole());
	}
	
	public void updateMember(MemberVO invo) {
		System.out.println("jdbcTemplate으로 update");
		jdbcTemplate.update(updateSQL, invo.getPw(), invo.getName(), invo.getId());
	}
	
	public void deleteMember(MemberVO invo) {
		System.out.println("jdbcTemplate으로 delete");
		jdbcTemplate.update(deleteSQL, invo.getId());
	}
	
	public List<MemberVO> getMemberList(MemberVO invo) {
		System.out.println("jdbcTemplate으로 getMemberList");
		return jdbcTemplate.query(getMemberListSQL, new MemberRowMapper());
	}
	
	public MemberVO login(MemberVO invo) {
		System.out.println("jdbcTemplate으로 login");
		Object[] args = {invo.getId()};
		return jdbcTemplate.queryForObject(loginSQL, args, new MemberRowMapper());
		
	}
}

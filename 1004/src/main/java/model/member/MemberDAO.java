package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("memberDAO")
public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private final String insertSQL = "insert into members values (?, ?, ?, ?)";
	private final String updateSQL = "update members set pw = ?, name = ? where id = ?";
	private final String deleteSQL = "delete board where id = ?";
	private final String getMemberListSQL = "select * from members";
	private final String getMemberSQL = "select * from members where id = ?";
	
	public void insertMember(MemberVO invo) {
		
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, invo.getId());
			pstmt.setString(2, invo.getPw());
			pstmt.setString(3, invo.getName());
			pstmt.setString(4, invo.getRole());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void updateMember(MemberVO invo) {
		
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, invo.getPw());
			pstmt.setString(2, invo.getName());
			pstmt.setString(3, invo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void deleteMember(MemberVO invo) {

		conn = JDBC.getConnection();

		try {
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setString(1, invo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public List<MemberVO> getMemberList(MemberVO invo) {

		conn = JDBC.getConnection();
		List<MemberVO> datas = new ArrayList<MemberVO>();
		
		try {
			pstmt = conn.prepareStatement(getMemberListSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO data = new MemberVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	
	public MemberVO getMember(MemberVO invo) {

		conn = JDBC.getConnection();
		MemberVO outvo = null;
		
		try {
			pstmt = conn.prepareStatement(getMemberSQL);
			pstmt.setString(1, invo.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				outvo = new MemberVO();
				outvo.setId(rs.getString("id"));
				outvo.setPw(rs.getString("pw"));
				outvo.setName(rs.getString("name"));
				outvo.setRole(rs.getString("role"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JDBC.close(conn, pstmt);
		}
		return outvo;
	}
}

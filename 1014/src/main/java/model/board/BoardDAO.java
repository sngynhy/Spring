package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;


@Repository("boardDAO")
public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String insertSQL = "insert into board (wpk, title, writer, content) values (nvl((select max(wpk) from board),0)+1, ?, ?, ?)";
	private final String updateSQL = "update board set title = ?, content = ? where wpk = ?";
	private final String deleteSQL = "delete board where wpk = ?";
	private final String getBoardListSQL = "select * from board";
	private final String getBoardSQL = "select * from board where wpk = ?";
	
	public void insertBoard(BoardVO invo) {
		
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, invo.getTitle());
			pstmt.setString(2, invo.getWriter());
			pstmt.setString(3, invo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void updateBoard(BoardVO invo) {
			
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, invo.getTitle());
			pstmt.setString(2, invo.getContent());
			pstmt.setInt(3, invo.getWpk());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void deleteBoard(BoardVO invo) {
		
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, invo.getWpk());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	public List<BoardVO> getBoardList(BoardVO invo) {
		
		conn = JDBC.getConnection();
		List<BoardVO> datas = new ArrayList<BoardVO>();
		
		try {
			pstmt = conn.prepareStatement(getBoardListSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO data = new BoardVO();
				data.setWpk(rs.getInt("wpk"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
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
	public BoardVO getBoard(BoardVO invo) {
		
		conn = JDBC.getConnection();
		BoardVO outvo = null;
		
		try {
			pstmt = conn.prepareStatement(getBoardSQL);
			pstmt.setInt(1, invo.getWpk());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				outvo = new BoardVO();
				outvo.setWpk(rs.getInt("wpk"));
				outvo.setTitle(rs.getString("title"));
				outvo.setWriter(rs.getString("writer"));
				outvo.setContent(rs.getString("content"));
				outvo.setWdate(rs.getDate("wdate"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		return outvo;
	}
}

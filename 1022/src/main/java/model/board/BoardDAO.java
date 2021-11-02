package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository
public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String insertSQL = "insert into board (wpk, title, id, content) values (nvl((select max(wpk) from board),0)+1, ?, ?, ?)";
	private final String selectSQL = "select max(wpk) as wpk from board";
	private final String updateSQL = "update board set title = ?, content = ? where wpk = ?";
	private final String deleteSQL = "delete board where wpk = ?";
	private final String getBoardListSQL = "select * from board";
	private final String getBoardSQL = "select * from board where wpk = ?";
	
	public int insertBoard(BoardVO invo) {
		
		conn = JDBC.getConnection();
		int wpk = -1;
		
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, invo.getTitle());
			pstmt.setString(2, invo.getId());
			pstmt.setString(3, invo.getContent());
			if (pstmt.executeUpdate() == 0) {
				return wpk;
			}
			
			pstmt = conn.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				wpk = rs.getInt("wpk");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		return wpk;
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
			if (invo.getKeyword() == null) { // 전체 게시글 조회
				pstmt = conn.prepareStatement(getBoardListSQL + " order by wdate desc");
			} else { // 특정 키워드로 검색
				if (invo.getType().equals("title")) { // 제목으로 검색
					String sql = getBoardListSQL + " where title like ? order by wdate desc";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + invo.getKeyword() + "%");
				} else if (invo.getType().equals("content")) { // 내용으로 검색
					String sql = getBoardListSQL + " where content like ? order by wdate desc";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + invo.getKeyword() + "%");
				} else if (invo.getType().equals("id")) { // 작성자로 검색
					String sql = getBoardListSQL + " where id like ? order by wdate desc";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + invo.getKeyword() + "%");
				}
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO data = new BoardVO();
				data.setWpk(rs.getInt("wpk"));
				data.setTitle(rs.getString("title"));
				data.setId(rs.getString("id"));
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
	
	public BoardVO getBoard(BoardVO invo) { // 선택 글 보기
		
		conn = JDBC.getConnection();
		BoardVO data = null;
		
		try {
			pstmt = conn.prepareStatement(getBoardSQL);
			pstmt.setInt(1, invo.getWpk());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				data = new BoardVO();
				data.setWpk(rs.getInt("wpk"));
				data.setTitle(rs.getString("title"));
				data.setId(rs.getString("id"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
}

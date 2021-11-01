package model.board;

import java.util.List;

public class Client {
	
	public static void main(String[] args) {
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setTitle("제목");
		vo.setContent("내용");
		vo.setId("작성자");
		
		dao.insertBoard(vo);
		List<BoardVO> datas = dao.getBoardList();
		for(BoardVO v : datas) {
			System.out.println(v );
		}
	}
}

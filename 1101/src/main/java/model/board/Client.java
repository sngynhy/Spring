package model.board;

import java.util.List;

public class Client {
	
	public static void main(String[] args) {
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setTitle("����");
		vo.setContent("����");
		vo.setId("�ۼ���");
		
		dao.insertBoard(vo);
		List<BoardVO> datas = dao.getBoardList();
		for(BoardVO v : datas) {
			System.out.println(v );
		}
	}
}

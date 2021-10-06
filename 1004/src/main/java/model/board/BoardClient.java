package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs = (BoardService) factory.getBean("boardService"); // ���� ������̼ǿ� ������ �̸�
		
		BoardVO vo = new BoardVO();
//		vo.setTitle("������");
//		vo.setContent("���� �ۼ���~~");
//		vo.setWriter("������");
//		bs.insertBoard(vo);
		
		List<BoardVO> datas = bs.getBoardList(vo);
		for (BoardVO data : datas) {
			System.out.println(data);
		}
		
		factory.close();
	}
}

package model.common;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.board.BoardService;
import model.board.BoardVO;
import model.member.MemberService;
import model.member.MemberVO;

public class Client {

	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs = (BoardService) factory.getBean("boardService");
		MemberService ms = (MemberService) factory.getBean("memberService");
		
		MemberVO mVO = new MemberVO();
		BoardVO bVO = new BoardVO();
		
//		mVO.setId("ang");
//		mVO.setPw("asdf");
//		mVO.setName("��");
//		mVO.setRole("USER");
		
//		ms.insertMember(mVO);
		
		mVO.setId("seong");
		mVO.setPw("asdf");
		
		if (ms.login(mVO)!=null) {
			if (ms.login(mVO).getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			} else {
				System.out.println(ms.login(mVO).getId() + "�� �α���");
			}
		} else {
			System.out.println("�α��� ����!");
		}
		
		bVO.setWriter(mVO.getId());
		bVO.setTitle("�������m");
		bVO.setContent("��~~~~~");
		
		bs.insertBoard(bVO);
		
		List<BoardVO> list = bs.getBoardList(bVO); // ��� �Խñ� ��ȸ
		for (BoardVO v : list) {
			System.out.println(v);
		}
		
		bVO.setKeyword("��");
		list = bs.getBoardList(bVO); // Ư�� Ű����� ��ȸ
		for (BoardVO v : list) {
			System.out.println(v);
		}

		factory.close();
	}

}

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
//		mVO.setName("앙");
//		mVO.setRole("USER");
		
//		ms.insertMember(mVO);
		
		mVO.setId("seong");
		mVO.setPw("asdf");
		
		if (ms.login(mVO)!=null) {
			if (ms.login(mVO).getRole().equals("ADMIN")) {
				System.out.println("관리자 로그인");
			} else {
				System.out.println(ms.login(mVO).getId() + "님 로그인");
			}
		} else {
			System.out.println("로그인 실패!");
		}
		
		bVO.setWriter(mVO.getId());
		bVO.setTitle("아헤헤헿");
		bVO.setContent("잼~~~~~");
		
		bs.insertBoard(bVO);
		
		List<BoardVO> list = bs.getBoardList(bVO); // 모든 게시글 조회
		for (BoardVO v : list) {
			System.out.println(v);
		}
		
		bVO.setKeyword("아");
		list = bs.getBoardList(bVO); // 특정 키워드로 조회
		for (BoardVO v : list) {
			System.out.println(v);
		}

		factory.close();
	}

}

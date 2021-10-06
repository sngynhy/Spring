package model.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms = (MemberService) factory.getBean("memberService");
		
		MemberVO vo = new MemberVO();
//		vo.setId("seong");
//		vo.setPw("pw");
//		vo.setName("성윤혜");
//		vo.setRole("user");
//		ms.insertMember(vo);
		
		vo.setId("seong");
		vo.setPw("pw");
		if (ms.login(vo) != null) {
			System.out.println("로그인 성공!");
		} else {
			System.out.println("로그인 실패!");
		}
		
		
		List<MemberVO> datas = ms.getMemberList(vo);
		for (MemberVO data : datas) {
			System.out.println(data);
		}
		
	}

}

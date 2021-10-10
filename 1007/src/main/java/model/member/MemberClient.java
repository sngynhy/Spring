package model.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms = (MemberService) factory.getBean("memberService");
		
		MemberVO vo = new MemberVO();
		vo.setId("seong2");
		vo.setPw("pw");
		vo.setName("성윤혜");
		vo.setRole("user");
		ms.insertMember(vo); // aroundAdvice가 현재 메소드를 가로채서 선 처리 후 다시 보냄 -> 수행 소요 시간 등을 알 수 있음
		
		vo.setId("seong");
		vo.setPw("pw");
		
		List<MemberVO> datas = ms.getMemberList(vo);
		for (MemberVO data : datas) {
			System.out.println(data);
		}
		
	}

}

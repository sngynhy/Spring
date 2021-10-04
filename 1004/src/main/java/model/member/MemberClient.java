package model.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms = (MemberService) factory.getBean("memberService");
		
		MemberVO vo = new MemberVO();
		vo.setId("seong");
		vo.setPw("pw");
		vo.setName("¼ºÀ±Çý");
		vo.setRole("user");
		ms.insertMember(vo);
		
		List<MemberVO> datas = ms.getMemberList(vo);
		for (MemberVO data : datas) {
			System.out.println(data);
		}
		
	}

}

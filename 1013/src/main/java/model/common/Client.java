package model.common;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.member.MemberService;
import model.member.MemberVO;

public class Client {

	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		MemberService ms = (MemberService) factory.getBean("memberService");
		
		MemberVO mVO = new MemberVO();
		
		mVO.setId("ang");
		mVO.setPw("asdf");
		mVO.setName("��");
		
		ms.insertMember(mVO);
		
//		mVO.setId("seong");
//		mVO.setPw("asdf");
		
		if (ms.login(mVO)!=null) {
			if (ms.login(mVO).getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			} else {
				System.out.println(ms.login(mVO).getId() + "�� �α���");
			}
		} else {
			System.out.println("�α��� ����!");
		}

		factory.close();
	}

}

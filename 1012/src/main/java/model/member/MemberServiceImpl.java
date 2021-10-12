package model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}
	@Override
	public MemberVO login(MemberVO vo) {
		try {
			return memberDAO.login(vo);
		} catch(Exception e) {
			return null;
		}
		
	}
}

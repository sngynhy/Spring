package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SpringMemberDAO memberDAO;
	
	@Override
	public boolean insertMember(MemberVO invo) {
		return memberDAO.insertMember(invo);
	}
	@Override
	public void updateMember(MemberVO invo) {
		memberDAO.updateMember(invo);
	}
	@Override
	public void deleteMember(MemberVO invo) {
		memberDAO.deleteMember(invo);
	}
	@Override
	public List<MemberVO> getMemberList(MemberVO invo) {
		return memberDAO.getMemberList(invo);
	}
	@Override
	public MemberVO login(MemberVO invo) {
		return memberDAO.login(invo);
	}
	@Override
	public MemberVO checkID(String id) {
		return memberDAO.checkID(id);
	}
}

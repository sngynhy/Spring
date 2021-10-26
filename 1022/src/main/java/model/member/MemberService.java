package model.member;

import java.util.List;

public interface MemberService {
	void insertMember(MemberVO invo);
	void updateMember(MemberVO invo);
	void deleteMember(MemberVO invo);
	List<MemberVO> getMemberList(MemberVO invo);
	MemberVO login(MemberVO invo);
}

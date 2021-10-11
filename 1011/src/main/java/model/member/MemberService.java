package model.member;

import java.util.List;

// 일관성있는 메서드 시그니처를 위해 인터페이스 사용
public interface MemberService {
	void insertMember(MemberVO invo);
	void updateMember(MemberVO invo);
	void deleteMember(MemberVO invo);
	List<MemberVO> getMemberList(MemberVO invo);
	MemberVO login(MemberVO invo);
}

package model.member;

public interface MemberService {
	void insertMember(MemberVO vo);
	MemberVO login(MemberVO vo);
}

package kr.co.bit.member.dao;

import java.util.List;

import kr.co.bit.member.vo.MemberVO;

public interface MemberDAO {
	MemberVO getMemberByNo(int no);
	boolean insertMember(MemberVO member);
	boolean updateMember(MemberVO member);
	List<MemberVO> getMembers();
	boolean getMemberById(String id);
	MemberVO loginMember(MemberVO member);
}

package kr.co.bit.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.bit.member.vo.MemberVO;

@Service
public interface MemberService {
	
	MemberVO getMemberByNo(int no);
	boolean insertMember(MemberVO member);
	boolean updateMember(MemberVO member);
	List<MemberVO> getMembers();
	boolean getMemberById(String id);
	MemberVO loginMember(MemberVO member);

}

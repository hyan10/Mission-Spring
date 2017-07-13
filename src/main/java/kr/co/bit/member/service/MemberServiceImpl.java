package kr.co.bit.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bit.member.dao.MemberDAO;
import kr.co.bit.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO dao; 

	public MemberVO getMemberByNo(int no) {
		MemberVO member = dao.getMemberByNo(no);
		return member;
	}

	public boolean insertMember(MemberVO member) {

		return dao.insertMember(member);
	}

	public boolean updateMember(MemberVO member) {

		return dao.updateMember(member);
	}

	public List<MemberVO> getMembers() {

		return dao.getMembers();
	}

	public boolean getMemberById(String id) {
		return dao.getMemberById(id);
	}

	public MemberVO loginMember(MemberVO member) {
		return dao.loginMember(member);
	}

	
	
}

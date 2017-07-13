package kr.co.bit.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bit.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public MemberVO getMemberByNo(int no) {
		MemberVO member = sqlSessionTemplate.selectOne("member.dao.MemberDAO.getMemberByNo", no);
		return member;
	}

	public boolean insertMember(MemberVO member) {
		boolean result = false;
		System.out.println(member);
		if (sqlSessionTemplate.insert("member.dao.MemberDAO.insertMember", member) == 1) {
			result = true;
		}
		return result;
	}

	public boolean updateMember(MemberVO member) {
		boolean result = false;

		if (sqlSessionTemplate.insert("member.dao.MemberDAO.updateMember", member) == 1) {
			result = true;
		}
		return result;
	}

	public List<MemberVO> getMembers() {
		return sqlSessionTemplate.selectList("member.dao.MemberDAO.getMembers");
	}

	public boolean getMemberById(String id) {
		boolean result = false;
		if(sqlSessionTemplate.selectOne("member.dao.MemberDAO.getMemberById", id)!=null){
			result = true;
		}
		return result;
	}

	public MemberVO loginMember(MemberVO member) {
		return sqlSessionTemplate.selectOne("member.dao.MemberDAO.loginMember", member);
	}

	
}

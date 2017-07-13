package kr.co.bit.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bit.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 전체 게시글 조회
	 */
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = sqlSessionTemplate.selectList("board.dao.BoardDAO.selectAllBoard");
		return list;
	}

	public BoardVO selectByNoBoard(int no) {
		BoardVO board = sqlSessionTemplate.selectOne("board.dao.BoardDAO.selectOneByNo", no);
		return board;
	}
	
	public boolean insertBoard(BoardVO board) {
		boolean result = false;

		// sqlSessionTemplate 이 commit, rollback 관리해줌
		if (sqlSessionTemplate.insert("board.dao.BoardDAO.insertBoard", board) == 1) {
			result = true;
		}

		return result;
	}

	public boolean updateBoard(BoardVO board) {
		boolean result = false;

		if (sqlSessionTemplate.update("board.dao.BoardDAO.updateBoard", board) == 1) {
			result = true;
		}

		return result;
	}

}

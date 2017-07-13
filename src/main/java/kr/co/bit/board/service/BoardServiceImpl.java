package kr.co.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;

	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = dao.selectAllBoard();
		return list;
	}

	public BoardVO selectBoard(int no) {
		BoardVO board = dao.selectByNoBoard(no);
		return board;
	}

	public boolean insertBoard(BoardVO board) {
		return dao.insertBoard(board);
	}

	public boolean updateBoard(BoardVO board) {
		return dao.updateBoard(board);
	}

	public BoardVO selectByNoBoard(int no) {
		return dao.selectByNoBoard(no);
	}
	
	
	
}

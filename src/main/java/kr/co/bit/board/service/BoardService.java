package kr.co.bit.board.service;

import java.util.List;

import kr.co.bit.board.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> selectAllBoard();
	BoardVO selectBoard(int no);
	boolean insertBoard(BoardVO board);
	boolean updateBoard(BoardVO board);
	BoardVO selectByNoBoard(int no);
	
}

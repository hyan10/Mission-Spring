package kr.co.bit.board.dao;

import java.util.List;

import kr.co.bit.board.vo.BoardVO;

public interface BoardDAO {
	
	List<BoardVO> selectAllBoard();

	BoardVO selectByNoBoard(int no);
	boolean insertBoard(BoardVO board);
	boolean updateBoard(BoardVO board);
	
}

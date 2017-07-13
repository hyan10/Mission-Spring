package kr.co.bit.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.bit.board.service.BoardService;
import kr.co.bit.board.vo.BoardVO;

@RestController
public class AjaxController {

	@Autowired
	BoardService service;
	
	@RequestMapping(value="/ajax/detail.do", method=RequestMethod.POST)
	public BoardVO detail(@RequestBody BoardVO board) {
		BoardVO result = service.selectByNoBoard(board.getNo());
		return result;
	}
}

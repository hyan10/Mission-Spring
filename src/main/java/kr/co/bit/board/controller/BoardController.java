package kr.co.bit.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bit.board.service.BoardService;
import kr.co.bit.board.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	// @Qualifier("boardServiceImpl")
	private BoardService service;
	
	@RequestMapping("/list.do")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		
		List<BoardVO> list = service.selectAllBoard();
		mav.addObject("list", list);
		mav.addObject("size", 10);
		mav.setViewName("/board/list");
		
		System.out.println("전체 게시글 목록 처리");
		return mav;
	}
	
/* 
 	//detail.do?no=1
  	@RequestMapping("/detail.do")
	public String detail(@RequestParam("no") int no, Model model){
		BoardVO board = service.selectBoard(no);
		model.addAttribute("board",board);
		
		return "board/detail";
	}*/

	// board/1/detail.do
	@RequestMapping("/{no}/detail.do")
	public ModelAndView detail(@PathVariable int no){
		BoardVO board = service.selectBoard(no);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/detail");
		mav.addObject("board", board);
		
		return mav;
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.GET)	
	public String writeForm(Model model){
		model.addAttribute("board", new BoardVO());
		return "board/writeForm";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)	
	public String write(@Valid @ModelAttribute("board")BoardVO board, BindingResult result){
		
		if(result.hasErrors()) {
			System.out.println("오류발생...");
			return "board/writeForm";
		}
		
		/*ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/list.do");
		// mav.setViewName("/board/write");
		
		board.setWriter("ddd");
		System.out.println(board);
		
		boolean result = service.insertBoard(board);
		mav.addObject("result",result);
		
		return mav; */
		
		service.insertBoard(board);
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public String updateForm(Model model, @RequestParam("no") int no){
		BoardVO board = service.selectBoard(no);
		model.addAttribute("board", board);
		return "board/updateForm";
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView update(BoardVO board){
		ModelAndView mav = new ModelAndView();
		boolean result = service.updateBoard(board);
		mav.setViewName("redirect:/board/"+board.getNo()+"/detail.do");
	
		return mav;
	}
}

package kr.co.bit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bit.member.service.MemberService;
import kr.co.bit.member.vo.MemberVO;

@SessionAttributes("member")  // HttpSession과 다른 영역임. 호환x. request영역이지만 session 처럼 저장하고 있는것임
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping("/joinForm.do")
	public String joinForm(){
		return "/member/joinForm";
	}
	
	@RequestMapping("/join.do")	
	public String insertMember(MemberVO member){
		service.insertMember(member);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("/updateForm.do")
	public String updateForm(@RequestParam("no") int no, Model model){
		MemberVO member = service.getMemberByNo(no);
		model.addAttribute(member);
		return "/member/update";
	}
	
	@RequestMapping("/update.do")
	public String updateMember(MemberVO member){
		service.updateMember(member);
		return "/member/mypage";
	}
	
	@RequestMapping("/members.do")
	public ModelAndView getMembers(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/members");
		mav.addObject("memberList", service.getMembers());
		return mav;
	}
	
	@RequestMapping("/checkId.do")
	@ResponseBody
	public String checkId(@RequestParam("id") String id, Model model){
		boolean result = service.getMemberById(id);
		String msg = "";
		if (result){
			msg = "이미 존재하는 아이디입니다.";
		}else {
			msg = "사용 가능합니다.";
		}
		
		return "{\"msg\":\""+msg+"\", \"result\":\""+result+"\"}";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginForm(){
		return "member/loginForm";
	}
		
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(MemberVO member, Model model, HttpServletRequest request, HttpSession session){
		member = service.loginMember(member);
		
		if(member == null){
			model.addAttribute("msg","아이디 또는 패스워드가 잘못되었습니다.");
			return "member/login";
		}
		
		// 로그인 성공, 세션 등록
		
		// version 1.
		/* HttpSession session = request.getSession();  // 이렇게 안해도 session 받아올 수 있음
			session.setAttribute("member",member);
		*/
		
		// version 2. HttpSession에 등록
		/* session.setAttribute("member", member); */
		
		// version 3. @SessionAttributes("member") 이용. "member" 이름으로 등록되는 건 세션처럼 등록한다.
		model.addAttribute("member", member);
		
		
		return "redirect:/";

	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session, SessionStatus sessionStatus){
	
		// login version 1-2.
		// session.removeAttribute("member");
		// session.invalidate();
		
		// login version 3.
		sessionStatus.setComplete();
		
		return "redirect:/";
	}
	
}

package kr.co.bit.include;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IncludeController {
	
	@RequestMapping("/include/topMenu.do")
	public String topMenu(){
		return "include/topMenu";
	}
	
	//@RequestMapping("/include/footer.do")
	public String footer(){
		return "include/bottom";
	}
}

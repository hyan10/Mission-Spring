package kr.co.bit.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/ajax/test.do")
	public String test() {
		
		return "ajax/test";
	}
}

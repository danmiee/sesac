package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

//	@GetMapping("/sbb")
//	public void index() {
//		System.out.println("index");
//	}

	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return "안녕하세요 sbb에 오신 것을 환영합니다.";
	}

	@GetMapping("/") // url 매핑
	public String root() {
		// 지정한 페이지로 리다이렉트(클라이언트가 요청하면 새로운 url로 전송)
		return "redirect:/question/list";
	}
}

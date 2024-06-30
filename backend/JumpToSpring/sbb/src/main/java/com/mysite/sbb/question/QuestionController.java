package com.mysite.sbb.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {

	@GetMapping("/question/list")
//	@ResponseBody	// 템플릿 사용 시 불필요
	public String list() {
		return "question_list"; // question_list.html 파일 호출
	}
}

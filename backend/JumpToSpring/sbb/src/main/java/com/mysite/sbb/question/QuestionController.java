package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QuestionController {

	private final QuestionRepository questionRepository;

	@GetMapping("/question/list")
//	@ResponseBody	// 템플릿 사용 시 불필요
	public String list(Model model) {

		List<Question> questionList = this.questionRepository.findAll();
		model.addAttribute("questionList", questionList);
		return "question_list"; // question_list.html 파일 호출
	}
}

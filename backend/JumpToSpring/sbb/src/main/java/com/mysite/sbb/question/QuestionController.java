package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // final 속성 포함하는 생성자 자동 완성
@RequestMapping("/question") // url 프리픽스 사용
public class QuestionController {

//	private final QuestionRepository questionRepository;
	private final QuestionService questionService;

	@GetMapping("/list")
//	@ResponseBody	// 템플릿 사용 시 불필요
	public String list(Model model) {

//		List<Question> questionList = this.questionRepository.findAll();
		List<Question> questionList = this.questionService.getList();

		model.addAttribute("questionList", questionList);
		return "question_list"; // question_list.html 파일 호출
	}

	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
}

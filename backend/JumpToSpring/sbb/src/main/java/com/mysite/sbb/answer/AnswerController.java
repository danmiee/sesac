package com.mysite.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

	private final QuestionService questionService;
	private final AnswerService answerService;

	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id,
			@RequestParam(value = "content") String content) {
		Question question = this.questionService.getQuestion(id);
		// 답변 저장
		this.answerService.create(question, content);
		return String.format("redirect:/question/detail/%s", id);
	}
}

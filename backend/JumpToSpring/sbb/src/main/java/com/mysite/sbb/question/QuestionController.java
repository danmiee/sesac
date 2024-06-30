package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
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

	@GetMapping("/create")
	public String questionCreate() {
		return "question_form";
	}

//	@PostMapping("/create")
//	public String questionCreate(@RequestParam(value = "subject") String subject,
//			@RequestParam(value = "content") String content) {
//		// 질문 저장
//		this.questionService.create(subject, content);
//		return "redirect:/question/list"; // 질문 저장 후 질문 목록으로 이동
//	}

	// form 클래스 받기
	@PostMapping("/create")
	// 매개변수를 검증이 수행된 결과를 의미하는 객체로 변경
	// valid 후 BindingResult 나와야 정상 반영됨
	public String questionCreate(@Valid QuestionFrom questionFrom, BindingResult bindingResult) {
		// 오류나면 질문 등록 화면으로 돌아가기
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		this.questionService.create(questionFrom.getSubject(), questionFrom.getContent());
		return "redirect:/question/list";
	}
}

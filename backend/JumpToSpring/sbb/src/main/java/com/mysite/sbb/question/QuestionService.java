package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/*
 * Controller에서 Entity 클래스를 직접 사용하지 않도록 설계하기 위해 사용
 * Entity를 DTO로 변환하여 Controller와 연결하기
 */
@Service
@RequiredArgsConstructor
public class QuestionService {
	private final QuestionRepository questionRepository;

	public List<Question> getList() {
		return this.questionRepository.findAll();
	}
}

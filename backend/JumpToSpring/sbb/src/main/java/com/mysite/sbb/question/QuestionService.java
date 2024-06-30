package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

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

	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if (question.isPresent()) {
			return question.get();
		} else {
			// DataNotFoundException 클래스 필요
			throw new DataNotFoundException("question not found");
		}
	}
}

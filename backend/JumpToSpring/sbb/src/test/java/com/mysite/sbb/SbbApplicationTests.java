package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;

	@Test
	@Transactional // 메서드 종료까지 DB 세션 유지
	void testJpa() {

		String q1SubjectString = "sbb가 무엇인가요?";
		String q1ContenString = "sbb에 대해 알고싶어요.";
		String q2SubString = "스프링부트 모델 질문입니다.";
		String q2ContentString = "id는 자동으로 생성되나요?";
		String aString = "네 자동으로 생성됩니다.";

//		// 질문 데이터 저장
//		Question q1 = new Question();
//		q1.setSubject(q1SubjectString);
//		q1.setContent(q1ContenString);
//		q1.setCreateDate(LocalDateTime.now());
//		// 첫번째 질문 저장
//		this.questionRepository.save(q1);
//
//		Question q2 = new Question();
//		q2.setSubject(q2SubString);
//		q2.setContent(q2ContentString);
//		q2.setCreateDate(LocalDateTime.now());
//		// 두번째 질문 저장
//		this.questionRepository.save(q2);

//		// findAll
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//
//		Question q = all.get(0);
//		assertEquals(q1SubjectString, q.getSubject());

//		// findById
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if (oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals(q1SubjectString, q.getSubject());
//		}

//		// findBySubject
//		Question q = this.questionRepository.findBySubject(q1SubjectString);
//		assertEquals(1, q.getId());

//		// findBySubjectAndContent
//		Question q = this.questionRepository.findBySubjectAndContent(q1SubjectString, q1ContenString);
//		assertEquals(1, q.getId());

//		// findBySubjectList
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals(q1SubjectString, q.getSubject());

//		// Edit title
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent()); // 참인지 테스트
//		Question q = oq.get();
//		q.setSubject("수정된 제목"); // subject 속성 수정
//		this.questionRepository.save(q); // db에 저장

//		// Delete
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());

//		// Save answer
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent(aString);
//		a.setQuestion(q); // 어떤 질문의 답변인지 알기 위해 Question 객체 필요
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);

//		// Lookup answer - id가 1인 답변 조회
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());

		// find question data by answer data
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals(aString, answerList.get(0).getContent());
	}
}

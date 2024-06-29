package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {

		String q1SubjectString = "sbb가 무엇인가요?";
		String q1ContenString = "sbb에 대해 알고싶어요.";
		String q2SubString = "스프링부트 모델 질문입니다.";
		String q2ContentString = "id는 자동으로 생성되나요?";

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

		// Edit title
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent()); // 참인지 테스트
		Question q = oq.get();
		q.setSubject("수정된 제목"); // subject 속성 수정
		this.questionRepository.save(q); // db에 저장
	}
}

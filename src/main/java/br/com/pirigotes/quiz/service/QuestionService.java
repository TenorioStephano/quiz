package br.com.pirigotes.quiz.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pirigotes.quiz.model.Question;
import br.com.pirigotes.quiz.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> findQuestions() {
		return questionRepository.findAll();
	}

	public List<Question> findQuestionsShuffle() {
		List<Question> questions = findQuestions();
		Collections.shuffle(questions);
		return questions;
	}
	
}

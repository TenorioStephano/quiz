package br.com.pirigotes.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pirigotes.quiz.model.Answer;
import br.com.pirigotes.quiz.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	public boolean isCorrectAnswer(Long id) {
		Answer answer = answerRepository.findOne(id);
		if(answer != null) {
			return answer.isCorrect();
		}else {
			return false;
		}
	}
}

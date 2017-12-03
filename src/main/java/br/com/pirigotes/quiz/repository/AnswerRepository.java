package br.com.pirigotes.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pirigotes.quiz.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}

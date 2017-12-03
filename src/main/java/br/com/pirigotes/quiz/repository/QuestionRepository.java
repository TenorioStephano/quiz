package br.com.pirigotes.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pirigotes.quiz.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}

package br.com.pirigotes.quiz.model;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Question {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotEmpty
	private String question;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "QUESTION_ID")
	private List<Answer> answers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public List<Answer> getAnswersShuffle(){
		Collections.shuffle(getAnswers());
		return getAnswers();
	}
}

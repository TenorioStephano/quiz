package br.com.pirigotes.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.pirigotes.quiz.model.Player;
import br.com.pirigotes.quiz.model.Question;
import br.com.pirigotes.quiz.service.AnswerService;
import br.com.pirigotes.quiz.service.PlayerService;
import br.com.pirigotes.quiz.service.QuestionService;

@Controller
public class PlayController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private PlayerService playerService;
	
	private Question questionSelected;
	private Player player;
	private List<Question> questions;
	private int questionNumber;
	
	@GetMapping("play/{id}")
	public ModelAndView playPrimaryQuestion(@PathVariable String id){
		ModelAndView mv = new ModelAndView("play/play");
		setPlayer(playerService.findById(Long.parseLong(id)));
		if(getPlayer() == null) {
			return new ModelAndView("redirect:/");
		}
		setQuestionNumber(0);
		setQuestions(questionService.findQuestionsShuffle());
		
		if(getQuestions() != null && !getQuestions().isEmpty()) {
			setQuestionSelected(getQuestions().get(questionNumber));
		}
		mv.addObject("question", getQuestionSelected()).addObject("questionNumber", getQuestionNumber()+1);
		return mv;
		
	}
	
	@PostMapping("play")
	public ModelAndView playMoreQuestions(@RequestParam(value="answerSelected", required=true) Long answerSelected){
		ModelAndView mv = new ModelAndView("play/play");
		if(answerService.isCorrectAnswer(answerSelected)) {
			getPlayer().setPoints(getPlayer().getPoints()+1);
		}
		questionNumber++;
		if(questions.size() < questionNumber+1) {
			playerService.save(getPlayer());
			return new ModelAndView("redirect:/ranking");
		}else{
			setQuestionSelected(getQuestions().get(questionNumber));
		}
		return mv.addObject("question", getQuestionSelected()).addObject("questionNumber", getQuestionNumber()+1).addObject("player", getPlayer());
	}

	public Question getQuestionSelected() {
		return questionSelected;
	}

	public void setQuestionSelected(Question questionSelected) {
		this.questionSelected = questionSelected;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}

package br.com.pirigotes.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pirigotes.quiz.service.PlayerService;

@Controller
public class RankingController {
	
	@Autowired
	private PlayerService userService;
	
	@GetMapping("ranking")
	public ModelAndView playPrimaryQuestion(){
		return new ModelAndView("ranking/index").addObject("players", userService.findAllByOrderByPointsDescDateGameAsc());
	}

}

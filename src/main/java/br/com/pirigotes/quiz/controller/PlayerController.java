package br.com.pirigotes.quiz.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pirigotes.quiz.model.Player;
import br.com.pirigotes.quiz.service.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService userService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@PostMapping("player")
	public ModelAndView saveUser(Player user) {
		try {
			if(user != null) {
				user.setPoints(0);
				user.setDateGame(new Date());
				userService.save(user);
			}else {
				return new ModelAndView("redirect:/");
			}
			
		} catch (Exception e) {
			logger.error("Erro ao inserir usuário, erro:  " + e);
		}
		return new ModelAndView(String.format("redirect:/play/%s", user == null ? "" : user.getId()));
	}
}

package br.com.pirigotes.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pirigotes.quiz.model.Player;
import br.com.pirigotes.quiz.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository userRepository;
	
	public void save(Player user){
		userRepository.save(user);
	}

	public Player findById(Long id) {
		return userRepository.findOne(id);
	}
	
	public List<Player> findAllByOrderByPointsDescDateGameAsc(){
		return userRepository.findAllByOrderByPointsDescDateGameAsc();
	}
}

package br.com.pirigotes.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pirigotes.quiz.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	public List<Player> findAllByOrderByPointsDesc();
	
	public List<Player> findAllByOrderByPointsDescDateGameAsc();
}

package br.com.pirigotes.quiz.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Player {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotEmpty
	private String name;
	
	private int points;
	
	private Date dateGame;
	
	public String getDateGameFormated() {
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return dt.format(getDateGame());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int result) {
		this.points = result;
	}

	public Date getDateGame() {
		return dateGame;
	}

	public void setDateGame(Date dataJogo) {
		this.dateGame = dataJogo;
	}
	
}

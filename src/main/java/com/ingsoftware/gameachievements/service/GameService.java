package com.ingsoftware.gameachievements.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ingsoftware.gameachievements.dto.AchievementDTO;
import com.ingsoftware.gameachievements.exception.EntityNotFoundException;
import com.ingsoftware.gameachievements.model.Achievement;
import com.ingsoftware.gameachievements.model.Game;
import com.ingsoftware.gameachievements.repository.AchievementRepository;
import com.ingsoftware.gameachievements.repository.GameRepository;

@Service
public class GameService {

	private final Logger logger = LoggerFactory.getLogger(GameService.class);
	
	private GameRepository gameRepository;
	
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	public String create(Game input) {
		String randomUUID = UUID.randomUUID().toString();
		logger.info("Random UUID String generated = " +randomUUID);
		input.setId(randomUUID);
		Game game = gameRepository.save(input);
		return game.getId();
	}
	
	public Game findById(String id) {
		Optional<Game> game = gameRepository.findById(id);
		if(!game.isPresent()) {
			logger.info("Game with id:" + id + " doesn't exists.");
			throw new EntityNotFoundException("Game with id:" + id + " doesn't exists.");
		}
		return game.get();
	}
	
	public List<Game> getAll(){
		return gameRepository.findAll();
	}
	
}

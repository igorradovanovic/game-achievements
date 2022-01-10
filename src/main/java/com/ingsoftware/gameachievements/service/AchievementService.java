package com.ingsoftware.gameachievements.service;


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
public class AchievementService {

	private final Logger logger = LoggerFactory.getLogger(AchievementService.class);
	
	private GameRepository gameRepository;
	
	private AchievementRepository achievemenetRepository;
	
	public AchievementService(GameRepository gameRepository, AchievementRepository achievemenetRepository) {
		this.gameRepository = gameRepository;
		this.achievemenetRepository = achievemenetRepository;
	}
	
	public String create(Achievement input) {
		String randomUUID = UUID.randomUUID().toString();
		logger.info("Random UUID String generated = " +randomUUID);
		input.setId(randomUUID);
		Achievement achievement = achievemenetRepository.save(input);
		return achievement.getId();
	}
	
	public String update(Achievement input) {
		logger.info("Updating achievemenet id = " +input.getId());
		Achievement achievement = achievemenetRepository.save(input);
		return achievement.getId();
	}
	
	public Achievement findById(String id) {
		Optional<Achievement> achievement = achievemenetRepository.findById(id);
		if(!achievement.isPresent()) {
			logger.info("Achievement with id:" + id + " doesn't exists.");
			throw new EntityNotFoundException("Achievement with id:" + id + " doesn't exists.");
		}
		return achievement.get();
	}
	
	public List<Achievement> getAll(){
		return achievemenetRepository.findAll();
	}
	
	public Integer getDisplayOrderNo(String id) {
		Integer counter = achievemenetRepository.findDisplayOrderByGameId(id);
		logger.info("Get Display Order Number.... Display Order Number = " + counter + " for game id = " + id);
		return counter + 1;
	}
	
	
	@Transactional
	public String delete(String id) {
		Optional<Achievement> achievement = achievemenetRepository.findById(id);
		if(!achievement.isPresent()) {
			logger.info("Achievement with id:" + id + " doesn't exists.");
			throw new EntityNotFoundException("Achievement with id:" + id + " doesn't exists.");
		}
		achievemenetRepository.delete(achievement.get());
		return achievement.get().getId();
	}
	
	public Achievement createGameAchievemenet(AchievementDTO dtoData) {
		Game game = findByDisplayName(dtoData.getGameDisplayName());
		Achievement achievement = dtoToEntity(dtoData);
		return saveGameAchievement(game,achievement);
	}
	
	public Achievement updateGameAchievemenet(AchievementDTO dtoData) {
		Optional<Achievement> achievement = achievemenetRepository.findById(dtoData.getId());
		if(!achievement.isPresent()) {
				logger.info("Achievement with id:" + dtoData.getId() + " doesn't exists.");
				throw new EntityNotFoundException("Achievement with id:" + dtoData.getId() + " doesn't exists.");
			}
		Achievement forUpdate = achievement.get();
		forUpdate.setDisplayName(dtoData.getDisplayName());
		forUpdate.setDescription(dtoData.getDescription());
		forUpdate.setIcon(dtoData.getIcon());
		return achievemenetRepository.save(forUpdate);
	}
	
	public List<Achievement>findAllByGame(String id){
		Optional<Game> game = gameRepository.findById(id);
		if(!game.isPresent()) {
			logger.info("Game with id:" + id + " doesn't exists.");
			throw new EntityNotFoundException("Game with id:" + id + " doesn't exists.");
		}
		return achievemenetRepository.findAllByGameOrderByDisplayOrder(game.get());
	}
	
	//////////////////////////////////////////////private block///////////////////////////////////////////////////////////////
	
	@Transactional
	private Achievement updateGameAchievement(Game game, Achievement data) {
		
		Achievement achievement = new Achievement();
		achievement.setId(UUID.randomUUID().toString());
		achievement.setDisplayName(data.getDisplayName());
		achievement.setDescription(data.getDescription());
		achievement.setDisplayOrder(getDisplayOrderNo(game.getId()));
		achievement.setIcon(data.getIcon());
		achievement.setGame(game);
		Achievement achievementDB = achievemenetRepository.save(achievement);
		logger.info("New achievemenet name = " + data.getDisplayName() + " saved with game display name = " + game.getDisplayName());
		return achievementDB;
	}
	
	@Transactional
	private Achievement saveGameAchievement(Game game, Achievement data) {
		
		Achievement achievement = new Achievement();
		achievement.setId(UUID.randomUUID().toString());
		achievement.setDisplayName(data.getDisplayName());
		achievement.setDescription(data.getDescription());
		achievement.setDisplayOrder(getDisplayOrderNo(game.getId()));
		achievement.setIcon(data.getIcon());
		achievement.setGame(game);
		Achievement achievementDB = achievemenetRepository.save(achievement);
		logger.info("New achievemenet name = " + data.getDisplayName() + " saved with game display name = " + game.getDisplayName());
		return achievementDB;
	}
	
	private Achievement dtoToEntity(AchievementDTO dto) {
		Achievement entity = new Achievement();
		entity.setDisplayName(dto.getDisplayName());
		entity.setDescription(dto.getDescription());
		entity.setIcon(dto.getIcon());
		return entity;
	}
	
	private Game findByDisplayName(String displayName) {
			
			Game game = gameRepository.findByDisplayName(displayName);
			if(game == null) {
				logger.info("Game with display name:" + displayName + " doesn't exists.");
				throw new EntityNotFoundException("Game with display name:" + displayName + " doesn't exists.");
			}
			return game;
	}
	
}

package com.ingsoftware.gameachievements.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ingsoftware.gameachievements.dto.AchievementDTO;
import com.ingsoftware.gameachievements.model.Game;
import com.ingsoftware.gameachievements.service.AchievementService;
import com.ingsoftware.gameachievements.service.GameService;
import com.ingsoftware.gameachievements.system.ResponseWrapper;

@RestController
@RequestMapping("api")
public class GameAchievementController {

	private GameService gameService;
	
	private AchievementService achievementService;
	
	public GameAchievementController(GameService gameService, AchievementService achievementService){
		this.gameService = gameService;
		this.achievementService = achievementService;
	}
	
	@GetMapping("/game")
	public  ResponseEntity<?>getAll(){
		List<Game> games = gameService.getAll();
		return new ResponseEntity<Object>(new ResponseWrapper(games,HttpStatus.OK), HttpStatus.OK);
	}
	
	@PostMapping("/achievement")
	public ResponseEntity<?>save(@RequestBody AchievementDTO input){
		return new ResponseEntity<Object>(new ResponseWrapper(achievementService.createGameAchievemenet(input),HttpStatus.CREATED), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/achievement/{id}")
	public ResponseEntity<?>findById(@PathVariable String id){
		return new ResponseEntity<Object>(new ResponseWrapper(achievementService.findById(id),HttpStatus.FOUND), HttpStatus.FOUND);
		
	}
	
	@GetMapping("/achievement/byGame/{id}")
	public ResponseEntity<?>findByGameId(@PathVariable String id){
		return new ResponseEntity<Object>(new ResponseWrapper(achievementService.findAllByGame(id),HttpStatus.OK), HttpStatus.OK);
		
	}
	
	@PutMapping("/achievement")
	public ResponseEntity<?>findById(@Valid @RequestBody AchievementDTO input){
		return new ResponseEntity<Object>(new ResponseWrapper(achievementService.updateGameAchievemenet(input),HttpStatus.OK), HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/achievement/{id}")
	public ResponseEntity<?> deletePost(@PathVariable String id) {

	    String removedId = achievementService.delete(id);

	    if (removedId == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    return new ResponseEntity<Object>(new ResponseWrapper(removedId,HttpStatus.OK), HttpStatus.OK);
	}
	
}

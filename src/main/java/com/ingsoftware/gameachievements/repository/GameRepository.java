package com.ingsoftware.gameachievements.repository;

import org.springframework.stereotype.Repository;

import com.ingsoftware.gameachievements.model.Game;
import com.ingsoftware.gameachievements.system.CustomRepository;

@Repository
public interface GameRepository extends CustomRepository <Game, String> {

	Game findByDisplayName(String name);
}

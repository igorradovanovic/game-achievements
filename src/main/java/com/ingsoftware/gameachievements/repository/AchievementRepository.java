package com.ingsoftware.gameachievements.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ingsoftware.gameachievements.model.Achievement;
import com.ingsoftware.gameachievements.model.Game;
import com.ingsoftware.gameachievements.system.CustomRepository;

@Repository
public interface AchievementRepository extends CustomRepository <Achievement, String>{

	@Query(nativeQuery = true, value = "SELECT a.ach_display_order FROM achievements a where a.ach_game_id =:game_id  \n"
			+ "order by  a.ach_sys_update_date DESC FETCH FIRST 1 ROWS ONLY")
	public Integer findDisplayOrderByGameId(@Param("game_id")String gameId);
	
	List<Achievement> findAllByGameOrderByDisplayOrder(Game game);
}

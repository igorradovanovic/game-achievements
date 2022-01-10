package com.ingsoftware.gameachievements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ingsoftware.gameachievements.system.CustomRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
public class GameAchievementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameAchievementsApplication.class, args);
	}

}

package com.ingsoftware.gameachievements.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementDTO {


	public String id;
	
	public String displayName;
	
	public String description;
	
	public String icon;
	
	public String gameDisplayName;
	
}

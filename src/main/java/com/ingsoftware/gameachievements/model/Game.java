package com.ingsoftware.gameachievements.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "game")
@Entity
public class Game implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="gam_id")
	public String Id;
	
	@Column(name ="gam_display_name")
	public String displayName;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL , orphanRemoval = true)
	public List<Achievement> achievements;
}

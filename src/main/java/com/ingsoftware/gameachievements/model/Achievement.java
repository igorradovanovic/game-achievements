package com.ingsoftware.gameachievements.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "achievements")
@Entity
public class Achievement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="ach_id")
	public String Id;
	
	@Column(name ="ach_display_name")
	@Size(max = 100)
	@NotNull
	public String displayName;
	
	@Column(name ="ach_description")
	@Size(max = 500)
	@NotNull
	public String description;
	
	@Column(name ="ach_icon")
	public String icon;
	
	@Column(name ="ach_display_order")
	public Integer displayOrder;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="ach_game_id")
	public Game game;
	
	@CreationTimestamp
	@Column(name ="ach_sys_create_date")
	public Timestamp createDate;
	
	@UpdateTimestamp
	@Column(name ="ach_sys_update_date")
	public Timestamp updateDate;
}


package com.ingsoftware.gameachievements.system;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {
	
	void refresh(T t);
	void detach(T t);
	void clear();
}

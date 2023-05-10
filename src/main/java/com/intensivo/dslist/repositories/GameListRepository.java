package com.intensivo.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intensivo.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	
}

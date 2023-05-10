package com.intensivo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intensivo.dslist.dto.GameListDTO;
import com.intensivo.dslist.repositories.GameListRepository;

@Service //Registrar como componente do sistema
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository; 
	
	@Transactional(readOnly = true)
	public List<GameListDTO> getAll(){
		List <GameListDTO> result = gameListRepository.findAll().stream().map(x -> new GameListDTO(x)).toList();
		return result;
	}
}

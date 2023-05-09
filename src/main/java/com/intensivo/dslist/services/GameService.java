package com.intensivo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intensivo.dslist.dto.GameMinDTO;
import com.intensivo.dslist.repositories.GameRepository;

@Service //Registrar como componente do sistema
public class GameService {
	
	@Autowired //Injetar uma instância de GameRepository para chamada
	private GameRepository gameRepository; 
	
	public List<GameMinDTO> getAll(){
		List <GameMinDTO> result = gameRepository.findAll().stream().map(x -> new GameMinDTO(x)).toList(); //Transformar todo Game x para GameMinDTO
		return result;
	}
}

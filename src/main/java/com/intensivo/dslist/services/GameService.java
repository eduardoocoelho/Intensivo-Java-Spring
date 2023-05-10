package com.intensivo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intensivo.dslist.dto.GameDTO;
import com.intensivo.dslist.dto.GameMinDTO;
import com.intensivo.dslist.entities.Game;
import com.intensivo.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired //Injetar uma instância de GameRepository para chamada
	private GameRepository gameRepository; 
	
	@Transactional(readOnly = true) //Boa prática - garantir que a operação do banco vai acontecer
	//obedecendo aos princípios de transação (readOnly = true -> apenas leitura)
	public List<GameMinDTO> getAll(){
		List <GameMinDTO> result = gameRepository.findAll().stream().map(x -> new GameMinDTO(x)).toList(); //Transformar todo Game x para GameMinDTO
		return result;
	}
	
	@Transactional(readOnly = true)
	public GameDTO getById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
}

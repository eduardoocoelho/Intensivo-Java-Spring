package com.intensivo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intensivo.dslist.dto.GameListDTO;
import com.intensivo.dslist.projections.GameMinProjection;
import com.intensivo.dslist.repositories.GameListRepository;
import com.intensivo.dslist.repositories.GameRepository;

@Service //Registrar como componente do sistema
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository; 
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> getAll(){
		List <GameListDTO> result = gameListRepository.findAll().stream().map(x -> new GameListDTO(x)).toList();
		return result;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {

		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}

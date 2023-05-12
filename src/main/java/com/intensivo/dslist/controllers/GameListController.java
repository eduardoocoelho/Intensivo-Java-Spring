package com.intensivo.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intensivo.dslist.dto.GameListDTO;
import com.intensivo.dslist.dto.GameMinDTO;
import com.intensivo.dslist.services.GameListService;
import com.intensivo.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired //Injetar uma instância da classe GameListService para chamada
	private GameListService gameListService;
	
	@Autowired //Injetar uma instância da classe GameService para chamada
	private GameService gameService;
	
	@GetMapping //Tipo da requisição (GET)
	public List<GameListDTO> getAll(){
		List<GameListDTO> result = gameListService.getAll();
		return result; 
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> getByList(@PathVariable Long listId){ //Retornar os jogos pela lista
		List<GameMinDTO> result = gameService.getByList(listId);
		return result; 
	}
}

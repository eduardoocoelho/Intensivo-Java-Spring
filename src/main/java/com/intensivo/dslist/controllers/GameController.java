package com.intensivo.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intensivo.dslist.dto.GameMinDTO;
import com.intensivo.dslist.services.GameService;

@RestController //Configurar a classe para ser uma classe controladora
@RequestMapping(value = "/games") //Definir o valor de chamada
public class GameController {

	@Autowired //Injetar uma instância da classe GameService para chamada
	private GameService gameService;
	
	@GetMapping //Tipo da requisição (GET)
	public List<GameMinDTO> getAll(){
		List<GameMinDTO> result = gameService.getAll();
		return result; 
	}
}

package com.example.jovi.gamelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jovi.gamelist.DTO.GameDto;
import com.example.jovi.gamelist.DTO.GameListDto;
import com.example.jovi.gamelist.DTO.GameMinDto;
import com.example.jovi.gamelist.DTO.ReplacementDto;
import com.example.jovi.gamelist.servicies.GameListService;
import com.example.jovi.gamelist.servicies.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameSercive;
	
	@GetMapping
	public List<GameListDto> findAll(){
		List<GameListDto> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDto> findById(@PathVariable Long listId){
		return gameSercive.findByList(listId);
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void replace(@PathVariable Long listId, @RequestBody ReplacementDto body){
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}


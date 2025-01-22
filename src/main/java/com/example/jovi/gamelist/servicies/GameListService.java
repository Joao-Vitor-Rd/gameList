package com.example.jovi.gamelist.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jovi.gamelist.DTO.GameListDto;
import com.example.jovi.gamelist.entites.GameList;
import com.example.jovi.gamelist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll() {
		List<GameList> result = gameListRepository.findAll();

		return result.stream().map(x -> new GameListDto(x)).toList();
	}
}

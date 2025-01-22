package com.example.jovi.gamelist.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jovi.gamelist.DTO.GameDto;
import com.example.jovi.gamelist.DTO.GameMinDto;
import com.example.jovi.gamelist.entites.Game;
import com.example.jovi.gamelist.projections.GameMinProjection;
import com.example.jovi.gamelist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDto(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameDto findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDto(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findByList(Long id) {
		List<GameMinProjection> result = gameRepository.searchByList(id);
		return result.stream().map(x -> new GameMinDto(x)).toList();
	}
	
}


package com.example.jovi.gamelist.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jovi.gamelist.DTO.GameListDto;
import com.example.jovi.gamelist.entites.GameList;
import com.example.jovi.gamelist.projections.GameMinProjection;
import com.example.jovi.gamelist.repositories.GameListRepository;
import com.example.jovi.gamelist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll() {
		List<GameList> result = gameListRepository.findAll();

		return result.stream().map(x -> new GameListDto(x)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		GameMinProjection toReplace = result.remove(sourceIndex);
		result.add(destinationIndex,toReplace);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, result.get(i).getId(), i);
		}
	}
}

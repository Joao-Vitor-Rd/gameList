package com.example.jovi.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jovi.gamelist.entites.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}

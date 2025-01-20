package com.example.jovi.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jovi.gamelist.entites.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}

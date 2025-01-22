package com.example.jovi.gamelist.entites;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game_list")
public class GameList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public GameList() {}

	public GameList(Long id, String nome) {
		super();
		this.id = id;
		this.name = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameList other = (GameList) obj;
		return Objects.equals(id, other.id);
	}
	
	
}

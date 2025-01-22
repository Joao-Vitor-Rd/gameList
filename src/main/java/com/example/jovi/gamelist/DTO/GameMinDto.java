package com.example.jovi.gamelist.DTO;

import org.springframework.beans.BeanUtils;

import com.example.jovi.gamelist.entites.Game;
import com.example.jovi.gamelist.projections.GameMinProjection;

public class GameMinDto {
	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDto() {}
	
	public GameMinDto(Game entity) {
		super();
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}
	public GameMinDto(GameMinProjection projection) {
		BeanUtils.copyProperties(projection, this);
	}

	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public Integer getYear() {
		return year;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	
	
}

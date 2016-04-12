package com.dromaskin.mc.tmdbentity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class GenreSearch implements Serializable {

	private int id;
	
	private String name;
	
	public GenreSearch() {

	}
	
	public GenreSearch(int id) {
		this.id = id;
	}
	
	public GenreSearch(String name) {
		this.name = name;
	}
	
	public GenreSearch(int id, String name) {
		this.name = name;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

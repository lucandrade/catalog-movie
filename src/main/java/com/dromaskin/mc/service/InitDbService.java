package com.dromaskin.mc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dromaskin.mc.entity.Genre;

import javax.annotation.PostConstruct;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private GenreService genreService;
	
	@PostConstruct
	public void init() {
		Genre genre = new Genre();
		genre.setName("Comédia");
		genreService.save(genre);
	}
}

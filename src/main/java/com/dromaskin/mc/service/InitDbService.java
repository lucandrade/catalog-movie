package com.dromaskin.mc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dromaskin.mc.entity.Genre;

import java.util.List;

import javax.annotation.PostConstruct;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private RestService restService;
	
	@PostConstruct
	public void init() {
		List<Genre> genres = restService.genres();
		saveGenres(genres);
	}
	
	private void saveGenres(List<Genre> genres) {
		for (Genre genre : genres) {
			genreService.save(genre);
		}
	}
}

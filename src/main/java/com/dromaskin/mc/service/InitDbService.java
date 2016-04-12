package com.dromaskin.mc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dromaskin.mc.entity.Genre;
import com.dromaskin.mc.tmdbentity.GenreSearch;
import com.dromaskin.mc.tmdbentity.MovieSearch;

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
		restService.init();
		List<GenreSearch> genres = restService.genres();
		saveGenres(genres);
	}
	
	private void saveGenres(List<GenreSearch> genresSearch) {
		for (GenreSearch genreSearch : genresSearch) {
			Genre genre = new Genre();
			genre.setName(genreSearch.getName());
			genre.setTmdbId(genreSearch.getId());
			genreService.save(genre);
		}
	}
}

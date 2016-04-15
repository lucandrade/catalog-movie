package com.dromaskin.mc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dromaskin.mc.entity.Genre;
import com.dromaskin.mc.entity.Movie;
import com.dromaskin.mc.repository.GenreRepository;
import com.dromaskin.mc.repository.MovieRepository;
import com.github.slugify.Slugify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovieService {

	@Autowired
	private Slugify slugify;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	public List<Movie> all() {
		List<Movie> all = movieRepository.findAll();
		return all;
	}
	
	@Transactional
	public Movie save(Movie movie) {
		movie.setUpdatedAt(new Date());
		movie.setCreatedAt(new Date());
		movie.setSlug(slugify.slugify(movie.getTitle()));
		movieRepository.save(movie);
		return movie;
	}
	
	@Transactional
	public void bindGenres(String[] genreIds, Movie movie) {
		List<Genre> genres = new ArrayList<Genre>();
		for (String genreId : genreIds) {
			Genre genre = genreRepository.findByTmdbId(Integer.parseInt(genreId));
			
			if (genre != null) {
				genres.add(genre);
			}
		}
		movie.setGenres(genres);
		movieRepository.save(movie);
	}
}

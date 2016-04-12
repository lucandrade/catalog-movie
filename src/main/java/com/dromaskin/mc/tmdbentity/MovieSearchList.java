package com.dromaskin.mc.tmdbentity;

import java.util.List;

import com.dromaskin.mc.tmdbentity.MovieSearch;

public class MovieSearchList {

	public List<MovieSearch> results;

	public List<MovieSearch> getMovies() {
		return results;
	}

	public void setMovies(List<MovieSearch> movies) {
		results = movies;
	}
}

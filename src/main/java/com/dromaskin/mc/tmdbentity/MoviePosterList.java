package com.dromaskin.mc.tmdbentity;

import java.util.List;

public class MoviePosterList {

	private List<MoviePoster> posters;

	public List<MoviePoster> getPosters() {
		return posters;
	}

	public void setPosters(List<MoviePoster> posters) {
		this.posters = posters;
	}
	
	public MoviePoster getSmaller() {
		MoviePoster smaller = null;
		for (MoviePoster moviePoster : posters) {
			if (smaller == null) {
				smaller = moviePoster;
			}
			if (moviePoster.getWidth() < smaller.getWidth()) {
				smaller = moviePoster;
			}
		}
		return smaller;
	}
}

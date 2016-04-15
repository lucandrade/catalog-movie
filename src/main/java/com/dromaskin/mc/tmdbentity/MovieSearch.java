package com.dromaskin.mc.tmdbentity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, value = {"poster"})
public class MovieSearch implements Serializable {

	private int id;
	
	private int tmdbId;
	
	private String overview;
	
	private String title;
	
	private int vote_count;
	
	private double vote_average;
	
	private Date release_date;
	
	private Date released_date;

	private List<GenreSearch> genres;
	
	private List<GenreSearch> genre_ids;

	private MoviePoster poster;
	
	private String posterUrl;
	
	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public MoviePoster getPoster() {
		return poster;
	}

	public void setPoster(MoviePoster poster) {
		this.poster = poster;
	}
	
	public void setGenre_ids(List<GenreSearch> genres) {
		genre_ids = genres;
	}
	
	public List<GenreSearch> getGenres() {
		return genres == null ? genre_ids : genres;
	}
	
	public void setTmdbId(int id) {
		this.tmdbId = id;
	}
	
	public int getTmdbId() {
		return tmdbId;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getVoteCount() {
		return vote_count;
	}

	public void setVoteCount(int vote_count) {
		this.vote_count = vote_count;
	}

	public double getVoteAverage() {
		return vote_average;
	}

	public void setVoteAverage(double vote_average) {
		this.vote_average = vote_average;
	}

	public Date getReleaseDate() {
		return release_date;
	}

	public void setReleaseDate(Date release_date) {
		this.release_date = release_date;
	}
	
	public Date getReleased_date() {
		return released_date;
	}

	public void setReleasedDate(Date released_date) {
		this.released_date = released_date;
	}
	
	public void setRelease_date(String release_date) {
		if (release_date != null && !release_date.isEmpty()) {
			try {
				this.release_date = new SimpleDateFormat("yyyy-MM-dd").parse(release_date);
			} catch (ParseException e) {
				
			}
		}
	}
}

package com.dromaskin.mc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Size;

@Entity
public class Movie implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="tmdb_id")
	private int tmdbId;
	
	@Size(min=3, message="O título do filme deve ter no mínimo 3 caracteres")
	private String title;
	
	private String slug;
	
	@Column(name="released_date")
	private Date releasedDate;
	
	private int runtime;
	
	@Size(min=3, message="O diretor do filme deve ter no mínimo 3 caracteres")
	private String director;
	
	@Lob
	@Column(length=Integer.MAX_VALUE)
	private String overview;
	
	private String poster;
	
	@Column(name="imdb_votes")
	private int imdbVotes;
	
	@Column(name="imdb_rating", precision=2)
	private double imdbRating;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;

	public long getTmdbId() {
		return tmdbId;
	}

	public void setTmdbId(int tmdbId) {
		this.tmdbId = tmdbId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Date getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(Date releasedDate) {
		this.releasedDate = releasedDate;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public double getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
